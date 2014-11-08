/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipedream.ventanas;

import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;

/**
 *
 * @author Francisco
 */
public class Imagenes {
    private final Map<String,ImageIcon> mapa;
    
    public Imagenes(){
        mapa = new HashMap<>();
    }
    
    public ImageIcon getImagen(String nombre){
        
        if(mapa.containsKey(nombre))
            return mapa.get(nombre);
        
        ImageIcon imagen = new javax.swing.ImageIcon(getClass().getResource(nombre));
        mapa.put(nombre, imagen);
        return imagen;
    }
    
}
