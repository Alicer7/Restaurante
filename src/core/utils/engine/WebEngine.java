/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.utils.engine;

import core.utils.themplate.Detalle;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

/**
 *
 * @author Administrador
 */
public class WebEngine {
    private Printer printer;
    private final Detalle detalle = new Detalle();
    private JFXPanel jFxPanel;
    private Scene scene;
    private WebView webView;
    private String html;
    
    public void setDetalleNull (){
        this.html = "";
        System.err.println("set HTML Null: "+this.html+" END");
    }
    
    private void cleanViewer (){
        setDetalleNull ();
        Platform.runLater(() -> {
            webView.getEngine().loadContent(html);
        });
    }
    
    private void showInViewer() {
        Platform.runLater(() -> {
            webView.getEngine().loadContent(html);
        });
    }
    
    private void startViewer (){
        html = detalle.getDetalleClean();
        jFxPanel = new JFXPanel();
        
    }
     
    public void loadViewer (){
        Platform.runLater(() -> {
            webView = new WebView();
            webView.getEngine().loadContent(html);
            scene = new Scene(webView,250,300);
            jFxPanel.setScene(scene);
        });
    }
    
    public void showInViewer(String html) {
        Platform.runLater(() -> {
            webView.getEngine().loadContent(html);
        });
    }
    public void mostrarDetalle(Integer FACTURAID) {
        cleanViewer ();
        detalle.setDetalleNull ();
        System.out.println("core.utils.engine.WebEngine.mostrarDetalle()");
        this.html = detalle.getDetalleHTML(FACTURAID);
        System.err.println("get Html");
        showInViewer ();
    }
    
/******************************************************************************/
    
    public WebEngine() {
        startViewer ();
    }
    
/*
*   @return *******************************************************************/

    public JFXPanel getjFxPanel() {
        return jFxPanel;
    }

    public void print() {
        
//        printer.createPageLayout(
//                Paper.A0, 
//                PageOrientation.PORTRAIT, 
//                Printer.MarginType.EQUAL
//        );
        
        try {
            PrinterJob job = PrinterJob.createPrinterJob();
            if (job != null) {
                boolean success = job.printPage(webView);
                if (success) {
                    job.endJob();
                }
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
/******************************************************************************/
}
