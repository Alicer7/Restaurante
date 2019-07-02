/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.utils.test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class XWebView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        WebView webView = new WebView();

        webView.getEngine().load("http://google.com");

        VBox vBox = new VBox(webView);
        Scene scene = new Scene(vBox, 300, 600);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
