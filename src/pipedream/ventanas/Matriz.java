/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipedream.ventanas;

import javax.swing.JLabel;

/**
 *
 * @author Francisco
 */
public class Matriz {
    private final JLabel[][] matriz;
    
    public Matriz(){
        matriz = new JLabel[10][10];
    }
    
    public void addLabel(int i, int j, JLabel label){
        matriz[i][j] = label;
    }
    
    public JLabel getLabel(int i, int j){
        return matriz[i][j];
    }
}
