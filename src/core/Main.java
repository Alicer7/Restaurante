package core;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import gui.Splash;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author freddy
 */
public class Main {
    
    public static void main(String[] args) {
        try { 
            UIManager.setLookAndFeel("com.alee.laf.WebLookAndFeel"); 
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ignored){}
        
        Splash gui = new Splash();
//        MenuPrincipal_ gui = new MenuPrincipal_();
        gui.pack();
        gui.setVisible(true); //Create and show the GUI.
    }
        
}
