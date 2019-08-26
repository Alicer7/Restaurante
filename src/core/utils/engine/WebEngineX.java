/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.utils.engine;

import core.utils.themplate.Detalle;
import gui.login.OnDemandLogin;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.transform.Scale;
import javafx.scene.web.WebView;

/**
 *
 * @author Administrador
 */
public class WebEngineX{
    private final Detalle detalle = new Detalle();
    private boolean esDetalle;
    private Integer FACTURAID;
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
        setDetalleClean();
        showInViewer();
    }
    
    private void startViewer (){
        setDetalleClean();
        jFxPanel = new JFXPanel();
        System.out.println("WebEngineX > StartViewer >> JFXPanel ");
    }
    
    private boolean esSolvente(){
        if (FACTURAID==null){
            return true;
        } else {
            boolean es;
            es = detalle.esSolventeFactura(FACTURAID);
            System.out.println("WebEngineX > loadViewer > Es Solvente: "+String.valueOf(es));
            return es;            
        }
    }
    
    private void onDemandLogin(){
        OnDemandLogin L = new OnDemandLogin("AnularFactura",FACTURAID);
        L.setVisible(true);
    }
    
    private boolean createContextMenuAnularFactura() {
        
        try {
            Image anularFacturaIcon = new Image(getClass().getResourceAsStream("/core/resources/icons/eliminar.png"));
            ImageView anularFacturaView = new ImageView(anularFacturaIcon);
            anularFacturaView.setFitWidth(24);
            anularFacturaView.setFitHeight(24);
            ContextMenu contextMenu = new ContextMenu();
            MenuItem anularFactura = new MenuItem("Anular Factura");
            anularFactura.setOnAction(e -> onDemandLogin());
            anularFactura.setGraphic(anularFacturaView);
            contextMenu.getItems().addAll(anularFactura);

            webView.setOnMousePressed(e -> {
                if (e.getButton() == MouseButton.SECONDARY) {
                    contextMenu.show(webView, e.getScreenX(), e.getScreenY());
                } else {
                    contextMenu.hide();
                }
            });
            return detalle.isFacturaAnuladaSucces();
        } catch (Exception e) {
            return false;
        }
    }
    
    public void setDetalleClean (){
        html = detalle.getDetalleClean();
    }
    
    public void addDescuentoDetalle(Double DESCUENTO){
        cleanViewer();
        detalle.setDetalleNull();
        detalle.setDescuento(DESCUENTO);
        html = detalle.getDetalleHTML(FACTURAID);
        System.out.println("WebEngineX > addDescuentoDetalle >> "+FACTURAID+" Descuento: "+DESCUENTO);
        showInViewer(html);
    }
    
    public void loadViewer (boolean esDetalle){
        this.esDetalle=esDetalle;
        Platform.runLater(() -> {
            webView = new WebView();
            webView.getEngine().loadContent(html);
            webView.setContextMenuEnabled(false);
            System.out.println("WebEngineX > loadViewer > setContextMenuEnable >> off");
            if (esDetalle == true && esSolvente() == false ){
                System.out.println("WebEngineX > loadViewer >> passed");
                createContextMenuAnularFactura();
            }
            scene = new Scene(webView,70,300);
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
    
    public Double getTOTAL() {
        TOTAL = detalle.getTOTAL();
        return TOTAL;
    }
    
    public Double mostrarDetalleD(Integer FACTURAID) {
        this.FACTURAID = FACTURAID;
        cleanViewer();
        detalle.setDetalleNull();
        detalle.setFACTURAID(FACTURAID);
        html = detalle.getDetalleHTML(FACTURAID);
        showInViewer();
        if (esDetalle == true && esSolvente() == false ){
            System.out.println("WebEngineX > mostrarDetalleD >> passed");
            createContextMenuAnularFactura();
        }
        
        return getTOTAL();
    }
    
    public void mostrarDetalle(Integer FACTURAID) {
        this.FACTURAID = FACTURAID;
        cleanViewer();
        detalle.setDetalleNull();
        detalle.setFACTURAID(FACTURAID);
        html = detalle.getDetalleHTML(FACTURAID);
        if (esDetalle == true && esSolvente() == false ){
            System.out.println("WebEngineX > mostrarDetalle >> passed");
            createContextMenuAnularFactura();
        }
        showInViewer();
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
            System.err.println("WebEngineX > print >> Error: "+e);
        }
    }
    
    
    
    public void printNode() {
        Node node = webView;
        Printer printX = Printer.getDefaultPrinter();
        
        PageLayout pageLayout = printX.createPageLayout(printX.getDefaultPageLayout().getPaper(), PageOrientation.PORTRAIT, Printer.MarginType.HARDWARE_MINIMUM);

        double scaleX = pageLayout.getPrintableWidth() / node.getBoundsInParent().getWidth();
        node.getTransforms().add(new Scale(scaleX, scaleX));
        
        try {
            PrinterJob job = PrinterJob.createPrinterJob();
            job.getJobSettings().setJobName(webView.getEngine().getTitle());
            job.getJobSettings().setPageLayout(pageLayout);
            if (job != null) {
                boolean success = job.printPage(node);
                if (success) {
                    job.endJob();
                    System.out.println("WebEngineX > printNode >>Print Successfull");
                }
            }
        } catch (Exception e) {
            System.err.println("WebEngineX > printNode > Error: "+e);
        }
    }

/******************************************************************************/
}
