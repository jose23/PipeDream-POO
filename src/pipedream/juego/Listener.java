/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipedream.juego;

/**
 *
 * @author Usuario
 */
public interface Listener {
    public void notifyOfThreadComplete();
    public void changeImage(Jugada jugada);
}
