/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.utils.engine;

import core.utils.themplate.Detalle;
import gui.login.OnDemandLogin;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.transform.Scale;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class WebEngineX extends Application{
    private final Detalle detalle = new Detalle();
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
        setDetalleClean ();
        showInViewer();
    }
    
    private void startViewer (){
        setDetalleClean ();
        jFxPanel = new JFXPanel();
        System.err.println("StartViewer > Detalle > JFXPanel ");
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
    
    public void addDescuentoDetalle(Double descuento){
        cleanViewer ();
        detalle.setDescuento(descuento);
        html = detalle.getHTML();
        System.err.println("Descuento.3");
        showInViewer();
    }
    
    public void loadViewer (boolean esDetalle){
        Platform.runLater(() -> {
            webView = new WebView();
            webView.getEngine().loadContent(html);
            webView.setContextMenuEnabled(false);
            System.err.println("setContextMenuEnable >> off");
            if (esDetalle == true){
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
            webView = new WebView();
            webView.getEngine().setJavaScriptEnabled(true);
            webView.getEngine().load(html);
//            webView.getEngine().loadContent(html);
            scene = new Scene(webView,250,300);
            jFxPanel.setScene(scene);
        });
    }
    
    public Double getTOTAL() {
        TOTAL = detalle.getTOTAL();
        return TOTAL;
    }
    
    public Double mostrarDetalleD(Integer FACTURAID) {
        this.FACTURAID = FACTURAID;
        cleanViewer();
        detalle.setFACTURAID(FACTURAID);
        detalle.setDetalleNull();
        html = detalle.getDetalleHTML(FACTURAID);
        showInViewer();
        
        return getTOTAL();
    }
    
    public void mostrarDetalle(Integer FACTURAID) {
        this.FACTURAID = FACTURAID;
        cleanViewer();
        detalle.setFACTURAID(FACTURAID);
        detalle.setDetalleNull();
        html = detalle.getDetalleHTML(FACTURAID);
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
            System.err.println(e);
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
                    System.out.println("Print Successfull");
                }
            }
        } catch (Exception e) {
            System.err.println("Print Node: "+e);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
/******************************************************************************/
}
