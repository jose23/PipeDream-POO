/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipedream.canios;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 *
 * @author Francisco
 */
public class ColaCanios {
    
    private final Queue<Canio> cola;
    
    public ColaCanios(){
        cola = new LinkedList<>();
        
        for(int i = 0; i < 5; i++){
            addCanio();
        }    
    }
    
    private void addCanio(){
        cola.add(dameCanio());
    }
    
    private Canio dameCanio(){
        Random rand;
        rand = new Random();
        int r = Math.abs(rand.nextInt()%6);
        switch(r){
            case 0: return new CanioHorizontal();
            case 1: return new CanioVertical();
            case 2: return new CanioDoblado1();
            case 3: return new CanioDoblado2();
            case 4: return new CanioDoblado3();
            case 5: return new CanioDoblado4();
        }
        
        return null;
                
    }
    
    public Canio getCanio(){
        addCanio();
        return cola.poll();
    }
    
    public Queue<Canio> getCola(){
        return cola;
    }
    
}
