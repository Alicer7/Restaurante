/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.utils.engine;

import core.utils.themplate.Detalle;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

/**
 *
 * @author Administrador
 */
public class WebEngineX {
    private final Detalle detalle = new Detalle();
    private Double TOTAL;
    private JFXPanel jFxPanel;
    private Scene scene;
    private WebView webView;
    private Printer printer;
    private String html;
    
    
    
    private void showInViewer() {
        Platform.runLater(() -> {
            webView.getEngine().loadContent(html);
        });
    }
    
    private void cleanViewer (){
        setDetalleClean ();
        showInViewer();
    }
    
    private void startViewer (){
        html = detalle.getDetalleClean();
        jFxPanel = new JFXPanel();
        System.err.println("StartViewer > Detalle > JFXPanel ");
    }
    
    public void setDetalleClean (){
        this.html = detalle.getDetalleClean();
    }
     
    public void loadViewer (){
        Platform.runLater(() -> {
            webView = new WebView();
            webView.getEngine().loadContent(html);
            scene = new Scene(webView,250,300);
            jFxPanel.setScene(scene);
        });
    }
    
/*
*   @Muestra el mensaje por defecto en el visor de detalles */
    public void putDefauiltInViewer (){
        cleanViewer ();
    }
    public void showInViewer(String html) {
        Platform.runLater(() -> {
            webView = new WebView();
            webView.getEngine().setJavaScriptEnabled(true);
            webView.getEngine().load(html);
//            webView.getEngine().loadContent(html);
            scene = new Scene(webView,250,300);
            jFxPanel.setScene(scene);
        });
    }
    public void mostrarDetalle(Integer FACTURAID) {
        cleanViewer ();
        detalle.setFACTURAID(FACTURAID);
        detalle.setDetalleNull ();
        html = detalle.getDetalleHTML(FACTURAID);
        showInViewer ();
    }
    
    public Double mostrarDetalleD(Integer FACTURAID) {
        cleanViewer ();
        detalle.setFACTURAID(FACTURAID);
        detalle.setDetalleNull ();
        html = detalle.getDetalleHTML(FACTURAID);
        TOTAL = detalle.getTOTAL();
        showInViewer ();
        return TOTAL;
    }
    
    public Double getTOTAL() {
        TOTAL = detalle.getTOTAL();
        return TOTAL;
    }
    
/******************************************************************************/
    
    public WebEngineX() {
        startViewer ();
    }
    
/*
*   @return *******************************************************************/

    public JFXPanel getjFxPanel() {
        return jFxPanel;
    }

    public void print() {
        
        try {
            PrinterJob job = PrinterJob.createPrinterJob();
            job.getJobSettings().setJobName(webView.getEngine().getTitle());
//            job.getJobSettings().getPageLayout().
            
            if (job != null) {
                    webView.getEngine().print(job);
                    job.endJob();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    public void printNode() {
        Node node = webView;
        Printer printer = Printer.getDefaultPrinter();
               
        PageLayout pageLayout = printer.createPageLayout(printer.getDefaultPageLayout().getPaper(), PageOrientation.PORTRAIT, Printer.MarginType.HARDWARE_MINIMUM);
        
        double scaleX = pageLayout.getPrintableWidth() / node.getBoundsInParent().getWidth();
        double scaleY = pageLayout.getPrintableHeight() / node.getBoundsInParent().getHeight();
        
        double top = pageLayout.getTopMargin();
        double bot = pageLayout.getBottomMargin();
        double rgt = pageLayout.getRightMargin();
        double lef = pageLayout.getLeftMargin();
        
        System.out.println("Margins: T:"+top+" B:"+bot+" R:"+rgt+" L:"+lef);        
        
//        node.getTransforms().add(new Scale(scaleX, scaleY));
//        System.out.println("Scale "+scaleX+" @ "+scaleY);
        
        try {
            PrinterJob job = PrinterJob.createPrinterJob();
            System.out.println("core.utils.engine.WebEngineX.printNode().1");
            job.getJobSettings().setJobName(webView.getEngine().getTitle());
            System.out.println("core.utils.engine.WebEngineX.printNode().2");
            if (job != null) {
                boolean success = job.printPage(node);
                System.out.println("core.utils.engine.WebEngineX.printNode().3");
                if (success) {
                    job.endJob();
                    System.out.println("core.utils.engine.WebEngineX.printNode().4");
                }
            }
        } catch (Exception e) {
            System.err.println("Print Node: "+e);
        }
    }
  
/******************************************************************************/
}
