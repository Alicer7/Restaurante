/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.venta;

import core.utils.engine.WebEngineX;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javafx.embed.swing.JFXPanel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Freddy Camposeco <freddy.camposeco@elementum69.com> <www.elementum69.com>
 */
public class Cobrar extends javax.swing.JFrame {
    private final Locale locale = new Locale("es", "GT");
    private final Integer CLIENTEID = gui.venta.VentasP.getCLIENTEID();
    private CambioEfectivo showPanelCambio;
        
    private DecimalFormatSymbols dfs;
    private DecimalFormat df;
    private Boolean esNumero = true;
    private String NIT = "CF";
    private Double TOTAL = 0.0;
    private Double SALDO = 0.0;
    private Double EFECTIVO = 0.0;
    private Double ELECTRONICO = 0.0;
    private Double DESCUENTO = 0.0;
    
    private WebEngineX webEngine;
    private JFXPanel jFxPanel;
    
    private void setToltips(){
        jLabel_Total_.setToolTipText("Q "+df.format(TOTAL));
        jLabel_Saldo_.setToolTipText("Q "+df.format(SALDO));
    }
    
    int CODIGOPEDIDO = 0; 
    
    private void mostrarSaldo(){
        SALDO = (ELECTRONICO + EFECTIVO + DESCUENTO) - TOTAL ;
        if (SALDO<0){
            jLabel_SaldoQ_.setForeground(new java.awt.Color(255, 0, 0));
            jLabel_Saldo_.setForeground(new java.awt.Color(255, 0, 0));
        } else if (SALDO==0){
            jLabel_SaldoQ_.setForeground(new java.awt.Color(0, 0, 255));
            jLabel_Saldo_.setForeground(new java.awt.Color(0, 0, 255));
        } else if (SALDO>0){
            jLabel_SaldoQ_.setForeground(new java.awt.Color(0, 255, 0));
            jLabel_Saldo_.setForeground(new java.awt.Color(0, 255, 0));
        } else {
            System.out.println("Cobrar > mostrarSaldo > Error no especificado");
        }
        jLabel_Saldo_.setText(df.format(SALDO));
        setToltips();
    }
    
    private void moElectronicoFormat(){
        
        try {
            Double.parseDouble(jTextField_MoElectronico_.getText());
            esNumero = true;
        } catch (Exception e) {
            esNumero = false;
        }
        
        if ( jTextField_MoElectronico_.getText()==null ||  ("".equals(jTextField_MoElectronico_.getText())) || esNumero!=true ){
            jTextField_MoElectronico_.setText("0.00");
            ELECTRONICO = Double.parseDouble(jTextField_MoElectronico_.getText());
        } else if ( (ELECTRONICO= Double.parseDouble(jTextField_MoElectronico_.getText())) > 0 ) {
            jTextField_MoElectronico_.setText(df.format(ELECTRONICO));
        } else {
            jTextField_MoElectronico_.setText("0.00");
            ELECTRONICO = Double.parseDouble(jTextField_MoElectronico_.getText());
        }

        try {
            mostrarSaldo();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
        
    private void moEfectivoFormat(){
        try {
            Double.parseDouble(jTextField_MoEfectivo_.getText());
            esNumero = true;
        } catch (Exception e) {
            esNumero = false;
        }
        
        if ( jTextField_MoEfectivo_.getText()==null ||  ("".equals(jTextField_MoEfectivo_.getText())) || esNumero!=true){
            jTextField_MoEfectivo_.setText("0.00");
            EFECTIVO = Double.parseDouble(jTextField_MoEfectivo_.getText());         
        } else if ( (EFECTIVO = Double.parseDouble(jTextField_MoEfectivo_.getText())) > 0 ) {
            jTextField_MoEfectivo_.setText(df.format(EFECTIVO));
        } else {
            jTextField_MoEfectivo_.setText("0.00");
            EFECTIVO = Double.parseDouble(jTextField_MoEfectivo_.getText()); 
        }

        try {
            mostrarSaldo();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    private void moDescuentoFormat (){
        try {
            Double.parseDouble(jTextField_Descuento_.getText());
            esNumero = true;
        } catch (Exception e) {
            esNumero = false;
        }
        
        if ( jTextField_Descuento_.getText()==null ||  ("".equals(jTextField_Descuento_.getText())) || esNumero!=true){
            jTextField_Descuento_.setText("0.00");
            DESCUENTO = Double.parseDouble(jTextField_Descuento_.getText());         
        } else if ( (DESCUENTO = Double.parseDouble(jTextField_Descuento_.getText())) > 0 ) {
            jTextField_Descuento_.setText(df.format(DESCUENTO));
        } else {
            jTextField_Descuento_.setText("0.00");
            DESCUENTO = Double.parseDouble(jTextField_Descuento_.getText()); 
        }
        
        try {
            mostrarSaldo();
            webEngine.addDescuentoDetalle(DESCUENTO);
            System.err.println("Cobrar > moDescuentoFormat > webEngine:Descuento >> Q. "+DESCUENTO);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    private void startViewer (){
        webEngine = new WebEngineX();
        jFxPanel = webEngine.getjFxPanel();
    }
    
    private void loadViewer(){
        webEngine.loadViewer(false);
    }
    
    private void addDetallePanel(){
        try {
            startViewer ();
            jScrollPane_Detalle_.getViewport().add(jFxPanel);
            loadViewer ();
        } catch (Exception e) {
            System.err.println("addDetallePanel"+e);
        }
    }
    
    private void mostrarDetalle(){
        webEngine.mostrarDetalle(CLIENTEID);
        TOTAL=webEngine.getTOTAL();
        System.err.println("Cobrar > mostrarDetalle >> Total: "+df.format(TOTAL));
        jLabel_Total_.setText(df.format(TOTAL));
    }
        
    public void imprimir() {
        webEngine.printNode();
    }
    
    private void sendPrint (){
        if (SALDO > 0){
            showPanelCambio = new CambioEfectivo();
            showPanelCambio.setCambio(SALDO);
            showPanelCambio.setVisible(true);
            
            try {
                imprimir();
            } catch (Exception e) {
                System.err.println(e);
            } finally {
                dispose();
            }
        } else {
            System.out.println("Cobrar > sendPrint > Sin cambio en efectivo.");
            try {
                imprimir();
            } catch (Exception e) {
                System.err.println("Cobrar > sendPrint > Error de impresión: "+e);
            } finally {
                dispose();
            }
        } 
    }
    
    private void soventarFactura(){
        core.database.querry.Factura f = new core.database.querry.Factura();
        f.solventarFactura(webEngine.getTOTAL(), DESCUENTO, EFECTIVO, ELECTRONICO, SALDO, CLIENTEID, NIT);
    }
    
    private void mensajeSinCobrar(){
        String botones[] = {"Aceptar", "Cancelar"};
        JOptionPane.showOptionDialog(this, "Por favor Indica el pago del cliente en los campos correspondientes.", "No hay nada que cobrar!", 0, 0, null, botones, this);
    }

    private void settings(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(gui.MainMenu.getIconDir())));
        try { 
            UIManager.setLookAndFeel("com.alee.laf.WebLookAndFeel"); 
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ignored){}
        setTitle("");
        
        dfs = new DecimalFormatSymbols(locale);
        dfs.setDecimalSeparator('.');
        dfs.setGroupingSeparator(',');
        df = new DecimalFormat("###,###,###,##0.00",dfs);
        
    }
    
    private void settingsPos(){
        
    }
    
    public Cobrar() {
        settings ();
        initComponents();
        addDetallePanel();
        mostrarDetalle();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Main_ = new javax.swing.JPanel();
        jPanel_Controlls_ = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel_Total_ = new javax.swing.JPanel();
        jLabel_TotalQ_ = new javax.swing.JLabel();
        jLabel_Total_ = new javax.swing.JLabel();
        jPanel_MetodoPago_ = new javax.swing.JPanel();
        jTextField_MoElectronico_ = new javax.swing.JTextField();
        jTextField_MoEfectivo_ = new javax.swing.JTextField();
        jTextField_Descuento_ = new javax.swing.JTextField();
        jTextField_NIT_ = new javax.swing.JTextField();
        jLabel_MoElectronico_ = new javax.swing.JLabel();
        jLabel_MoElectronicoIcon_ = new javax.swing.JLabel();
        jLabel_MoEfectivo_ = new javax.swing.JLabel();
        jLabel_MoEfectivoIcon_ = new javax.swing.JLabel();
        jLabel_Descuento_ = new javax.swing.JLabel();
        jLabel_DescuentoIcon_ = new javax.swing.JLabel();
        jLabel_NIT_ = new javax.swing.JLabel();
        jLabel_NITIcon_ = new javax.swing.JLabel();
        jPanel_Saldo_ = new javax.swing.JPanel();
        jLabel_SaldoQ_ = new javax.swing.JLabel();
        jLabel_Saldo_ = new javax.swing.JLabel();
        jPanel_Imprimir_ = new javax.swing.JPanel();
        jButton_Imprimir_ = new javax.swing.JButton();
        jPanel_PreView_ = new javax.swing.JPanel();
        jScrollPane_Detalle_ = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Factura # 2019CB0000001");
        setMaximumSize(null);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel_Main_.setLayout(new java.awt.BorderLayout());

        jPanel_Controlls_.setLayout(new java.awt.BorderLayout());

        jPanel1.setMaximumSize(null);

        jPanel_Total_.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel_Total_.setMaximumSize(null);
        jPanel_Total_.setMinimumSize(new java.awt.Dimension(340, 128));
        jPanel_Total_.setName(""); // NOI18N
        jPanel_Total_.setPreferredSize(new java.awt.Dimension(340, 128));

        jLabel_TotalQ_.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel_TotalQ_.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_TotalQ_.setText("Q");

        jLabel_Total_.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel_Total_.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_Total_.setText("0.00");

        javax.swing.GroupLayout jPanel_Total_Layout = new javax.swing.GroupLayout(jPanel_Total_);
        jPanel_Total_.setLayout(jPanel_Total_Layout);
        jPanel_Total_Layout.setHorizontalGroup(
            jPanel_Total_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Total_Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_TotalQ_, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Total_, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_Total_Layout.setVerticalGroup(
            jPanel_Total_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_Total_Layout.createSequentialGroup()
                .addGroup(jPanel_Total_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_Total_, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_TotalQ_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel_MetodoPago_.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Método de Pago", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel_MetodoPago_.setMaximumSize(null);
        jPanel_MetodoPago_.setMinimumSize(new java.awt.Dimension(328, 294));
        jPanel_MetodoPago_.setPreferredSize(new java.awt.Dimension(328, 294));

        jTextField_MoElectronico_.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_MoElectronico_.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_MoElectronico_.setText("0.00");
        jTextField_MoElectronico_.setMaximumSize(null);
        jTextField_MoElectronico_.setMinimumSize(new java.awt.Dimension(148, 48));
        jTextField_MoElectronico_.setPreferredSize(new java.awt.Dimension(148, 48));
        jTextField_MoElectronico_.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_MoElectronico_FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_MoElectronico_FocusLost(evt);
            }
        });
        jTextField_MoElectronico_.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_MoElectronico_KeyReleased(evt);
            }
        });

        jTextField_MoEfectivo_.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_MoEfectivo_.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_MoEfectivo_.setText("0.00");
        jTextField_MoEfectivo_.setMaximumSize(null);
        jTextField_MoEfectivo_.setMinimumSize(new java.awt.Dimension(148, 48));
        jTextField_MoEfectivo_.setPreferredSize(new java.awt.Dimension(148, 48));
        jTextField_MoEfectivo_.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_MoEfectivo_FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_MoEfectivo_FocusLost(evt);
            }
        });
        jTextField_MoEfectivo_.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_MoEfectivo_KeyReleased(evt);
            }
        });

        jTextField_Descuento_.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_Descuento_.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_Descuento_.setText("0.00");
        jTextField_Descuento_.setMaximumSize(null);
        jTextField_Descuento_.setMinimumSize(new java.awt.Dimension(148, 48));
        jTextField_Descuento_.setPreferredSize(new java.awt.Dimension(148, 48));
        jTextField_Descuento_.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_Descuento_FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_Descuento_FocusLost(evt);
            }
        });
        jTextField_Descuento_.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_Descuento_KeyReleased(evt);
            }
        });

        jTextField_NIT_.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_NIT_.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_NIT_.setText("CF");
        jTextField_NIT_.setMaximumSize(null);
        jTextField_NIT_.setMinimumSize(new java.awt.Dimension(148, 48));
        jTextField_NIT_.setPreferredSize(new java.awt.Dimension(148, 48));
        jTextField_NIT_.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_NIT_FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_NIT_FocusLost(evt);
            }
        });
        jTextField_NIT_.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_NIT_KeyReleased(evt);
            }
        });

        jLabel_MoElectronico_.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_MoElectronico_.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_MoElectronico_.setText("Electrónico:");
        jLabel_MoElectronico_.setMaximumSize(new java.awt.Dimension(110, 48));
        jLabel_MoElectronico_.setMinimumSize(new java.awt.Dimension(110, 48));
        jLabel_MoElectronico_.setOpaque(true);
        jLabel_MoElectronico_.setPreferredSize(new java.awt.Dimension(110, 48));

        jLabel_MoElectronicoIcon_.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel_MoElectronicoIcon_.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_MoElectronicoIcon_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/core/resources/icons/CreditCarX32.png"))); // NOI18N
        jLabel_MoElectronicoIcon_.setMaximumSize(new java.awt.Dimension(28, 48));
        jLabel_MoElectronicoIcon_.setMinimumSize(new java.awt.Dimension(28, 48));
        jLabel_MoElectronicoIcon_.setPreferredSize(new java.awt.Dimension(28, 48));
        jLabel_MoElectronicoIcon_.setRequestFocusEnabled(false);

        jLabel_MoEfectivo_.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_MoEfectivo_.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_MoEfectivo_.setText("Efectivo:");
        jLabel_MoEfectivo_.setMaximumSize(new java.awt.Dimension(110, 48));
        jLabel_MoEfectivo_.setMinimumSize(new java.awt.Dimension(110, 48));
        jLabel_MoEfectivo_.setOpaque(true);
        jLabel_MoEfectivo_.setPreferredSize(new java.awt.Dimension(110, 48));

        jLabel_MoEfectivoIcon_.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel_MoEfectivoIcon_.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_MoEfectivoIcon_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/core/resources/icons/WalletX32.png"))); // NOI18N
        jLabel_MoEfectivoIcon_.setMaximumSize(new java.awt.Dimension(28, 48));
        jLabel_MoEfectivoIcon_.setMinimumSize(new java.awt.Dimension(28, 48));
        jLabel_MoEfectivoIcon_.setPreferredSize(new java.awt.Dimension(28, 48));
        jLabel_MoEfectivoIcon_.setRequestFocusEnabled(false);

        jLabel_Descuento_.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_Descuento_.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_Descuento_.setText("Descuento:");
        jLabel_Descuento_.setMaximumSize(new java.awt.Dimension(110, 48));
        jLabel_Descuento_.setMinimumSize(new java.awt.Dimension(110, 48));
        jLabel_Descuento_.setOpaque(true);
        jLabel_Descuento_.setPreferredSize(new java.awt.Dimension(110, 48));

        jLabel_DescuentoIcon_.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel_DescuentoIcon_.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_DescuentoIcon_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/core/resources/icons/FunAsClienteX32.png"))); // NOI18N
        jLabel_DescuentoIcon_.setMaximumSize(new java.awt.Dimension(28, 48));
        jLabel_DescuentoIcon_.setMinimumSize(new java.awt.Dimension(28, 48));
        jLabel_DescuentoIcon_.setPreferredSize(new java.awt.Dimension(28, 48));
        jLabel_DescuentoIcon_.setRequestFocusEnabled(false);

        jLabel_NIT_.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_NIT_.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_NIT_.setText("NIT:");
        jLabel_NIT_.setMaximumSize(new java.awt.Dimension(110, 48));
        jLabel_NIT_.setMinimumSize(new java.awt.Dimension(110, 48));
        jLabel_NIT_.setOpaque(true);
        jLabel_NIT_.setPreferredSize(new java.awt.Dimension(110, 48));

        jLabel_NITIcon_.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel_NITIcon_.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_NITIcon_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/core/resources/icons/help0X32.png"))); // NOI18N
        jLabel_NITIcon_.setMaximumSize(new java.awt.Dimension(28, 48));
        jLabel_NITIcon_.setMinimumSize(new java.awt.Dimension(28, 48));
        jLabel_NITIcon_.setPreferredSize(new java.awt.Dimension(28, 48));
        jLabel_NITIcon_.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel_MetodoPago_Layout = new javax.swing.GroupLayout(jPanel_MetodoPago_);
        jPanel_MetodoPago_.setLayout(jPanel_MetodoPago_Layout);
        jPanel_MetodoPago_Layout.setHorizontalGroup(
            jPanel_MetodoPago_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_MetodoPago_Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_MetodoPago_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_MetodoPago_Layout.createSequentialGroup()
                        .addComponent(jLabel_Descuento_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_DescuentoIcon_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_Descuento_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel_MetodoPago_Layout.createSequentialGroup()
                        .addComponent(jLabel_MoElectronico_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_MoElectronicoIcon_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_MoElectronico_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel_MetodoPago_Layout.createSequentialGroup()
                        .addComponent(jLabel_MoEfectivo_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_MoEfectivoIcon_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_MoEfectivo_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel_MetodoPago_Layout.createSequentialGroup()
                        .addComponent(jLabel_NIT_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_NITIcon_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_NIT_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel_MetodoPago_Layout.setVerticalGroup(
            jPanel_MetodoPago_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_MetodoPago_Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_MetodoPago_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_MoElectronico_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_MoElectronicoIcon_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_MoElectronico_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_MetodoPago_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_MoEfectivo_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_MoEfectivoIcon_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_MoEfectivo_, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_MetodoPago_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Descuento_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_DescuentoIcon_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Descuento_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_MetodoPago_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_NIT_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_NITIcon_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_NIT_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_Saldo_.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Saldo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel_Saldo_.setMaximumSize(null);
        jPanel_Saldo_.setMinimumSize(new java.awt.Dimension(340, 128));
        jPanel_Saldo_.setPreferredSize(new java.awt.Dimension(340, 128));

        jLabel_SaldoQ_.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel_SaldoQ_.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_SaldoQ_.setText("Q");

        jLabel_Saldo_.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel_Saldo_.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_Saldo_.setText("0.00");

        javax.swing.GroupLayout jPanel_Saldo_Layout = new javax.swing.GroupLayout(jPanel_Saldo_);
        jPanel_Saldo_.setLayout(jPanel_Saldo_Layout);
        jPanel_Saldo_Layout.setHorizontalGroup(
            jPanel_Saldo_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Saldo_Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_SaldoQ_, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Saldo_, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_Saldo_Layout.setVerticalGroup(
            jPanel_Saldo_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_Saldo_Layout.createSequentialGroup()
                .addGroup(jPanel_Saldo_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_Saldo_, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_SaldoQ_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Total_, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
            .addComponent(jPanel_MetodoPago_, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
            .addComponent(jPanel_Saldo_, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel_Total_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel_MetodoPago_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel_Saldo_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jPanel_Controlls_.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel_Imprimir_.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Imprimir", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel_Imprimir_.setMaximumSize(null);
        jPanel_Imprimir_.setMinimumSize(new java.awt.Dimension(340, 128));
        jPanel_Imprimir_.setPreferredSize(new java.awt.Dimension(340, 128));

        jButton_Imprimir_.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButton_Imprimir_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/core/resources/icons/TicketX48.png"))); // NOI18N
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
                .addComponent(jButton_Imprimir_, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel_Imprimir_Layout.setVerticalGroup(
            jPanel_Imprimir_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Imprimir_Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_Imprimir_, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel_Controlls_.add(jPanel_Imprimir_, java.awt.BorderLayout.SOUTH);

        jPanel_Main_.add(jPanel_Controlls_, java.awt.BorderLayout.CENTER);

        jPanel_PreView_.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vista Previa", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel_PreView_.setMinimumSize(new java.awt.Dimension(340, 688));
        jPanel_PreView_.setName(""); // NOI18N
        jPanel_PreView_.setPreferredSize(new java.awt.Dimension(340, 688));
        jPanel_PreView_.setLayout(new java.awt.BorderLayout());

        jScrollPane_Detalle_.setMaximumSize(null);
        jScrollPane_Detalle_.setMinimumSize(new java.awt.Dimension(32, 32));
        jScrollPane_Detalle_.setPreferredSize(new java.awt.Dimension(32, 32));
        jPanel_PreView_.add(jScrollPane_Detalle_, java.awt.BorderLayout.CENTER);

        jPanel_Main_.add(jPanel_PreView_, java.awt.BorderLayout.WEST);

        getContentPane().add(jPanel_Main_, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        jScrollPane_Detalle_.getViewport().removeAll();
    }//GEN-LAST:event_formWindowClosing

    private void jTextField_MoElectronico_KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_MoElectronico_KeyReleased
        int key = evt.getKeyCode();
        if ( java.awt.event.KeyEvent.VK_ENTER == key){
            jTextField_MoEfectivo_.requestFocus();
        }
    }//GEN-LAST:event_jTextField_MoElectronico_KeyReleased

    private void jTextField_MoEfectivo_KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_MoEfectivo_KeyReleased
        int key = evt.getKeyCode();
        if ( java.awt.event.KeyEvent.VK_ENTER == key){
            jTextField_Descuento_.requestFocus();
        }
    }//GEN-LAST:event_jTextField_MoEfectivo_KeyReleased

    private void jTextField_Descuento_KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Descuento_KeyReleased
        int key = evt.getKeyCode();
        if ( java.awt.event.KeyEvent.VK_ENTER == key){
            jTextField_NIT_.requestFocus();
        }
    }//GEN-LAST:event_jTextField_Descuento_KeyReleased

    private void jTextField_MoElectronico_FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_MoElectronico_FocusGained
        jTextField_MoElectronico_.selectAll();
    }//GEN-LAST:event_jTextField_MoElectronico_FocusGained

    private void jTextField_MoElectronico_FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_MoElectronico_FocusLost
        moElectronicoFormat();
    }//GEN-LAST:event_jTextField_MoElectronico_FocusLost

    private void jTextField_MoEfectivo_FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_MoEfectivo_FocusGained
        jTextField_MoEfectivo_.selectAll();
    }//GEN-LAST:event_jTextField_MoEfectivo_FocusGained

    private void jTextField_MoEfectivo_FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_MoEfectivo_FocusLost
        moEfectivoFormat();
    }//GEN-LAST:event_jTextField_MoEfectivo_FocusLost

    private void jTextField_Descuento_FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_Descuento_FocusGained
        jTextField_Descuento_.selectAll();
    }//GEN-LAST:event_jTextField_Descuento_FocusGained

    private void jTextField_Descuento_FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_Descuento_FocusLost
        moDescuentoFormat();
    }//GEN-LAST:event_jTextField_Descuento_FocusLost

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setToltips();
        moElectronicoFormat();
    }//GEN-LAST:event_formWindowOpened

    private void jButton_Imprimir_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Imprimir_ActionPerformed
        if (SALDO<0) {
            mensajeSinCobrar();
        } else {
            try {
                soventarFactura();
                System.out.println("Cobrar > jButton_Imprimir_ActionPerformed >> soventarFactura");
                sendPrint();
                System.out.println("Cobrar > jButton_Imprimir_ActionPerformed >> sendPrint");
            } catch (Exception e) {
                System.err.println("Cobrar > jButton_Imprimir_ActionPerformed >> Error: "+e);
            }
        }
    }//GEN-LAST:event_jButton_Imprimir_ActionPerformed

    private void jTextField_NIT_FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_NIT_FocusGained
        jTextField_NIT_.selectAll();
    }//GEN-LAST:event_jTextField_NIT_FocusGained

    private void jTextField_NIT_FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_NIT_FocusLost
        NIT=jTextField_NIT_.getText();
    }//GEN-LAST:event_jTextField_NIT_FocusLost

    private void jTextField_NIT_KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_NIT_KeyReleased
        int key = evt.getKeyCode();
        if ( java.awt.event.KeyEvent.VK_ENTER == key){
            jButton_Imprimir_.requestFocus();
        }
    }//GEN-LAST:event_jTextField_NIT_KeyReleased

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
            java.util.logging.Logger.getLogger(Cobrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cobrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cobrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cobrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(() -> {
            new Cobrar().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Imprimir_;
    private javax.swing.JLabel jLabel_DescuentoIcon_;
    private javax.swing.JLabel jLabel_Descuento_;
    private javax.swing.JLabel jLabel_MoEfectivoIcon_;
    private javax.swing.JLabel jLabel_MoEfectivo_;
    private javax.swing.JLabel jLabel_MoElectronicoIcon_;
    private javax.swing.JLabel jLabel_MoElectronico_;
    private javax.swing.JLabel jLabel_NITIcon_;
    private javax.swing.JLabel jLabel_NIT_;
    private javax.swing.JLabel jLabel_SaldoQ_;
    private javax.swing.JLabel jLabel_Saldo_;
    private javax.swing.JLabel jLabel_TotalQ_;
    private javax.swing.JLabel jLabel_Total_;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_Controlls_;
    private javax.swing.JPanel jPanel_Imprimir_;
    private javax.swing.JPanel jPanel_Main_;
    private javax.swing.JPanel jPanel_MetodoPago_;
    private javax.swing.JPanel jPanel_PreView_;
    private javax.swing.JPanel jPanel_Saldo_;
    private javax.swing.JPanel jPanel_Total_;
    private javax.swing.JScrollPane jScrollPane_Detalle_;
    private javax.swing.JTextField jTextField_Descuento_;
    private javax.swing.JTextField jTextField_MoEfectivo_;
    private javax.swing.JTextField jTextField_MoElectronico_;
    private javax.swing.JTextField jTextField_NIT_;
    // End of variables declaration//GEN-END:variables
}
