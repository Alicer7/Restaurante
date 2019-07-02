/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.venta;

import core.database.querry.Pedidos;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Freddy Camposeco <ankoku.fj@gmail.com> <www.stufs.rf.gd>
 */
public class Cobrar extends javax.swing.JFrame {
   

//   public int imprimir (Graphics g, PageFormat f, int pageIndex)
    public void imprimir () {
        try {
            jEditorPane_View_.print();
        } catch (PrinterException ex) {
            Logger.getLogger(Cobrar.class.getName()).log(Level.SEVERE, null, ex);
        }
   }

    
    public Cobrar() {
        initComponents();
        try {
            mostrarVentasDetalleNumeroFactura(gui.venta.Ventas.PRUEBA);
        } catch (BadLocationException ex) {
            Logger.getLogger(Cobrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void mostrarVentasDetalleNumeroFactura(Integer numeroFactura) throws BadLocationException {
        jEditorPane_View_.setContentType("text/html");

        Pedidos pedidos = new Pedidos();

        // SQL
        ArrayList<Pedidos> lista = pedidos.listaPedidosNumeroFactura(numeroFactura);

        Double totalConsumo = 0.999;

        Object filaData[][] = new Object[lista.size()][11];

        for (int i = 0; i < lista.size(); i++) {
            filaData[i][0] = lista.get(i).getIdPedido();
            filaData[i][1] = lista.get(i).getFacturaId();
            filaData[i][2] = lista.get(i).getMenuId();
            filaData[i][3] = lista.get(i).getMenuCantidad();
            filaData[i][4] = lista.get(i).getComidaId();
            filaData[i][5] = lista.get(i).getComidaCantidad();
            filaData[i][6] = lista.get(i).getBebidaId();
            filaData[i][7] = lista.get(i).getBebidaCantidad();
            filaData[i][8] = "Q " + lista.get(i).getCosto();
            filaData[i][9] = lista.get(i).getTiempo();
            filaData[i][10] = lista.get(i).getSolvente();
            // Conseguir Total Consumo
            totalConsumo += lista.get(i).getCosto();
            jLabel_Total_.setText(Double.toString(totalConsumo));
            
            jEditorPane_View_.setText(
                    "<h3 style=\"\">Factura: " + filaData[i][1] + "</h3>"
                    + "<p>Menu: " + filaData[i][2] + "</p>"
                    + "<p>Costo: " + totalConsumo + "</p>"
            );
            jEditorPane_View_.setText("<h1 style=\"text-align: center;\">Prueba :D</h1>");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel_ModoPago_ = new javax.swing.JPanel();
        jTextField_PagoEfectivo_ = new javax.swing.JTextField();
        jTextField_PagoElectronico_ = new javax.swing.JTextField();
        jTextField_Descuento_ = new javax.swing.JTextField();
        jLabel_Efectivo_ = new javax.swing.JLabel();
        jLabel_Electronico_ = new javax.swing.JLabel();
        jLabel_iconEfectivo_ = new javax.swing.JLabel();
        jLabel_iconElectronico_ = new javax.swing.JLabel();
        jLabel_iconDescuento_ = new javax.swing.JLabel();
        jLabel_Descuento_ = new javax.swing.JLabel();
        jPanel_Imprimir_ = new javax.swing.JPanel();
        jButton_Imprimir_ = new javax.swing.JButton();
        jPanel_Total_ = new javax.swing.JPanel();
        jLabel_Total_ = new javax.swing.JLabel();
        jLabel_TotalQ_ = new javax.swing.JLabel();
        jScrollPane_View_ = new javax.swing.JScrollPane();
        jEditorPane_View_ = new javax.swing.JEditorPane();
        jPanel_Saldo_ = new javax.swing.JPanel();
        jLabel_Saldo_ = new javax.swing.JLabel();
        jLabel_SaldoQ_ = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cobrar");
        setType(java.awt.Window.Type.POPUP);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jPanel_ModoPago_.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Metodo de Pago", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jTextField_PagoEfectivo_.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField_PagoEfectivo_.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_PagoEfectivo_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_PagoEfectivo_ActionPerformed(evt);
            }
        });

        jTextField_PagoElectronico_.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField_PagoElectronico_.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextField_Descuento_.setEditable(false);
        jTextField_Descuento_.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField_Descuento_.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_Descuento_.setText("0");

        jLabel_Efectivo_.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_Efectivo_.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_Efectivo_.setText("Efectivo:");

        jLabel_Electronico_.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_Electronico_.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_Electronico_.setText("Electronico:");

        jLabel_iconEfectivo_.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_iconEfectivo_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/core/resources/icons/money.x32.png"))); // NOI18N

        jLabel_iconElectronico_.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_iconElectronico_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/core/resources/icons/CreditCarX32.png"))); // NOI18N

        jLabel_iconDescuento_.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_iconDescuento_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/core/resources/icons/FunAsClienteX32.png"))); // NOI18N

        jLabel_Descuento_.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_Descuento_.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_Descuento_.setText("Descuento:");

        javax.swing.GroupLayout jPanel_ModoPago_Layout = new javax.swing.GroupLayout(jPanel_ModoPago_);
        jPanel_ModoPago_.setLayout(jPanel_ModoPago_Layout);
        jPanel_ModoPago_Layout.setHorizontalGroup(
            jPanel_ModoPago_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ModoPago_Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_ModoPago_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_Electronico_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_Efectivo_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_Descuento_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_ModoPago_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_iconEfectivo_)
                    .addComponent(jLabel_iconElectronico_)
                    .addComponent(jLabel_iconDescuento_))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_ModoPago_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_PagoEfectivo_)
                    .addComponent(jTextField_PagoElectronico_)
                    .addComponent(jTextField_Descuento_))
                .addContainerGap())
        );
        jPanel_ModoPago_Layout.setVerticalGroup(
            jPanel_ModoPago_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_ModoPago_Layout.createSequentialGroup()
                .addGroup(jPanel_ModoPago_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_PagoEfectivo_)
                    .addComponent(jLabel_Efectivo_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_iconEfectivo_, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_ModoPago_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Electronico_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel_ModoPago_Layout.createSequentialGroup()
                        .addComponent(jTextField_PagoElectronico_, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel_iconElectronico_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_ModoPago_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Descuento_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel_ModoPago_Layout.createSequentialGroup()
                        .addComponent(jTextField_Descuento_, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel_iconDescuento_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel_Imprimir_.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Imprimir", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jButton_Imprimir_.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jButton_Imprimir_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/core/resources/icons/InvoiceX48.png"))); // NOI18N
        jButton_Imprimir_.setText("Aceptar");
        jButton_Imprimir_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Imprimir_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_Imprimir_Layout = new javax.swing.GroupLayout(jPanel_Imprimir_);
        jPanel_Imprimir_.setLayout(jPanel_Imprimir_Layout);
        jPanel_Imprimir_Layout.setHorizontalGroup(
            jPanel_Imprimir_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Imprimir_Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_Imprimir_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel_Imprimir_Layout.setVerticalGroup(
            jPanel_Imprimir_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton_Imprimir_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
        );

        jPanel_Total_.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel_Total_.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_Total_.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel_TotalQ_.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel_TotalQ_.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_TotalQ_.setText("Q");

        javax.swing.GroupLayout jPanel_Total_Layout = new javax.swing.GroupLayout(jPanel_Total_);
        jPanel_Total_.setLayout(jPanel_Total_Layout);
        jPanel_Total_Layout.setHorizontalGroup(
            jPanel_Total_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Total_Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_TotalQ_, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Total_, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel_Total_Layout.setVerticalGroup(
            jPanel_Total_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Total_Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_Total_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_TotalQ_, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Total_, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane_View_.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vista Previa", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jScrollPane_View_.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane_View_.setHorizontalScrollBar(null);
        jScrollPane_View_.setMinimumSize(new java.awt.Dimension(316, 588));
        jScrollPane_View_.setPreferredSize(new java.awt.Dimension(316, 588));

        jEditorPane_View_.setEditable(false);
        jEditorPane_View_.setToolTipText("Vista Previa");
        jEditorPane_View_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jEditorPane_View_.setMaximumSize(null);
        jEditorPane_View_.setMinimumSize(new java.awt.Dimension(300, 550));
        jEditorPane_View_.setPreferredSize(null);
        jScrollPane_View_.setViewportView(jEditorPane_View_);
        jEditorPane_View_.getAccessibleContext().setAccessibleName("");
        jEditorPane_View_.getAccessibleContext().setAccessibleDescription("text/html");

        jPanel_Saldo_.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Saldo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel_Saldo_.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_Saldo_.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel_SaldoQ_.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel_SaldoQ_.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_SaldoQ_.setText("Q");

        javax.swing.GroupLayout jPanel_Saldo_Layout = new javax.swing.GroupLayout(jPanel_Saldo_);
        jPanel_Saldo_.setLayout(jPanel_Saldo_Layout);
        jPanel_Saldo_Layout.setHorizontalGroup(
            jPanel_Saldo_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Saldo_Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_SaldoQ_, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Saldo_, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel_Saldo_Layout.setVerticalGroup(
            jPanel_Saldo_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Saldo_Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_Saldo_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_SaldoQ_, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Saldo_, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane_View_, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel_Total_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_ModoPago_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_Saldo_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_Imprimir_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane_View_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel_Total_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel_ModoPago_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel_Saldo_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel_Imprimir_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_PagoEfectivo_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_PagoEfectivo_ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PagoEfectivo_ActionPerformed

    private void jButton_Imprimir_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Imprimir_ActionPerformed
                   //ResultSet rs = null;
//        try {
//            Conexion cone = new Conexion();
//            com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) cone.connect();
//
//            String codi = "Select id_proyecto from proyecto where no_proyecto_asignado=  ";
//            ps = conn.prepareStatement(codi);
//            rs = ps.executeQuery();
//            rs = ps.executeQuery();
//
//            while (rs.next()) {
//                ideproye = (rs.getString("id_proyecto"));
//            }
//
//            ps = conn.prepareStatement("UPDATE aprobacion SET  Abono_realizado= '");
//            ps.execute();
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al Guardar");
//            System.out.println(ex);
//        }
        
        
        imprimir ();
    }//GEN-LAST:event_jButton_Imprimir_ActionPerformed

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
            java.util.logging.Logger.getLogger(Cobrar.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cobrar.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cobrar.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cobrar.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Cobrar().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Imprimir_;
    private javax.swing.JEditorPane jEditorPane_View_;
    private javax.swing.JLabel jLabel_Descuento_;
    private javax.swing.JLabel jLabel_Efectivo_;
    private javax.swing.JLabel jLabel_Electronico_;
    private javax.swing.JLabel jLabel_SaldoQ_;
    private javax.swing.JLabel jLabel_Saldo_;
    private javax.swing.JLabel jLabel_TotalQ_;
    private javax.swing.JLabel jLabel_Total_;
    private javax.swing.JLabel jLabel_iconDescuento_;
    private javax.swing.JLabel jLabel_iconEfectivo_;
    private javax.swing.JLabel jLabel_iconElectronico_;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_Imprimir_;
    private javax.swing.JPanel jPanel_ModoPago_;
    private javax.swing.JPanel jPanel_Saldo_;
    private javax.swing.JPanel jPanel_Total_;
    private javax.swing.JScrollPane jScrollPane_View_;
    private javax.swing.JTextField jTextField_Descuento_;
    private javax.swing.JTextField jTextField_PagoEfectivo_;
    private javax.swing.JTextField jTextField_PagoElectronico_;
    // End of variables declaration//GEN-END:variables
}
