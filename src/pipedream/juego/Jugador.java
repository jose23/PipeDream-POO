/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipedream.juego;

import java.io.Serializable;

/**
 *
 * @author Francisco
 */
public class Jugador implements Serializable{
    private final String nombre;
    private int puntaje = 0;
    
    public Jugador(String nombre){
        this.nombre = nombre;
    }
    
    public int getPuntaje(){
        return this.puntaje;
    }
    
    public String getNombre(){
        return this.nombre;
    }

    @Override
    public String toString() {
        return this.nombre + ": " + this.puntaje; 
    }
    
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
