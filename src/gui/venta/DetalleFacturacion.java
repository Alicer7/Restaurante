/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.venta;

import core.database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Alicer
 */
public class DetalleFacturacion extends javax.swing.JFrame {

    int ID_ARTICULO = 0;
    String NOMBRE_ARTICULO = null;
    Double PRECIO = 0.0;

//
//    public void popuptable() {
//        JPopupMenu popmenu = new JPopupMenu();
//        JMenuItem menuitem = new JMenuItem("Eliminar", new ImageIcon(getClass().getResource("/iconos/eli.png")));
//        menuitem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                DefaultTableModel model = (DefaultTableModel) jtProductos.getModel();
//                int a = jtProductos.getSelectedRow();
//                if (a < 0) {
//                    JOptionPane.showMessageDialog(null,
//                            "Debe seleccionar una fila de la tabla");
//                } else {
//                    int confirmar = JOptionPane.showConfirmDialog(null,
//                            "Esta seguro que desea quitar el producto? ");
//                    if (JOptionPane.OK_OPTION == confirmar) {
//                        model.removeRow(a);
//                        JOptionPane.showMessageDialog(null, "Registro Eliminado");
//                    }
//                }
//            }
//        });
//        popmenu.add(menuitem);
//
//        jtProductos.setComponentPopupMenu(popmenu);
//    }
    /**
     * Creates new form Factura_ingreso
     */
    public DetalleFacturacion() {
        try { 
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ignored){}
        
        initComponents();

        try {
            Conexion cone = new Conexion();
            com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) cone.connect();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String corrArticulo = "select id From empleado where cargo_id = '1' order by(id)";
            ps = conn.prepareStatement(corrArticulo);
            rs = ps.executeQuery();

            while (rs.next()) {
                this.jcMesero.addItem(rs.getString("id"));
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

//            PreparedStatement ps = null;
//            ResultSet rs = null;
//            Conexion cone = new Conexion();
//            com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) cone.conectar();
//            DefaultTableModel modelo2 = new DefaultTableModel();
//            jtArticulos.setModel(modelo2);
//
//            String sql = "select id, nombre, stock, costo from materiaprima ";
//            ps = conn.prepareStatement(sql);
//            rs = ps.executeQuery();
//
//            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
//            int cantidadColumnas = rsMd.getColumnCount();
//
//            modelo2.addColumn("id.");
//            modelo2.addColumn("Nombre");
//            modelo2.addColumn("Existencia");
//            modelo2.addColumn("Costo");
//
//            int[] anchos = {10, 30, 70, 70};
//            for (int i = 0; i < jtArticulos.getColumnCount(); i++) {
//                jtArticulos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
//            }
//
//            while (rs.next()) {
//                Object[] filas = new Object[cantidadColumnas];
//                for (int i = 0; i < cantidadColumnas; i++) {
//                    filas[i] = rs.getObject(i + 1);
//                }
//                modelo2.addRow(filas);
//            }
//
//        } catch (SQLException ex) {
//            System.err.println(ex.toString());
//        }
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
        txtComanda = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jcMesero = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtNit = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jcFecha = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtArticulos = new javax.swing.JTable();
        jButton_Guardar_ = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalles de la Factura", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtComanda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(txtComanda, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 28, 182, 28));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Comanda No. ");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 28, 126, 28));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Código de Mesero:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 70, 126, 28));

        jcMesero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(jcMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 70, 182, 28));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nit Cliente:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 112, 98, 31));

        txtNit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNitActionPerformed(evt);
            }
        });
        jPanel2.add(txtNit, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 112, 126, 28));

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 154, 322, 28));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Nombre Cliente:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 154, 98, 31));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Monto:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 112, 98, 31));

        txtMonto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 112, 266, 28));

        jcFecha.setDateFormatString("yyyy-MM-dd");
        jPanel2.add(jcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 154, 266, 28));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Fecha:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 154, 98, 31));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 882, 196));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtArticulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtArticulosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtArticulos);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 672, 266));

        jButton_Guardar_.setText("Guardar e Imprimir");
        jButton_Guardar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Guardar_ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_Guardar_, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 170, 42));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 266, 850, 350));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 929, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_Guardar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Guardar_ActionPerformed

        try {
            Conexion cone = new Conexion();
            com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) cone.connect();
            PreparedStatement ps = null;
            ps = conn.prepareStatement("INSERT INTO `cafebar`.`pedido_venta_facturatemporal` (`NitCliente`, `Nombre`, `ComandaNo`, `Mesero`, `Total`, `Fecha`) VALUES (?,?,?,?,?,?)");
            ps.setString(1, txtNit.getText());
            ps.setString(2, txtNombre.getText());
            ps.setString(3, txtComanda.getText());
            ps.setString(4, jcMesero.getSelectedItem().toString());
            ps.setString(5, txtMonto.getText());
            ps.setString(6, ((JTextField) jcFecha.getDateEditor().getUiComponent()).getText());

            ps.execute();
//            JOptionPane.showMessageDialog(null, "Ingresado Correctamente");
            System.out.println("ya, factura");

        } catch (SQLException ex) {
        }

        try {
            Conexion cone = new Conexion();
            com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) cone.connect();
            PreparedStatement ps = null;
            ps = conn.prepareStatement("UPDATE `cafebar`.`pedido_numero_temporal` SET `estado` = 'Cancelado' WHERE nocomanda = '" + txtComanda.getText() + "'");

            ps.execute();
            JOptionPane.showMessageDialog(null, "Factura Generada");
            System.out.println("ya, factura");

        } catch (SQLException ex) {
        }


    }//GEN-LAST:event_jButton_Guardar_ActionPerformed

    private void jtArticulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtArticulosMouseClicked

        int Fila = jtArticulos.getSelectedRow();
        String codigo = jtArticulos.getValueAt(Fila, 0).toString();
        String nombre = jtArticulos.getValueAt(Fila, 1).toString();
        String precio = jtArticulos.getValueAt(Fila, 3).toString();
        ID_ARTICULO = Integer.parseInt(codigo);
        NOMBRE_ARTICULO = nombre;
        PRECIO = Double.parseDouble(precio);

        System.out.println("id " + ID_ARTICULO);
        System.out.println("Nombre: " + NOMBRE_ARTICULO);
        System.out.println("precio" + PRECIO);
    }//GEN-LAST:event_jtArticulosMouseClicked

    private void txtNitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNitActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            UIManager.setLookAndFeel("com.alee.laf.WebLookAndFeel");
        } catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ignored){}
        
    }//GEN-LAST:event_formWindowClosing

    private void limpiar() {
        txtComanda.setText("");

    }

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
            java.util.logging.Logger.getLogger(DetalleFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalleFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalleFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalleFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalleFacturacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Guardar_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jcFecha;
    private javax.swing.JComboBox<String> jcMesero;
    private javax.swing.JTable jtArticulos;
    private javax.swing.JTextField txtComanda;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtNit;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
