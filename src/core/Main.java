package core;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import gui.MenuPrincipal;

/**
 *
 * @author freddy
 */
public class Main {
    
    public static void main(String[] args) {
        MenuPrincipal gui = new MenuPrincipal();
        gui.pack();
        
        gui.setVisible(true);
    }
}
