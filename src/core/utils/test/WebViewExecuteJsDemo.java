/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.utils.test;

/**
 *
 * @author Freddy Camposeco <ankoku.fj@gmail.com> <www.stufs.rf.gd>
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
 
public class WebViewExecuteJsDemo extends Application {
 
   // A HTML Content with a javascript function.
   private static String HTML_STRING = //
           "<html>"//
                   + "<head> " //
                   + "  <script language='javascript'> " //
                   + "     function changeBgColor()  { "//
                   + "       var color= document.getElementById('color').value; "//
                   + "       document.body.style.backgroundColor= color; " //
                   + "     } " //
                   + "  </script> "//
                   + "</head> "//
                   + "<body> "//
                   + "   <h2>This is Html content</h2> "//
                   + "   <b>Enter Color:</b> "//
                   + "   <input id='color' value='yellow' /> "//
                   + "   <button onclick='changeBgColor();'>Change Bg Color</button> "//
                   + "</body> "//
                   + "</html> "//
   ;
 
   @Override
   public void start(final Stage stage) {
 
       Button button = new Button("Execute Javascript (Call from JavaFX)");
 
       final WebView browser = new WebView();
       final WebEngine webEngine = browser.getEngine();
 
       // Enable Javascript.
       webEngine.setJavaScriptEnabled(true);
 
       webEngine.loadContent(HTML_STRING);
 
       button.setOnAction(new EventHandler<ActionEvent>() {
 
           @Override
           public void handle(ActionEvent event) {
               // Call a JavaScript function of the current page
               webEngine.executeScript("changeBgColor();");
           }
       });
 
       VBox root = new VBox();
       root.setPadding(new Insets(5));
       root.setSpacing(5);
       root.getChildren().addAll(button, browser);
 
       Scene scene = new Scene(root);
 
       stage.setTitle("JavaFX WebView (o7planning.org)");
       stage.setScene(scene);
       stage.setWidth(300);
       stage.setHeight(600);
 
       stage.show();
   }
 
   public static void main(String[] args) {
       launch(args);
   }
 
}
