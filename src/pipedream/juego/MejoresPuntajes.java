/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pipedream.juego;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jovitali
 */
public class MejoresPuntajes implements Serializable {
    private final List<Jugador> puntajes;
    
    public MejoresPuntajes(){
        puntajes = new LinkedList<>();
    }
    
    public boolean addPuntaje(Jugador jug){
        int i = 0;
        for(Jugador top : puntajes){
            
            if(top.getPuntaje() <= jug.getPuntaje()){
                puntajes.add(i, jug);
                if(puntajes.size() == 6){
                    puntajes.remove(5);
                }
                return true;
            }
            i++;
        }
        if(i < 5){
            puntajes.add(i, jug);
            return true;
        }
        
        return false;
    }
    
    public String puntajes(){
        String p = "";
        for(Jugador jug : puntajes){
            p = p.concat(jug.toString() + "\n");
        }
        return p;
    }
    
    public void save(){
        try {
            FileOutputStream fileOut;
            fileOut = new FileOutputStream("puntajes.pd");
            ObjectOutputStream out;
            out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        } catch (IOException i) {
        }
    }
}
