/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.venta;

import java.util.ArrayList;
import core.utils.Facturas;
import core.utils.Pedidos;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author freddy
 */
public class Factura extends javax.swing.JFrame {

    /**
     * Creates new form Factura
     */
    public Factura() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Main_ = new javax.swing.JPanel();
        jPanel_Informacion_ = new javax.swing.JPanel();
        jPanel_Detalles_ = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton_Cargar_ = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Facturación");
        setBackground(java.awt.Color.white);
        setMinimumSize(new java.awt.Dimension(900, 675));
        setPreferredSize(new java.awt.Dimension(900, 675));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_Informacion_.setBackground(java.awt.Color.white);
        jPanel_Informacion_.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jPanel_Informacion_.setMinimumSize(new java.awt.Dimension(900, 175));
        jPanel_Informacion_.setPreferredSize(new java.awt.Dimension(900, 175));

        javax.swing.GroupLayout jPanel_Informacion_Layout = new javax.swing.GroupLayout(jPanel_Informacion_);
        jPanel_Informacion_.setLayout(jPanel_Informacion_Layout);
        jPanel_Informacion_Layout.setHorizontalGroup(
            jPanel_Informacion_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel_Informacion_Layout.setVerticalGroup(
            jPanel_Informacion_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel_Main_.add(jPanel_Informacion_);

        jPanel_Detalles_.setBackground(java.awt.Color.white);
        jPanel_Detalles_.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalles Consumo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jPanel_Detalles_.setAutoscrolls(true);
        jPanel_Detalles_.setMinimumSize(new java.awt.Dimension(900, 425));
        jPanel_Detalles_.setPreferredSize(new java.awt.Dimension(900, 425));
        jPanel_Detalles_.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel_Detalles_.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 19, 870, 390));

        jPanel_Main_.add(jPanel_Detalles_);

        getContentPane().add(jPanel_Main_, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        jButton_Cargar_.setText("Cargar");
        jButton_Cargar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Cargar_ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Cargar_, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 620, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_Cargar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Cargar_ActionPerformed
        ArrayList<Pedidos> listaPedidos= new ArrayList<Pedidos>();
        
        DefaultTableModel modelPedidos= (DefaultTableModel) jTable1.getModel();
        Object row[]= new Object[0];
    }//GEN-LAST:event_jButton_Cargar_ActionPerformed

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
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Factura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Cargar_;
    private javax.swing.JPanel jPanel_Detalles_;
    private javax.swing.JPanel jPanel_Informacion_;
    private javax.swing.JPanel jPanel_Main_;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
