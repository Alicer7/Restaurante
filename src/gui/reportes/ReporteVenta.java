/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.reportes;

import core.database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alicer
 */
public class ReporteVenta extends javax.swing.JDialog {
    
    private void configurarVentana() {
        this.setTitle("Reporte Diario de Ventas");                   // colocamos titulo a la ventana
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso

    }

    /**
     * Creates new form ReporteVenta
     */
    public ReporteVenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        configurarVentana();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTarjeta = new javax.swing.JTextField();
        txtEfectivo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jcInicial = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jcFinal = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtTabla);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 70, 784, 294));

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 28, 98, 42));

        jLabel1.setText("Pagos con Tarjeta:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 364, 112, 28));

        jLabel2.setText("Pagos en Efectivo:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 364, -1, 28));
        jPanel2.add(txtTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 364, 112, 28));
        jPanel2.add(txtEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 364, 98, 28));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("DE:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 28, 42, 28));

        jcInicial.setDateFormatString("yyyy-MM-d");
        jcInicial.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(jcInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 28, 210, 28));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setText("AL:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 28, 42, 28));

        jcFinal.setDateFormatString("yyyy-MM-d");
        jcFinal.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(jcFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 28, 210, 28));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtEfectivo.setEditable(false);
        txtTarjeta.setEditable(false);
        String Finicial = "'" + ((JTextField) jcInicial.getDateEditor().getUiComponent()).getText() + "'";
        String Ffinal = "'" + ((JTextField) jcFinal.getDateEditor().getUiComponent()).getText() + "'";
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion cone = new Conexion();
            com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) cone.connect();
            DefaultTableModel modelo2 = new DefaultTableModel();
            jtTabla.setModel(modelo2);
            
            String sql = "SELECT\n"
                    + "     factura_pedido.`factura_venta_id` AS factura_pedido_factura_venta_id,\n"
                    + "     factura_venta.`cliente_nit` AS factura_venta_cliente_nit,\n"
                    + "     factura_venta.`costo` AS factura_venta_costo,\n"
                    + "     factura_venta.`pago_efectivo` AS factura_venta_pago_efectivo,\n"
                    + "     factura_venta.`pago_electronico` AS factura_venta_pago_electronico,\n"
                    + "     factura_venta.`fecha` AS factura_venta_fecha\n"
                    + "FROM\n"
                    + "     `factura_venta` factura_venta INNER JOIN `factura_pedido` factura_pedido ON factura_venta.`id` = factura_pedido.`factura_venta_id` where (fecha between " + Finicial + " and " + Ffinal + ")";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            modelo2.addColumn("id.");
            modelo2.addColumn("Cliente");
            modelo2.addColumn("Costos");
            modelo2.addColumn("Pago en Efectivo");
            modelo2.addColumn("Pago con Tarjeta");
            modelo2.addColumn("Pago en Fecha");
            
            int[] anchos = {10, 30, 70, 70, 70, 70};
            for (int i = 0; i < jtTabla.getColumnCount(); i++) {
                jtTabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }
            
            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo2.addRow(filas);
            }
            
            Double row = 0.0;
            Double all = 0.0;
            for (int i = 0; i < jtTabla.getRowCount(); i++) {
                row = Double.parseDouble(jtTabla.getValueAt(i, 3).toString());
                all += row;
                
            }
            txtEfectivo.setText(Double.toString(all));
            Double fila = 0.0;
            Double total = 0.0;
            for (int i = 0; i < jtTabla.getRowCount(); i++) {
                fila = Double.parseDouble(jtTabla.getValueAt(i, 4).toString());
                total += fila;
            }
            txtTarjeta.setText(Double.toString(total));
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ReporteVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReporteVenta dialog = new ReporteVenta(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jcFinal;
    private com.toedter.calendar.JDateChooser jcInicial;
    private javax.swing.JTable jtTabla;
    private javax.swing.JTextField txtEfectivo;
    private javax.swing.JTextField txtTarjeta;
    // End of variables declaration//GEN-END:variables
}
