package core;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import gui.MenuPrincipal;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author freddy
 */
public class Main {
    
    public static void main(String[] args) {
        MenuPrincipal gui = new MenuPrincipal();
        gui.pack();
        gui.setVisible(true); //Create and show the GUI.
    }
        
}
