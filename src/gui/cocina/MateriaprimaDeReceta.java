/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.cocina;

import core.database.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alicer
 */
public class MateriaprimaDeReceta extends javax.swing.JFrame {

    int ID_ARTICULO = 0;
    String NOMBRE_ARTICULO = null;
    int ID_CAT = 0;
    int ID_RECETA = 0;
    int X = 0;

    public void tabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        jtProductos.setModel(modelo);
        modelo.addColumn("id.");
        modelo.addColumn("Nombre");
        modelo.addColumn("cantidad");

    }

    public void sqlconsulta() {
//        jcReceta.removeAllItems();
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion cone = new Conexion();
            com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) cone.connect();

            String corrArticulo = "Select nombre from receta where estado = 'Inactivo' order by(id)";
            ps = conn.prepareStatement(corrArticulo);
            rs = ps.executeQuery();

            while (rs.next()) {
                this.jcReceta.addItem(rs.getString("nombre"));
            }
            String cat_articulo = "Select nombre from categoria order by(id)";
            ps = conn.prepareStatement(cat_articulo);
            rs = ps.executeQuery();

            while (rs.next()) {
                this.jcCategoria.addItem(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

    }

    public void popuptable() {
        JPopupMenu popmenu = new JPopupMenu();
        JMenuItem menuitem = new JMenuItem("Eliminar", new ImageIcon(getClass().getResource("/core/resources/icons/eli.png")));
        menuitem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) jtProductos.getModel();
                int a = jtProductos.getSelectedRow();
                if (a < 0) {
                    JOptionPane.showMessageDialog(null,
                            "Debe seleccionar una fila de la tabla");
                } else {
                    int confirmar = JOptionPane.showConfirmDialog(null,
                            "Esta seguro que desea quitar el producto? ");
                    if (JOptionPane.OK_OPTION == confirmar) {
                        model.removeRow(a);
                        JOptionPane.showMessageDialog(null, "Registro Eliminado");
                    }
                }
            }
        });

        popmenu.add(menuitem);

        jtProductos.setComponentPopupMenu(popmenu);
    }

    /**
     * Creates new form Factura_ingreso
     */
    public MateriaprimaDeReceta() {
        initComponents();
        tabla();
        popuptable();

        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion cone = new Conexion();
            com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) cone.connect();
            DefaultTableModel modelo2 = new DefaultTableModel();
            jtArticulos.setModel(modelo2);

            String sql = "select id, nombre, stock, costo from materiaprima ";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo2.addColumn("id.");
            modelo2.addColumn("Nombre");
            modelo2.addColumn("Existencia");
            modelo2.addColumn("Costo");

            int[] anchos = {10, 30, 70, 70};
            for (int i = 0; i < jtArticulos.getColumnCount(); i++) {
                jtArticulos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo2.addRow(filas);
            }

            String corrArticulo = "Select nombre from receta where estado = 'Inactivo' order by(id)";
            ps = conn.prepareStatement(corrArticulo);
            rs = ps.executeQuery();

            while (rs.next()) {
                this.jcReceta.addItem(rs.getString("nombre"));
            }
            String cat_articulo = "Select nombre from categoria order by(id)";
            ps = conn.prepareStatement(cat_articulo);
            rs = ps.executeQuery();

            while (rs.next()) {
                this.jcCategoria.addItem(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
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
        jLabel2 = new javax.swing.JLabel();
        jcReceta = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jcCategoria = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtArticulos = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingredientes de Recetas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Receta :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 110, 31));

        jcReceta.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jcReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcRecetaActionPerformed(evt);
            }
        });
        jPanel2.add(jcReceta, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 280, 28));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Categoría:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 90, 30));

        jcCategoria.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jcCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcCategoriaActionPerformed(evt);
            }
        });
        jPanel2.add(jcCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, 266, 28));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton3.setText("Nueva Receta");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 130, 30));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton4.setText("Nueva Categoría");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 30, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 28, 1078, 84));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtProductos);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 658, 266));

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

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 476, 266));

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 350, 112, 42));

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 112, 42));

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel3.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 32, 320, 30));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Buscar:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 30, 80, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 126, 1210, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1268, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//
        try {
            Conexion cone = new Conexion();
            com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) cone.connect();
            PreparedStatement ps = null;

            int filas = jtProductos.getRowCount();
            System.out.println("filas jc " + filas);
            for (int row = 0; row < filas; row++) {

                int id_materia = (int) jtProductos.getValueAt(row, 0);
                Double cant = (double) jtProductos.getValueAt(row, 2);

                ps = conn.prepareStatement("INSERT INTO `receta_ingrediente` (`receta_id`, `receta_categoria_id`,  `cantidad`, `materiaprima_cocina_id`) VALUES (?,?,?,?)");
                ps.setInt(1, ID_RECETA);
                ps.setInt(2, ID_CAT);
                ps.setDouble(3, cant);
                ps.setDouble(4, id_materia);
                ps.execute();
                System.out.println("ya, asdfasdf");

            }
//            JOptionPane.showMessageDialog(null, "Ingresado Correctamente");
            ps = conn.prepareStatement("UPDATE receta SET estado = 'Activo' WHERE id = '" + ID_RECETA + "' and categoria_id = '" + ID_CAT + "'");
            ps.execute();

            JOptionPane.showMessageDialog(null, "Ingredientes Asignados..");
            jcReceta.removeItemAt(X);
            tabla();
            limpiar();
        } catch (SQLException ex) {
            System.out.println("errorsql " + ex);
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jtArticulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtArticulosMouseClicked

        int Fila = jtArticulos.getSelectedRow();
        String codigo = jtArticulos.getValueAt(Fila, 0).toString();
        String nombre = jtArticulos.getValueAt(Fila, 1).toString();
        ID_ARTICULO = Integer.parseInt(codigo);
        NOMBRE_ARTICULO = nombre;
        System.out.println("id " + ID_ARTICULO);
        System.out.println("Nombre: " + NOMBRE_ARTICULO);
    }//GEN-LAST:event_jtArticulosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int filas = jtArticulos.getSelectedRow();
        if (filas < 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un artículo");

        } else {
            String cant = JOptionPane.showInputDialog(null, "Ingrese la cantidad", "Cantidad de onzas utilizadas", JOptionPane.WARNING_MESSAGE);
            double cantidad = Double.parseDouble(cant);
            DefaultTableModel modelo = (DefaultTableModel) jtProductos.getModel();
            Object[] fila = new Object[5];
            fila[0] = ID_ARTICULO;
            fila[1] = NOMBRE_ARTICULO;
            fila[2] = cantidad;
            modelo.addRow(fila);
//        jtProductos.setModel(modelo);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased

        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion cone = new Conexion();
            com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) cone.connect();
            DefaultTableModel modelo2 = new DefaultTableModel();
            jtArticulos.setModel(modelo2);

            //            String sql = "select id, nombre, precio from bebida order by(id) ";
            String sql = "SELECT id, nombre, stock FROM materiaprima WHERE nombre LIKE '%" + txtBuscar.getText() + "%' order by(id) ";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo2.addColumn("id.");
            modelo2.addColumn("Nombre");
            modelo2.addColumn("Precio");

            int[] anchos = {10, 150, 70};
            for (int i = 0; i < jtArticulos.getColumnCount(); i++) {
                jtArticulos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo2.addRow(filas);
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void jcRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcRecetaActionPerformed
        X = jcReceta.getSelectedIndex() ;
        System.out.println("   " + X);
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion cone = new Conexion();
            com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) cone.connect();

            String cat_articulo = "Select id from receta where nombre = '" + jcReceta.getSelectedItem().toString() + "'";
            ps = conn.prepareStatement(cat_articulo);
            rs = ps.executeQuery();

            while (rs.next()) {
                ID_RECETA = (rs.getInt("id"));
            }

            System.out.println("receta : " + ID_RECETA);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

    }//GEN-LAST:event_jcRecetaActionPerformed

    private void jcCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcCategoriaActionPerformed
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion cone = new Conexion();
            com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) cone.connect();

            String cat_articulo = "Select id from categoria where nombre = '" + jcCategoria.getSelectedItem().toString() + "'";
            ps = conn.prepareStatement(cat_articulo);
            rs = ps.executeQuery();

            while (rs.next()) {
                ID_CAT = (rs.getInt("id"));
            }
            System.out.println("cate  : " + ID_CAT);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }//GEN-LAST:event_jcCategoriaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        gui.cocina.NuevaReceta recipe = new gui.cocina.NuevaReceta(this, true);
        recipe.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        gui.cocina.NuevaCategoria cat = new gui.cocina.NuevaCategoria(this, true);
        cat.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void limpiar() {

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
            java.util.logging.Logger.getLogger(MateriaprimaDeReceta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MateriaprimaDeReceta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MateriaprimaDeReceta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MateriaprimaDeReceta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new MateriaprimaDeReceta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcCategoria;
    private javax.swing.JComboBox<String> jcReceta;
    private javax.swing.JTable jtArticulos;
    private javax.swing.JTable jtProductos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
