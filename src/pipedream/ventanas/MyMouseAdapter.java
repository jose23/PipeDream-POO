/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipedream.ventanas;

import java.awt.event.MouseAdapter;

/**
 *
 * @author Usuario
 */
public class MyMouseAdapter extends MouseAdapter{
    
    private final VentJuego ventana;
    private final int i;
    private final int j;
    
    MyMouseAdapter(VentJuego ventana, int i, int j){
        this.ventana = ventana;
        this.i = i;
        this.j = j;
    }
    
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
    ventana.casilleroMouseClicked(evt, i , j);
    }
    
}
