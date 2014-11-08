/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipedream.juego;

import pipedream.canios.Canio.Direccion;

/**
 *
 * @author Francisco
 */
public class Jugada {
    private final int x;
    private final int y;
    private final Direccion d;
    
    public Jugada(int x, int y, Direccion d){
        this.x = x;
        this.y = y;
        this.d = d;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direccion getDireccion() {
        return d;
    }
    
    
}
