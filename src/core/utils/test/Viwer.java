/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.utils.test;

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
import javax.swing.SwingUtilities;

/**
 *
 * @author Freddy Camposeco <ankoku.fj@gmail.com> <www.stufs.rf.gd>
 */
public class Viwer {
    private static final JFXPanel fxPanel = new JFXPanel();
    
    public Viwer() {
    }

    public static void initAndShowGUI() {
        // This method is invoked on the EDT thread
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(300, 588);
        frame.setBackground(java.awt.Color.black);
        panel.add(fxPanel);
        panel.setBackground(java.awt.Color.blue);
        frame.add(panel);
        frame.setVisible(true);

        Platform.runLater(() -> {
            initFX();
        });
    }

    public static void initFX() {
        // This method is invoked on the JavaFX thread
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }

    public static Scene createScene() {
        WebView browser = new WebView();
        WebEngine webEngine = new WebEngine();
        
        String url = "http://www.stufs.rf.gd";
        String html = "<html><h1>Hello</h1><h2>Hello</h2></html>";
        
//        webEngine.load(url);
        webEngine.loadContent(html);
        
        
        Group root = new Group();
        Scene scene = new Scene(root, Color.BLUEVIOLET);
        Text text = new Text();
        
        text.setX(40);
        text.setY(100);
        text.setFont(new Font(25));
        text.setText("Welcome JavaFX!");

        root.getChildren().add(text);

        return (scene);
    }
    
    public static JFXPanel getFxPanel() {
        return fxPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            initAndShowGUI();
        });
    }
}

