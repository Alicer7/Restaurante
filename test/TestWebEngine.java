
import core.utils.engine.WebEngine;
import core.utils.themplate.Detalle;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Freddy Camposeco <freddy.camposeco@elementum69.com>
 * <www.elementum69.com>
 */
public class TestWebEngine extends javax.swing.JFrame {
    
    private final Detalle detalle = new Detalle();
    private WebEngine webEngine;
    private JFXPanel jFxPanel;
    private Scene scene;
    private WebView webView;
    private String html;

    private void startViewer (){
        webEngine = new WebEngine();
        jFxPanel = webEngine.getjFxPanel();
    }
    
    private void loadViewer (){
        Platform.runLater(() -> {
            webEngine.loadViewer ();
        });
    }
    
    private void mostrar (){
        startViewer ();
        jScrollPane.getViewport().setSize(new Dimension(300, jScrollPane.getSize().height));
        jScrollPane.getViewport().add(jFxPanel);
        revalidate();
        repaint();
        loadViewer ();
    }
    
    public TestWebEngine() {
        initComponents();
        mostrar ();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_Add_ = new javax.swing.JButton();
        jButton_Print_ = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 600));
        setPreferredSize(new java.awt.Dimension(300, 600));

        jButton_Add_.setText("WebWiewer");
        jButton_Add_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Add_ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Add_, java.awt.BorderLayout.SOUTH);

        jButton_Print_.setText("Imprimir");
        jButton_Print_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Print_ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Print_, java.awt.BorderLayout.NORTH);
        getContentPane().add(jScrollPane, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_Add_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Add_ActionPerformed
        webEngine.showInViewer("Hola Mundo");
    }//GEN-LAST:event_jButton_Add_ActionPerformed

    private void jButton_Print_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Print_ActionPerformed
        webEngine.print();
    }//GEN-LAST:event_jButton_Print_ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TestWebEngine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestWebEngine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestWebEngine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestWebEngine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TestWebEngine().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Add_;
    private javax.swing.JButton jButton_Print_;
    private javax.swing.JScrollPane jScrollPane;
    // End of variables declaration//GEN-END:variables
}
