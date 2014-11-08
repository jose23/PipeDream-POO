/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipedream.juego;


import java.util.Queue;
import pipedream.canios.Canio;
import pipedream.canios.ColaCanios;
import pipedream.canios.Tablero;

/**
 *
 * @author Francisco
 */
public class Juego implements Listener {
    
    private final Tablero tablero;
    private final Jugador jugador;
    private final ColaCanios cola;
    private final Llenador llenador;
    private final MejoresPuntajes mp;
    private final Listener listener;
    
    public Juego(Jugador jugador, MejoresPuntajes mp, Listener listener){
        this.jugador = jugador;
        tablero = new Tablero();
        cola = new ColaCanios();
        this.mp = mp;
        llenador = new Llenador("llenador", tablero, this);
        this.listener = listener;
    }
    
    public boolean agregarCanio(int x, int y){
        return tablero.agregarCanio(x, y, cola.getCanio());
    }

    @Override
    public void notifyOfThreadComplete() {
        finDelJuego();
        listener.notifyOfThreadComplete();        
    }
    
    private void finDelJuego(){
        if(llenador.getEstado() == EstadoDeJuego.GANO){
            jugador.setPuntaje(this.calculaPuntaje());
            if(mp.addPuntaje(jugador)){
                mp.save();
            }
        }
    }
    
    public void jugar(){
        llenador.start();
    }

    @Override
    public void changeImage(Jugada jugada) {
        listener.changeImage(jugada);
    }

    
    public enum EstadoDeJuego{
        GANO,
        PERDIO,
        SIGUE,
        SALIO
    }
    
    public Tablero getTablero(){
        return this.tablero;
    }
    
    public EstadoDeJuego getEstado(){
        return llenador.getEstado();
    }
    
    private int calculaPuntaje(){
        int suma = tablero.getCantidadCaniosLlenos() * 100;
        int resta = tablero.getCantidadCanios() - tablero.getCantidadCaniosLlenos();
        return suma - resta * 10;
    }
    
    public void apurar(){
        llenador.apurar();
    }
    
    public Queue<Canio> getCola(){
        return cola.getCola();
    }
    
    public void pausar(){
        llenador.pausar();
    }
    
    public boolean getPausa(){
        return llenador.getPausa();
    }
    
    public void salir(){
        llenador.salir();
    }
}
