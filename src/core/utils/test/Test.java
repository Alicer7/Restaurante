/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.utils.test;

import static core.utils.test.Viwer.createScene;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Freddy Camposeco <ankoku.fj@gmail.com> <www.stufs.rf.gd>
 */
public class Test {
    
    private JFXPanel fxPanel;

    public Test() {
    }

    public JFXPanel getFxPanel() {
        WebView browser = new WebView();
        WebEngine webEngine = new WebEngine();
        
        
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(300, 588);
        frame.setBackground(java.awt.Color.black);
        panel.add(fxPanel);
        panel.setBackground(java.awt.Color.blue);
        frame.add(panel);
        frame.setVisible(true);
        
        Scene scene = createScene();
        fxPanel.setScene(scene);
        
        String url = "http://www.stufs.rf.gd";
        String html = "<html><h1>Hello</h1><h2>Hello</h2></html>";
        
//        webEngine.load(url);
        webEngine.loadContent(html);
        
        
        Group root = new Group(); 
        
        scene = new Scene(root, Color.BLUEVIOLET);

        root.getChildren().add(browser);

        
        return fxPanel;
    }    
}
