/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipedream.canios;

/**
 *
 * @author Francisco
 */
public abstract class Canio {
    private final Direccion extremo1;
    private final Direccion extremo2;
    private Direccion entrada = null;
    private Direccion salida = null;
    private int cantAgua = 0;
    private final String tipoDeCanio;

    public Canio(Direccion d1, Direccion d2, String s){
        extremo1 = d1;
        extremo2 = d2;
        tipoDeCanio = s;
    }
    
    public enum Direccion{
        ARRIBA,
        ABAJO,
        DERECHA,
        IZQUIERDA
    };
    
    public void llenar(){
        cantAgua++;
    }
    

    public Direccion getEntrada(){
        return this.entrada;
    }
    
    public Direccion getSalida(){
        return this.salida;
    }
    
    public void setEntrada(Direccion entrada){
        this.entrada = entrada;
    }
    
    public void setSalida(Direccion salida){
        this.salida = salida;
    }
    
    public Direccion getExtremo1(){
        return this.extremo1;
    }
    
    public Direccion getExtremo2(){
        return this.extremo2;
    }
    
    public int getCantAgua(){
        return cantAgua;
    }
    
    @Override
    public String toString(){
        if(entrada == null)
            return tipoDeCanio + "Vacio";
        if(cantAgua == 4)
            return tipoDeCanio + "Lleno";
        return tipoDeCanio + entrada + cantAgua;
       
    }
    
}
