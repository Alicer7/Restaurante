/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.venta;

import com.toedter.calendar.JDateChooser;
import core.utils.Facturas;
import core.utils.Pedidos;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
/**
 *
 * @author freddy
 */
public class Ventas extends javax.swing.JFrame {


    private static final String plantillaDia = "yyyy/MM/dd";
    private static final String plantillaHora = "HH:mm:ss";
    private Date date= new Date();
    private static final SimpleDateFormat formatoFechaDia = new SimpleDateFormat(plantillaDia, Locale.ROOT);
    private static final DateTimeFormatter diaFormato = DateTimeFormatter.ofPattern(plantillaDia);
    private static final SimpleDateFormat formatoFechaHora = new SimpleDateFormat(plantillaDia+" "+plantillaHora, Locale.ROOT);
    
    private void borderFacturaFecha (Date sFecha){
        jPanel_Clientes_.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Facturas "+formatoFechaDia.format(sFecha), javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14)));
    }
    
       private void borderDetallesFactura (String numeroFactura){
        jPanel_Detalle_.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle - Pedidos Factura #"+numeroFactura, javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14)));
    }
    
    private void mostrarVentasDia ( String dia ){
        
        limpiarTablaFacturas();
        
        Facturas facturas = new Facturas();
        
        ArrayList<Facturas> lista = facturas.listaFacturasDia(dia);
        
        jTable_Factura_.setPreferredSize(new java.awt.Dimension(jTable_Factura_.getWidth(), lista.size()*16));
        
        DefaultTableModel model = (DefaultTableModel) jTable_Factura_.getModel();
        
        Object filaData [][]= new Object[lista.size()][5];
        
        for (int i=0 ; i < lista.size() ; i++){
            filaData[i][0]="desc:"+i;
            filaData[i][1]=lista.get(i).getIdFactura();
            filaData[i][2]="Q "+lista.get(i).getCosto();
            filaData[i][3]=lista.get(i).getFecha();
            filaData[i][4]=lista.get(i).getSolvente();
            
            model.addRow(filaData[i]);
        }
    }
    
    private void mostrarVentasActivas (  ){
        limpiarTablaFacturas();
        
        Facturas facturas = new Facturas();
        
        // SQL
        ArrayList<Facturas> lista = facturas.listaFacturasActivas();
        
        jTable_Factura_.setPreferredSize(new java.awt.Dimension(jTable_Factura_.getWidth(), lista.size()*16));
        
        DefaultTableModel model = (DefaultTableModel) jTable_Factura_.getModel();
        
        Object filaData [][]= new Object[lista.size()][5];
        
        for (int i=0 ; i < lista.size() ; i++){
            filaData[i][0]="desc";
            filaData[i][1]=lista.get(i).getIdFactura();
            filaData[i][2]="Q "+lista.get(i).getCosto();
            filaData[i][3]=lista.get(i).getFecha();
            filaData[i][4]=lista.get(i).getSolvente();
            
            model.addRow(filaData[i]);
        }
    }
    
    private void mostrarVentasActivasDia ( String dia ){
        limpiarTablaFacturas();
        
        Facturas facturas = new Facturas();
        
        // SQL
        ArrayList<Facturas> lista = facturas.listaFacturasDiaActivas(dia);
        
        jTable_Factura_.setPreferredSize(new java.awt.Dimension(jTable_Factura_.getWidth(), lista.size()*16));
        
        DefaultTableModel model = (DefaultTableModel) jTable_Factura_.getModel();
        
        Object filaData [][]= new Object[lista.size()][5];
        
        for (int i=0 ; i < lista.size() ; i++){
            filaData[i][0]="desc";
            filaData[i][1]=lista.get(i).getIdFactura();
            filaData[i][2]="Q "+lista.get(i).getCosto();
            filaData[i][3]=lista.get(i).getFecha();
            filaData[i][4]=lista.get(i).getSolvente();
            
            model.addRow(filaData[i]);
        }
    }
    
    private void mostrarVentasDetalleNumeroFactura ( Integer numeroFactura ) throws BadLocationException{
        JEditorPane viwer = new JEditorPane();
        viwer.setSize(300, 588);
        viwer.setContentType("text/html");
        jScrollPane_View_.setViewportView(viwer);
        
        Pedidos pedidos = new Pedidos();
        
        // SQL
        ArrayList<Pedidos> lista = pedidos.listaPedidosNumeroFactura(numeroFactura); 
        
        Double totalConsumo=0.999;    

        Object filaData [][]= new Object[lista.size()][11];
                
        for (int i=0 ; i < lista.size() ; i++){
            filaData[i][0]=lista.get(i).getIdPedido();
            filaData[i][1]=lista.get(i).getFacturaId();
            filaData[i][2]=lista.get(i).getMenuId();
            filaData[i][3]=lista.get(i).getMenuCantidad();
            filaData[i][4]=lista.get(i).getComidaId();
            filaData[i][5]=lista.get(i).getComidaCantidad();
            filaData[i][6]=lista.get(i).getBebidaId();
            filaData[i][7]=lista.get(i).getBebidaCantidad();
            filaData[i][8]="Q "+lista.get(i).getCosto();
            filaData[i][9]=lista.get(i).getTiempo();
            filaData[i][10]=lista.get(i).getSolvente();
            // Conseguir Total Consumo
            totalConsumo+=lista.get(i).getCosto();
            
            viwer.setText(
                    "<h3 style=\"\">Factura: "+filaData[i][1]+"</h3>"+
                    "<p>Menu: "+filaData[i][2]+"</p>"+
                    "<p>Costo: "+totalConsumo+"</p>"
            );
        }
    }
    
    private void limpiarTablaFacturas (){
        DefaultTableModel modelF = (DefaultTableModel) jTable_Factura_.getModel();
        jTable_Factura_.setPreferredSize(new java.awt.Dimension(jTable_Factura_.getWidth(), 0 ));
        
        int rowCount = modelF.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            modelF.removeRow(i);
        }
    }
    
    private void limpiarTablaPedidos (){
//        jEditorPane_Detalle_.setText("");
    }
    
    public Ventas() {
        initComponents();
        
        limpiarTablaFacturas();
        limpiarTablaPedidos();
        
        mostrarVentasActivas();
        borderFacturaFecha(date);
        try{
            setIconImage(new ImageIcon(getClass().getResource("/core/resources/chocolate.png")).getImage());
        }catch (Error err){
            System.err.println(err);
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

        jPanel_Main_ = new javax.swing.JPanel();
        jPanel_Clientes_ = new javax.swing.JPanel();
        jScrollPane_Clientes_ = new javax.swing.JScrollPane();
        jTable_Factura_ = new javax.swing.JTable();
        jButton_ClienteNuevo_ = new javax.swing.JButton();
        jLabel_BuscarPorFecha_ = new javax.swing.JLabel();
        jLabel_SinCobrar_ = new javax.swing.JLabel();
        jPanel_Detalle_ = new javax.swing.JPanel();
        jButton_NuevoPedido_ = new javax.swing.JButton();
        jButton_Cobrar_ = new javax.swing.JButton();
        jScrollPane_View_ = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("gui/venta/Bundle"); // NOI18N
        setTitle(bundle.getString("Ventas.title")); // NOI18N
        setMinimumSize(new java.awt.Dimension(1024, 740));
        setPreferredSize(new java.awt.Dimension(990, 700));
        setSize(new java.awt.Dimension(990, 700));
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        jPanel_Main_.setMinimumSize(new java.awt.Dimension(1000, 681));
        jPanel_Main_.setName("ventas_main_"); // NOI18N
        jPanel_Main_.setPreferredSize(new java.awt.Dimension(982, 681));

        jPanel_Clientes_.setBorder(javax.swing.BorderFactory.createTitledBorder(null, bundle.getString("Ventas.jPanel_Clientes_.border.title"), javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jPanel_Clientes_.setMinimumSize(new java.awt.Dimension(632, 669));
        jPanel_Clientes_.setPreferredSize(new java.awt.Dimension(632, 669));

        jScrollPane_Clientes_.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane_Clientes_.setMinimumSize(new java.awt.Dimension(600, 588));
        jScrollPane_Clientes_.setPreferredSize(new java.awt.Dimension(600, 588));

        jTable_Factura_.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jTable_Factura_.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Nota", "# Factura", "Monto", "Fecha", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Factura_.setToolTipText(bundle.getString("Ventas.jTable_Factura_.toolTipText")); // NOI18N
        jTable_Factura_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Factura_MouseClicked(evt);
            }
        });
        jScrollPane_Clientes_.setViewportView(jTable_Factura_);
        if (jTable_Factura_.getColumnModel().getColumnCount() > 0) {
            jTable_Factura_.getColumnModel().getColumn(1).setResizable(false);
            jTable_Factura_.getColumnModel().getColumn(1).setPreferredWidth(30);
            jTable_Factura_.getColumnModel().getColumn(2).setResizable(false);
            jTable_Factura_.getColumnModel().getColumn(2).setPreferredWidth(30);
        }

        jButton_ClienteNuevo_.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
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
        jLabel_BuscarPorFecha_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/core/resources/icons/calendar.x32.png"))); // NOI18N
        jLabel_BuscarPorFecha_.setText(bundle.getString("Ventas.jLabel_BuscarPorFecha_.text")); // NOI18N
        jLabel_BuscarPorFecha_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_BuscarPorFecha_.setMaximumSize(new java.awt.Dimension(150, 32));
        jLabel_BuscarPorFecha_.setMinimumSize(new java.awt.Dimension(150, 32));
        jLabel_BuscarPorFecha_.setPreferredSize(new java.awt.Dimension(150, 32));
        jLabel_BuscarPorFecha_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_BuscarPorFecha_MouseClicked(evt);
            }
        });

        jLabel_SinCobrar_.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        jLabel_SinCobrar_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/core/resources/icons/food32.png"))); // NOI18N
        jLabel_SinCobrar_.setText(bundle.getString("Ventas.jLabel_SinCobrar_.text")); // NOI18N
        jLabel_SinCobrar_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_SinCobrar_.setMaximumSize(new java.awt.Dimension(150, 32));
        jLabel_SinCobrar_.setMinimumSize(new java.awt.Dimension(150, 32));
        jLabel_SinCobrar_.setPreferredSize(new java.awt.Dimension(150, 32));
        jLabel_SinCobrar_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_SinCobrar_MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel_Clientes_Layout = new javax.swing.GroupLayout(jPanel_Clientes_);
        jPanel_Clientes_.setLayout(jPanel_Clientes_Layout);
        jPanel_Clientes_Layout.setHorizontalGroup(
            jPanel_Clientes_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Clientes_Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_Clientes_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane_Clientes_, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                    .addGroup(jPanel_Clientes_Layout.createSequentialGroup()
                        .addComponent(jButton_ClienteNuevo_, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_BuscarPorFecha_, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_SinCobrar_, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel_Clientes_Layout.setVerticalGroup(
            jPanel_Clientes_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Clientes_Layout.createSequentialGroup()
                .addComponent(jScrollPane_Clientes_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_Clientes_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_ClienteNuevo_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_BuscarPorFecha_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_SinCobrar_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_Detalle_.setBorder(javax.swing.BorderFactory.createTitledBorder(null, bundle.getString("Ventas.jPanel_Detalle_.border.title"), javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jPanel_Detalle_.setToolTipText(bundle.getString("Ventas.jPanel_Detalle_.toolTipText")); // NOI18N
        jPanel_Detalle_.setMinimumSize(new java.awt.Dimension(332, 669));
        jPanel_Detalle_.setPreferredSize(new java.awt.Dimension(332, 669));

        jButton_NuevoPedido_.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
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

        jButton_Cobrar_.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton_Cobrar_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/core/resources/icons/money.x32.png"))); // NOI18N
        jButton_Cobrar_.setText(bundle.getString("Ventas.jButton_Cobrar_.text")); // NOI18N
        jButton_Cobrar_.setMaximumSize(new java.awt.Dimension(140, 42));
        jButton_Cobrar_.setMinimumSize(new java.awt.Dimension(140, 42));
        jButton_Cobrar_.setPreferredSize(new java.awt.Dimension(140, 42));
        jButton_Cobrar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Cobrar_ActionPerformed(evt);
            }
        });

        jScrollPane_View_.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane_View_.setHorizontalScrollBar(null);
        jScrollPane_View_.setPreferredSize(new java.awt.Dimension(316, 588));

        javax.swing.GroupLayout jPanel_Detalle_Layout = new javax.swing.GroupLayout(jPanel_Detalle_);
        jPanel_Detalle_.setLayout(jPanel_Detalle_Layout);
        jPanel_Detalle_Layout.setHorizontalGroup(
            jPanel_Detalle_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_Detalle_Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel_Detalle_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_Detalle_Layout.createSequentialGroup()
                        .addComponent(jButton_NuevoPedido_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Cobrar_, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane_View_, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel_Detalle_Layout.setVerticalGroup(
            jPanel_Detalle_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Detalle_Layout.createSequentialGroup()
                .addComponent(jScrollPane_View_, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_Detalle_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_NuevoPedido_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Cobrar_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel_Main_Layout = new javax.swing.GroupLayout(jPanel_Main_);
        jPanel_Main_.setLayout(jPanel_Main_Layout);
        jPanel_Main_Layout.setHorizontalGroup(
            jPanel_Main_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Main_Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_Clientes_, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_Detalle_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel_Main_Layout.setVerticalGroup(
            jPanel_Main_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_Main_Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_Main_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel_Detalle_, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                    .addComponent(jPanel_Clientes_, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel_Main_);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_Cobrar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Cobrar_ActionPerformed
        Cobrar cobrar = new Cobrar();
        cobrar.setVisible(true);
    }//GEN-LAST:event_jButton_Cobrar_ActionPerformed

    private void jButton_NuevoPedido_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NuevoPedido_ActionPerformed
        NuevoPedido nuevoPedido = new NuevoPedido();
        nuevoPedido.setVisible(true);
    }//GEN-LAST:event_jButton_NuevoPedido_ActionPerformed

    private void jLabel_BuscarPorFecha_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_BuscarPorFecha_MouseClicked
        JDateChooser calendario = new JDateChooser();
        Date fechaActual = new Date();

        calendario.setDate(fechaActual);
        int selectFecha = JOptionPane.showOptionDialog(rootPane, add(calendario), "Selecciona la Fecha", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

        try {
            if (selectFecha == JOptionPane.OK_OPTION){
                limpiarTablaFacturas();
                borderFacturaFecha(calendario.getDate());
                mostrarVentasDia(formatoFechaDia.format(calendario.getDate()));
                date=calendario.getDate();
            }else{ }
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_jLabel_BuscarPorFecha_MouseClicked

    private void jButton_ClienteNuevo_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ClienteNuevo_ActionPerformed
        NuevoCliente clienteNuevo = new NuevoCliente();
        clienteNuevo.setVisible(true);
    }//GEN-LAST:event_jButton_ClienteNuevo_ActionPerformed

    private void jTable_Factura_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Factura_MouseClicked
        if (evt.getClickCount() == 2){

            int colId = 1;
            int row = jTable_Factura_.getSelectedRow();
            Object objId = (Object) jTable_Factura_.getValueAt(row, colId);

            limpiarTablaPedidos();

            try {
                mostrarVentasDetalleNumeroFactura((Integer) objId);
            } catch (BadLocationException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTable_Factura_MouseClicked

    private void jLabel_SinCobrar_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_SinCobrar_MouseClicked
        mostrarVentasActivas();
        borderFacturaFecha(date);
    }//GEN-LAST:event_jLabel_SinCobrar_MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Ventas().setVisible(true);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_ClienteNuevo_;
    private javax.swing.JButton jButton_Cobrar_;
    private javax.swing.JButton jButton_NuevoPedido_;
    private javax.swing.JLabel jLabel_BuscarPorFecha_;
    private javax.swing.JLabel jLabel_SinCobrar_;
    private javax.swing.JPanel jPanel_Clientes_;
    private javax.swing.JPanel jPanel_Detalle_;
    private javax.swing.JPanel jPanel_Main_;
    private javax.swing.JScrollPane jScrollPane_Clientes_;
    private javax.swing.JScrollPane jScrollPane_View_;
    private javax.swing.JTable jTable_Factura_;
    // End of variables declaration//GEN-END:variables

}
