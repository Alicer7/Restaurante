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
            webView.getEngine().loadContent(html);
        });
    }
    public void mostrarDetalle(Integer FACTURAID) {
        cleanViewer ();
        detalle.setFACTURAID(FACTURAID);
        detalle.setDetalleNull ();
        html = detalle.getDetalleHTML(FACTURAID);
        showInViewer ();
    }
    
    public Double getTOTAL() {
        TOTAL = detalle.getTOTAL();
        return TOTAL;
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
        
//        Integer INCH = 72;
//        Double mWidth= 3.15;
//        Double mHeight= 11.00;
//        Double mMargin = 0.0;
//        Rectangle2D mImageableArea;
//        mImageableArea = new Rectangle2D.Double(
//            INCH, INCH,
//            mWidth - mMargin * INCH,
//            mHeight - mMargin * INCH
//        );
    
        
                
        try {
            
            PrinterJob job = PrinterJob.createPrinterJob();
            job.getJobSettings().setJobName(webView.getEngine().getTitle());
            
//            PageLayout pageLayout = Printer.getDefaultPrinter().getDefaultPageLayout();
//            job.getJobSettings().setPageLayout(pageLayout);
            
            if (job != null) {
//                boolean success = false;
//                    boolean success = job.printPage(webView);
//                    success = job.printPage(webView);
                    webView.getEngine().print(job);
                    job.endJob();
//                if (success) {
//                    job.endJob();
//                    System.err.println("JOB: "+job);
//                }
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
/******************************************************************************/
}
