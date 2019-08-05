/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.venta;

import com.toedter.calendar.JDateChooser;
import core.utils.engine.WebEngineX;
import core.utils.themplate.Detalle;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javafx.embed.swing.JFXPanel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Freddy Camposeco <freddy.camposeco@elementum69.com>
 * <www.elementum69.com>
 */
public class VentasP extends javax.swing.JPanel {
    private final Date date = new Date();
    private final DateFormat inFormat = new SimpleDateFormat( "| dd-MM-yyyy | E | hh:mm:ss aa |");
    private final DateFormat outFormat = new SimpleDateFormat( "| yyyy-MM-dd | E | HH:mm:ss | ");
    private final DateFormat outFormatFechaDia = new SimpleDateFormat("yyyy-MM-dd");
    private final String myDate = outFormat.format(date);
    private String myDateDia;
    private Date dateX = new Date();
   
    private final Detalle detalle = new Detalle();
    private WebEngineX webEngine;
    private JFXPanel jFxPanel;
    
    private static Integer FACTURAID = null ;
      
    private void startViewer(){
        webEngine = new WebEngineX();
        jFxPanel = webEngine.getjFxPanel();
    }
    
    private void loadViewer(){
        webEngine.loadViewer();
    }
    
    private void addDetallePanel (){
        try {
            startViewer();
            jScrollPane_Detalle_.getViewport().add(jFxPanel);
            loadViewer();
        } catch (Exception e) {
            System.err.println("mostrarDetalle ():"+e);
        }
    }
    
    private void limpiarDetalles(){
        try {
            webEngine.putDefauiltInViewer();
        } catch (Exception e) {
            System.err.println("limpiarDetalles():"+e);
        }
    }
    
    private void limpiarTablaFacturas() {
        try {
            DefaultTableModel modelF = (DefaultTableModel) jTable_Facturas_.getModel();
            jTable_Facturas_.setPreferredSize(new java.awt.Dimension(jTable_Facturas_.getWidth(), 0));

            int rowCount = modelF.getRowCount();
            for (int i = rowCount-1; i >= 0; i--) {
                modelF.removeRow(i);
            }
        } catch (Exception e) {
            System.err.println("limpiarTablaFacturas():"+e);
        }
    }
    
    private void restablecerBordes (){
        jPanel_Detalle_.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14)));
        jPanel_Facturas_.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Facturas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14)));
    }
    
    private void mostrarVentasActivas() {
        
        limpiarDetalles();
        limpiarTablaFacturas();
        restablecerBordes ();
        
        try {
            core.database.querry.Factura facturas = new core.database.querry.Factura();
            // SQL
            ArrayList<core.database.querry.Factura> lista = facturas.listaFacturasActivas();

            jTable_Facturas_.setPreferredSize(new java.awt.Dimension(jTable_Facturas_.getWidth(), lista.size() * 18));
            jTable_Facturas_.revalidate();
            jTable_Facturas_.repaint();

            DefaultTableModel model = (DefaultTableModel) jTable_Facturas_.getModel();

            Object filaData[][] = new Object[lista.size()][5];

            for (int i = 0; i < lista.size(); i++) {
                filaData[i][0] = "desc";
                filaData[i][1] = lista.get(i).getIdFactura();
                filaData[i][2] = "Q " + lista.get(i).getCosto();
                filaData[i][3] = lista.get(i).getFecha();
                filaData[i][4] = lista.get(i).getSolvente();

                model.addRow(filaData[i]);
            }
        } catch (Exception e) {
            System.err.println("mostrarVentasActivas().mostrar: >"+e);
        }
        
    }
    
    private void mostrarVentasFecha (){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ignored) {}
        
        JDateChooser calendario = new JDateChooser();
        Date fechaActual = new Date();
        calendario.setDate(fechaActual);
        int selectFecha;
        
        selectFecha = JOptionPane.showOptionDialog(
            null,
            add(calendario),
            "Selecciona la Fecha",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            null,
            null
        );
        
        try {
            if (selectFecha == JOptionPane.OK_OPTION) {
                restablecerBordes ();
                limpiarTablaFacturas();
                limpiarDetalles();
                borderFacturaFecha(calendario.getDate());
                dateX = calendario.getDate();
            } else {
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        
        try {
            UIManager.setLookAndFeel("com.alee.laf.WebLookAndFeel");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ignored) {}
    }
    
    private void borderFacturaFecha(Date Fecha) {
        myDateDia = outFormatFechaDia.format(Fecha);
        jPanel_Facturas_.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Facturas Activas: " + myDateDia, javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14)));
    }
    
    private void borderFacturaDetalle(String numeroFactura) {
        jPanel_Detalle_.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle - Pedidos Factura #" + numeroFactura, javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14)));
    }

    private void nuevoCliente(){
        try {
            NuevoCliente clienteNuevo = new NuevoCliente();
            clienteNuevo.setVisible(true);
        } catch (Exception e) {
            System.err.println("nuevoCliente(): >"+e);
        }
    }
    
    private void mensajeNoFacturaSelect (){
        String botones[] = {"Añadir Cliente", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(this, "Selecciona una factura para añadir un pedido, o crea una nuevo cliente.", "No hay una factura selecionada!", 0, 0, null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            nuevoCliente ();
        } else if (eleccion == JOptionPane.NO_OPTION) {
        }
    }
    
    public static Integer getFACTURAID() {
        return FACTURAID;
    }
    
    public VentasP() {
        initComponents();
        addDetallePanel();
        mostrarVentasActivas();
        borderFacturaFecha(date);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jEditorPane_Viwer_ = new javax.swing.JEditorPane();
        jPanel_Detalle_ = new javax.swing.JPanel();
        jPanel_DetalleBotones_ = new javax.swing.JPanel();
        jButton_NuevoPedido_ = new javax.swing.JButton();
        jButton_Cobrar_ = new javax.swing.JButton();
        jScrollPane_Detalle_ = new javax.swing.JScrollPane();
        jPanel_Facturas_ = new javax.swing.JPanel();
        jPanel_DetalleBotones_1 = new javax.swing.JPanel();
        jButton_ClienteNuevo_ = new javax.swing.JButton();
        jLabel_BuscarPorFecha_ = new javax.swing.JLabel();
        jLabel_SinCobrar_ = new javax.swing.JLabel();
        jScrollPane_Facturas_ = new javax.swing.JScrollPane();
        jTable_Facturas_ = new javax.swing.JTable();

        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                formAncestorRemoved(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("gui/venta/Bundle"); // NOI18N
        jPanel_Detalle_.setBorder(javax.swing.BorderFactory.createTitledBorder(null, bundle.getString("Ventas.jPanel_Detalle_.border.title"), javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jPanel_Detalle_.setToolTipText(bundle.getString("Ventas.jPanel_Detalle_.toolTipText")); // NOI18N
        jPanel_Detalle_.setMinimumSize(new java.awt.Dimension(300, 669));
        jPanel_Detalle_.setPreferredSize(new java.awt.Dimension(300, 300));
        jPanel_Detalle_.setLayout(new java.awt.BorderLayout());

        jButton_NuevoPedido_.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_NuevoPedido_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/core/resources/icons/clocheX32.png"))); // NOI18N
        jButton_NuevoPedido_.setText(bundle.getString("Ventas.jButton_NuevoPedido_.text")); // NOI18N
        jButton_NuevoPedido_.setMaximumSize(new java.awt.Dimension(140, 42));
        jButton_NuevoPedido_.setMinimumSize(new java.awt.Dimension(140, 42));
        jButton_NuevoPedido_.setPreferredSize(new java.awt.Dimension(140, 42));
        jButton_NuevoPedido_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NuevoPedido_ActionPerformed(evt);
            }
        });

        jButton_Cobrar_.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Cobrar_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/core/resources/icons/CashBoxX32.png"))); // NOI18N
        jButton_Cobrar_.setText(bundle.getString("Ventas.jButton_Cobrar_.text")); // NOI18N
        jButton_Cobrar_.setMaximumSize(new java.awt.Dimension(140, 42));
        jButton_Cobrar_.setMinimumSize(new java.awt.Dimension(140, 42));
        jButton_Cobrar_.setPreferredSize(new java.awt.Dimension(140, 42));
        jButton_Cobrar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Cobrar_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_DetalleBotones_Layout = new javax.swing.GroupLayout(jPanel_DetalleBotones_);
        jPanel_DetalleBotones_.setLayout(jPanel_DetalleBotones_Layout);
        jPanel_DetalleBotones_Layout.setHorizontalGroup(
            jPanel_DetalleBotones_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_DetalleBotones_Layout.createSequentialGroup()
                .addComponent(jButton_NuevoPedido_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jButton_Cobrar_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel_DetalleBotones_Layout.setVerticalGroup(
            jPanel_DetalleBotones_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_DetalleBotones_Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_DetalleBotones_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_NuevoPedido_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Cobrar_, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_Detalle_.add(jPanel_DetalleBotones_, java.awt.BorderLayout.SOUTH);
        jPanel_Detalle_.add(jScrollPane_Detalle_, java.awt.BorderLayout.CENTER);

        add(jPanel_Detalle_, java.awt.BorderLayout.EAST);

        jPanel_Facturas_.setBorder(javax.swing.BorderFactory.createTitledBorder(null, bundle.getString("Ventas.jPanel_Clientes_.border.title"), javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jPanel_Facturas_.setMinimumSize(new java.awt.Dimension(478, 669));
        jPanel_Facturas_.setPreferredSize(new java.awt.Dimension(478, 669));
        jPanel_Facturas_.setLayout(new java.awt.BorderLayout());

        jButton_ClienteNuevo_.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_ClienteNuevo_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/core/resources/icons/FunAsClienteX32.png"))); // NOI18N
        jButton_ClienteNuevo_.setText(bundle.getString("Ventas.jButton_ClienteNuevo_.text")); // NOI18N
        jButton_ClienteNuevo_.setMaximumSize(new java.awt.Dimension(150, 42));
        jButton_ClienteNuevo_.setMinimumSize(new java.awt.Dimension(150, 42));
        jButton_ClienteNuevo_.setPreferredSize(new java.awt.Dimension(150, 42));
        jButton_ClienteNuevo_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ClienteNuevo_ActionPerformed(evt);
            }
        });

        jLabel_BuscarPorFecha_.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        jLabel_BuscarPorFecha_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/core/resources/icons/CalendarX32.png"))); // NOI18N
        jLabel_BuscarPorFecha_.setText(bundle.getString("Ventas.jLabel_BuscarPorFecha_.text")); // NOI18N
        jLabel_BuscarPorFecha_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_BuscarPorFecha_.setMaximumSize(new java.awt.Dimension(120, 42));
        jLabel_BuscarPorFecha_.setMinimumSize(new java.awt.Dimension(120, 42));
        jLabel_BuscarPorFecha_.setPreferredSize(new java.awt.Dimension(120, 42));
        jLabel_BuscarPorFecha_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_BuscarPorFecha_MouseClicked(evt);
            }
        });

        jLabel_SinCobrar_.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        jLabel_SinCobrar_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/core/resources/icons/food32.png"))); // NOI18N
        jLabel_SinCobrar_.setText(bundle.getString("Ventas.jLabel_SinCobrar_.text")); // NOI18N
        jLabel_SinCobrar_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_SinCobrar_.setMaximumSize(null);
        jLabel_SinCobrar_.setMinimumSize(new java.awt.Dimension(120, 42));
        jLabel_SinCobrar_.setPreferredSize(new java.awt.Dimension(120, 42));
        jLabel_SinCobrar_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_SinCobrar_MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel_DetalleBotones_1Layout = new javax.swing.GroupLayout(jPanel_DetalleBotones_1);
        jPanel_DetalleBotones_1.setLayout(jPanel_DetalleBotones_1Layout);
        jPanel_DetalleBotones_1Layout.setHorizontalGroup(
            jPanel_DetalleBotones_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_DetalleBotones_1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_ClienteNuevo_, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_BuscarPorFecha_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_SinCobrar_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_DetalleBotones_1Layout.setVerticalGroup(
            jPanel_DetalleBotones_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_DetalleBotones_1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_DetalleBotones_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_ClienteNuevo_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_BuscarPorFecha_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_SinCobrar_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel_Facturas_.add(jPanel_DetalleBotones_1, java.awt.BorderLayout.SOUTH);

        jTable_Facturas_.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Facturas_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Facturas_MouseClicked(evt);
            }
        });
        jScrollPane_Facturas_.setViewportView(jTable_Facturas_);

        jPanel_Facturas_.add(jScrollPane_Facturas_, java.awt.BorderLayout.CENTER);

        add(jPanel_Facturas_, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ClienteNuevo_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ClienteNuevo_ActionPerformed
        nuevoCliente();
    }//GEN-LAST:event_jButton_ClienteNuevo_ActionPerformed

    private void jLabel_BuscarPorFecha_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_BuscarPorFecha_MouseClicked
        mostrarVentasFecha ();
    }//GEN-LAST:event_jLabel_BuscarPorFecha_MouseClicked

    private void jLabel_SinCobrar_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_SinCobrar_MouseClicked
        mostrarVentasActivas();
        borderFacturaFecha(date);
    }//GEN-LAST:event_jLabel_SinCobrar_MouseClicked

    private void jButton_NuevoPedido_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NuevoPedido_ActionPerformed
        if (FACTURAID==null){
            mensajeNoFacturaSelect ();
        } else {
            NuevoPedido pedido = new NuevoPedido();
            pedido.setVisible(true);
        }
            
    }//GEN-LAST:event_jButton_NuevoPedido_ActionPerformed

    private void jButton_Cobrar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Cobrar_ActionPerformed
        Cobrar cobrar = new Cobrar();
        cobrar.setVisible(true);
    }//GEN-LAST:event_jButton_Cobrar_ActionPerformed

    private void jTable_Facturas_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Facturas_MouseClicked
        if (evt.getClickCount() == 2) {
            int colId = 1;
            int row = jTable_Facturas_.getSelectedRow();
            FACTURAID = (Integer) jTable_Facturas_.getValueAt(row, 1);
            Object objId = (Object) jTable_Facturas_.getValueAt(row, colId);
            System.err.println("\nFactura ID: "+FACTURAID);
            webEngine.mostrarDetalle(FACTURAID);
            borderFacturaDetalle(FACTURAID+"");
        }
    }//GEN-LAST:event_jTable_Facturas_MouseClicked

    private void formAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorRemoved
        jScrollPane_Detalle_.getViewport().remove(jFxPanel);
    }//GEN-LAST:event_formAncestorRemoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_ClienteNuevo_;
    private javax.swing.JButton jButton_Cobrar_;
    private javax.swing.JButton jButton_NuevoPedido_;
    private javax.swing.JEditorPane jEditorPane_Viwer_;
    private javax.swing.JLabel jLabel_BuscarPorFecha_;
    private javax.swing.JLabel jLabel_SinCobrar_;
    private javax.swing.JPanel jPanel_DetalleBotones_;
    private javax.swing.JPanel jPanel_DetalleBotones_1;
    private javax.swing.JPanel jPanel_Detalle_;
    private javax.swing.JPanel jPanel_Facturas_;
    private javax.swing.JScrollPane jScrollPane_Detalle_;
    private javax.swing.JScrollPane jScrollPane_Facturas_;
    private javax.swing.JTable jTable_Facturas_;
    // End of variables declaration//GEN-END:variables

}
