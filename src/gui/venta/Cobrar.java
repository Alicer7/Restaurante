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
        jEditorPane_View_.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jEditorPane_View_.setMaximumSize(null);
        jEditorPane_View_.setMinimumSize(new java.awt.Dimension(300, 550));
        jEditorPane_View_.setPreferredSize(null);
        jEditorPane_View_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jEditorPane_View_MouseClicked(evt);
            }
        });
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

    private void jEditorPane_View_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jEditorPane_View_MouseClicked
        String head = 
                "<!DOCTYPE html>\n" +
                "<html lang=\"es\">\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<title>Factura</title>\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "<style>\n" +
                "html{font-size:62.5%}body{font-size:1.6rem;font-family:\"Open Sans\",sans-serif;color:#333;padding:2rem 0}@media print{body{-webkit-print-color-adjust:exact}}.hd{display:flex;align-items:center;justify-content:space-between;padding-bottom:2.5rem;border-bottom:1px solid #e6e7e8}.hd > img{max-width:30rem}.hd-info{color:#58595b}.hd-info > h2{font-size:3.2rem;font-weight:400}.hd-info > div{font-size:2.1rem}.t1{text-align:center;margin:3.6rem 0;font-size:4.2rem;font-weight:300;color:#6d6e71}.ref{background-color:#e6e7e8;padding:1.6rem 0;text-align:center}.ref-l1{font-size:2.4rem;font-weight:700}.ref-l2{font-size:2rem;margin-top:.5rem}.tbl{width:100%}.tbl thead th{border-bottom:1px solid #e6e7e8;padding:1.8rem 0;font-weight:400;font-size:2rem;color:#a7a9ac}.tbl thead th:first-child{text-align-last:left;padding-left:5rem}.tbl thead th:last-child{text-align:right;padding-right:5rem}.tbl tbody tr td{text-align:center;font-size:2.4rem;padding:1.8rem 0}.tbl tbody tr td:first-child{padding-left:5rem;text-align:left}.tbl tbody tr td:last-child{padding-right:5rem;text-align:right}.tbl tbody tr:last-child td{border-bottom:1px solid #e6e7e8}.tbl tfoot tr td{color:#a7a9ac;padding:1.2rem 0;font-size:2.4rem;text-align:right}.tbl tfoot tr td:first-child{text-align-last:left;padding-left:5rem}.tbl tfoot tr td:last-child{text-align-last:right;padding-right:5rem}.tbl tfoot .total td{border-bottom:1px solid #e6e7e8;border-top:1px solid #e6e7e8;font-size:3rem;font-weight:700;color:#333}.addr{margin-top:3.5rem}.addr > :first-child{background-color:#e6e7e8}.addr-head{font-size:2.4rem;padding:.5rem 0;text-align:center;display:flex}.addr-head > div{width:50%}.addr-body{display:flex;text-align:center;padding:2rem 0;font-size:2.4rem;color:#a7a9ac;border-bottom:1px solid #e6e7e8}.addr-body > div{width:50%}.note{margin-top:3.5rem;background-color:#e6e7e8;padding:1rem 0}.note > div{font-size:2rem;color:#a7a9ac}.note > div > span{color:#333}.cnt{margin-left:4.5rem;margin-right:4.5rem}"+ 
                "</style>\n" +
                "</head>"+
                "<body translate=\"no\">"
                ;
        String foots = 
                "</body>\n" + 
                "</html>"
                ;
        
        String cabecera = 
                "<div class=\"cnt\">\n" +
                "		<div class=\"hd\"><img src=\" data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAekAAAEECAYAAAAMFMzLAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyZpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNi1jMTQ1IDc5LjE2MzQ5OSwgMjAxOC8wOC8xMy0xNjo0MDoyMiAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIDIwMTkgKFdpbmRvd3MpIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOjZENzhBRDkxOTlENTExRTk5MDg0RjYyODEwOTk5NjlEIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOjZENzhBRDkyOTlENTExRTk5MDg0RjYyODEwOTk5NjlEIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6NkQ3OEFEOEY5OUQ1MTFFOTkwODRGNjI4MTA5OTk2OUQiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6NkQ3OEFEOTA5OUQ1MTFFOTkwODRGNjI4MTA5OTk2OUQiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz7vKFe+AABd6UlEQVR42uxd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\" />\n" +
                "			<div class=\"hd-info\">\n" +
                "				<h2>Fac# 000001</h2>\n" +
                "				<div>\n" +
                "					Empresa LTD<br/>\n" +
                "					Nit 1234567-K\n" +
                "				</div>\n" +
                "			</div>\n" +
                "		</div>\n" +
                "	</div>"+
                "	<div class=\"cnt t1\">¡Gracias por tu orden!</div>\n" +
                "	<div class=\"ref\">\n" +
                "		<div class=\"ref-l1\">Orden Ref: XG6T 46D8</div>\n" +
                "		<div class=\"ref-l2\">Feb-6, 2019 at 2:14 pm</div>\n" +
                "	</div>"+
                "	<div class=\"cnt\">\n" +
                "		<table class=\"tbl\" cellspacing=\"0\" cellpadding=\"0\">"+
                "			<thead>\n" +
                "				<tr>\n" +
                "					<th>Producto</th>\n" +
                "					<th>Cantidad</th>\n" +
                "					<th>Precio</th>\n" +
                "				</tr>\n" +
                "			</thead>"
                ;
        
        String pie = 
                "			<tfoot>\n" +
                "				<tr>\n" +
                "					<td colspan=\"2\">SUBTOTAL</td>\n" +
                "					<td>Q100.00</td>\n" +
                "				</tr>\n" +
                "				<tr>\n" +
                "					<td colspan=\"2\">Impuestos</td>\n" +
                "					<td>Q12.00</td>\n" +
                "				</tr>\n" +
                "				<tr>\n" +
                "					<td colspan=\"2\">Envío</td>\n" +
                "					<td>GRATIS</td>\n" +
                "				</tr>\n" +
                "				<tr class=\"total\">\n" +
                "					<td colspan=\"2\">TOTAL</td>\n" +
                "					<td>Q112.00</td>\n" +
                "				</tr>\n" +
                "			</tfoot>\n" +
                "		</table>\n" +
                "	</div>"
                ;
        
        String cuerpo = 
                "                       <tbody>\n" +
                "				<tr>\n" +
                "					<td>Producto 001</td>\n" +
                "					<td>2</td>\n" +
                "					<td>Q100.00</td>\n" +
                "				</tr>\n" +
                "				\n" +
                "			</tbody>";
        
        String body = cabecera+cuerpo+pie;
        
        ArrayList<String> listaS = new ArrayList<String>();
        ArrayList<Double> listaD = new ArrayList<Double>();
            
        try {
            listaS.add("texto 1");
            listaS.add("texto 2");
            listaS.add("texto 3");
            listaS.add("texto 4");
            listaS.add("texto 5");
            listaS.add("texto 6");
            listaS.add("texto 7");
            listaS.add("texto 8");
            listaS.add("texto 9");

            listaD.add(1.00);
            listaD.add(2.00);
            listaD.add(3.00);
            listaD.add(4.00);
            listaD.add(5.00);
            listaD.add(6.00);
            listaD.add(7.00);
            listaD.add(8.00);
            listaD.add(9.00);
        } catch (Exception e) {
        }
        
        
        
        jEditorPane_View_.setContentType("text/html");
        jEditorPane_View_.setText(head+body+foots);
        
        System.out.print("ArrayList : " + listaS + " : " + listaD);
    }//GEN-LAST:event_jEditorPane_View_MouseClicked

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
