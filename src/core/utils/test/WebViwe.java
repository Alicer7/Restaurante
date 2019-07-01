/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.utils.test;

import java.awt.Dimension;
import java.awt.EventQueue;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javax.swing.JFrame;

public class WebViwe {

    private void display() {
        JFrame f = new JFrame("WebViwer");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFXPanel jfxPanel = new JFXPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(320, 240);
            }
        };
        initJFXPanel(jfxPanel);
        f.add(jfxPanel);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private void initJFXPanel(JFXPanel jfxPanel) {
        Platform.runLater(() -> {
            Label label = new Label(
                System.getProperty("os.name") + " v"
                + System.getProperty("os.version") + "; Java v"
                + System.getProperty("java.version"));
            label.setBackground(new Background(new BackgroundFill(
                Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            StackPane root = new StackPane();
            root.getChildren().add(label);
            Scene scene = new Scene(root);
            jfxPanel.setScene(scene);
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new WebViwe()::display);
    }
}
