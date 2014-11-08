/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipedream.canios;

import pipedream.canios.Canio.Direccion;
import pipedream.juego.Jugada;

/**
 *
 * @author Francisco
 */
public class Tablero {
    private final Canio [][] tablero;
    private final Canio canioInicial;
    private int cantidadCanios = 1;
    private int cantidadCaniosLlenos = 0;
    
    public Tablero() {
        this.tablero = new Canio[10][10];
        canioInicial = new CanioHorizontal();
        tablero[0][0] = canioInicial;
        canioInicial.setEntrada(Direccion.IZQUIERDA);
        canioInicial.setSalida(Direccion.DERECHA);
    }
    
    public boolean agregarCanio(int x, int y, Canio c){
            if(tablero[x][y] == null || tablero[x][y].getCantAgua() == 0){
                tablero[x][y] = c;
                cantidadCanios++;
                return true;
        }
            return false;
    }
    
    public Jugada proxJugada(int x, int y){
        cantidadCaniosLlenos++;
        Direccion salida = tablero[x][y].getSalida();
        int i = 0, j = 0;
        Direccion entradaSig = null;
        switch(salida){
            case IZQUIERDA:
                j = y - 1;
                i = x;
                entradaSig = Direccion.DERECHA;
                break;
            case DERECHA:
                j = y + 1;
                i = x;
                entradaSig = Direccion.IZQUIERDA;
                break;
            case ABAJO:
                j = y;
                i = x + 1;
                entradaSig = Direccion.ARRIBA;
                break;
            case ARRIBA:
                j = y;
                i = x - 1;
                entradaSig = Direccion.ABAJO;
                break;
        }
        
        Jugada jugada = new Jugada(i, j, entradaSig);
        return jugada;
        
    }
    
    public boolean dentroDelTablero(int i, int j){
    
    return !(i < 0 || i > 9 || j < 0 || j > 9);
    }
    
    public boolean canioCompatible(int i, int j, Direccion d){
        if(tablero[i][j].getExtremo1().equals(d)){
            tablero[i][j].setEntrada(d);
            tablero[i][j].setSalida(tablero[i][j].getExtremo2());
            return true;
        }
        else if(tablero[i][j].getExtremo2().equals(d)){
            tablero[i][j].setEntrada(d);
            tablero[i][j].setSalida(tablero[i][j].getExtremo1());
            return true;
        }
        else
            return false;
    }

    public boolean hayCanio(int i, int j){
        return tablero[i][j] != null;
    }
    
    public Canio getCanioInicial(){
        return canioInicial;
    }

    public Canio[][] getTablero(){
        return tablero;
    }

    public int getCantidadCanios() {
        return cantidadCanios;
    }

    public int getCantidadCaniosLlenos() {
        return cantidadCaniosLlenos;
    }
    
    
}
