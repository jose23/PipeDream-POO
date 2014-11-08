/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipedream.juego;

import java.util.logging.Level;
import java.util.logging.Logger;
import pipedream.canios.Canio;
import pipedream.canios.Canio.Direccion;
import pipedream.canios.Tablero;
import pipedream.juego.Juego.EstadoDeJuego;

/**
 *
 * @author Francisco
 */
public class Llenador extends Thread{
    
    private final Tablero tablero;
    private EstadoDeJuego estado = EstadoDeJuego.SIGUE;
    private final Listener listener;
    private boolean apurado = false;
    private boolean pausa = false;
    
    
    public Llenador(String nombre, Tablero tablero, Listener listener){
        this.tablero = tablero;
        this.listener = listener;
    }
    
    @Override
    public void run(){
        try{
            Canio canio = tablero.getCanioInicial();
            canio.llenar();
            Jugada jugada = new Jugada(0, 0, Canio.Direccion.IZQUIERDA);
            for (int i = 0; i < 100 && estado != EstadoDeJuego.SALIO && !apurado; i++) {
                try {
                    this.pausa();
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Llenador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            while(estado == EstadoDeJuego.SIGUE){
                
                for(int i = 0; canio.getCantAgua() < 4 && estado != EstadoDeJuego.SALIO; i++){
                        this.pausa();
                    try {
                        canio.llenar();
                        listener.changeImage(jugada);
                        Thread.sleep(apurado ? 50 : 700);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Llenador.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                }
                if(estado != EstadoDeJuego.SALIO){
                    jugada = tablero.proxJugada(jugada.getX(), jugada.getY());
                    estado = this.ChequeaEstado(jugada);
                    if(estado == EstadoDeJuego.SIGUE)
                        canio = tablero.getTablero()[jugada.getX()][jugada.getY()];
                }
            }
        }finally{
            listener.notifyOfThreadComplete();
        }
    }
    
    
    private EstadoDeJuego ChequeaEstado(Jugada j){
        int x = j.getX(), y = j.getY();
        Direccion direccion = j.getDireccion();
        
        if(tablero.dentroDelTablero(x, y) == false){
            return EstadoDeJuego.GANO;
        }
        if(tablero.hayCanio(x, y) == false){
            return EstadoDeJuego.PERDIO;
        }
        if(tablero.canioCompatible(x, y, direccion) == false){
            return EstadoDeJuego.PERDIO;
        }
        return EstadoDeJuego.SIGUE;
    }
    
    public EstadoDeJuego getEstado(){
        return this.estado;
    }
    
    protected void apurar(){
        apurado = true;
    }
    
    public void pausar(){
        pausa = !pausa;
    }
    
    private void pausa(){
        while(pausa){
            try {
                sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Llenador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public boolean getPausa(){
        return this.pausa;
    }
    
    public void salir(){
        estado = EstadoDeJuego.SALIO;
    }
}
