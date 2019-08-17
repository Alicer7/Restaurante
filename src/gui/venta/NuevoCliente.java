/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.venta;

import core.database.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Freddy Camposeco <ankoku.fj@gmail.com> <www.stufs.rf.gd>
 */
public class NuevoCliente extends javax.swing.JFrame {

    public void getBuscarComida() {
        try {
            Conexion cone = new Conexion();
            com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) cone.connect();
            PreparedStatement ps = null;
            ResultSet rs = null;
            DefaultTableModel modelo = new DefaultTableModel();
            jtComida_.setModel(modelo);

            String sql = "select id, nombre, format(precio,2) from comida where nombre LIKE '%" + txtbuscarComida.getText() + "%' order by(id) ";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Código.");
            modelo.addColumn("Nombre");
            modelo.addColumn("precio");

            int[] anchos = {0, 200, 50};
            for (int i = 0; i < jtComida_.getColumnCount(); i++) {
                jtComida_.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }

            ps = conn.prepareStatement("SELECT `nombre`, `apellido` FROM `cafebar`.`empleado` WHERE `estado` = 'Activo' ORDER BY `id`");
            rs = ps.executeQuery();

            while (rs.next()) {
                jComboBox_Empleado_.addItem(rs.getString("nombre") + " " + rs.getString("apellido"));

            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    public void getBuscarBebida() {
        try {
            Conexion cone = new Conexion();
            com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) cone.connect();
            PreparedStatement ps = null;
            ResultSet rs = null;
            DefaultTableModel modelo = new DefaultTableModel();
            jtBebidas_.setModel(modelo);

            String sql = "select id, nombre, precio from bebida where nombre LIKE '%" + txtBuscarBebida.getText() + "%' order by(id) ";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Código.");
            modelo.addColumn("Nombre");
            modelo.addColumn("Precio");

            int[] anchos = {10, 200, 50};
            for (int i = 0; i < jtBebidas_.getColumnCount(); i++) {
                jtBebidas_.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

    }

    ;
    
    public void addComida() {
        try {
            Conexion cone = new Conexion();
            com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) cone.connect();
            PreparedStatement ps = null;

            int filas = jtPedido.getRowCount();
            for (int row = 0; row < filas; row++) {
                ps = conn.prepareStatement("INSERT INTO `temp_pedido` (`temp_venta_id`, `comida_id`, `comida_cantidad`, costo, `estado`) VALUES (?,?,?,?,?)");
                ps.setInt(1, 2);
                ps.setInt(2, 1);
                ps.setInt(3, 1);
                ps.setDouble(4, 12.50);
                ps.setString(5, "Activa");
                ps.execute();

            }
            JOptionPane.showMessageDialog(null, "Ingresado Correctamente");
            tabla();
        } catch (SQLException ex) {
        }
    }

    public void popuptable() {
        JPopupMenu popmenu = new JPopupMenu();
        JMenuItem menuitem = new JMenuItem("Eliminar", new ImageIcon(getClass().getResource("/core/resources/icons/eli.png")));
        menuitem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) jtPedido.getModel();
                int a = jtPedido.getSelectedRow();
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

        jtPedido.setComponentPopupMenu(popmenu);
    }

    public void tabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        jtPedido.setModel(modelo);
        modelo.addColumn("id.");
        modelo.addColumn("Platillo");
        modelo.addColumn("cantidad");
        modelo.addColumn("Total");
    }

    DefaultTableModel modelo2 = new DefaultTableModel();
//            jtCombos.setModel(modelo2);
    Double precio_comida = 0.0;
    Double precio_bebida = 0.0;

    Double TOTAL1 = 0.0;
    Double TOTAL2 = 0.0;

    String COMIDA = null;
    String BEBIDA = null;

    int CODIGOBEBIDA = 0;
    int CODIGOCOMIDA = 0;

    /**
     * Creates new form FacturaNueva
     */
    public NuevoCliente() {
        initComponents();
//      
        tabla();
        popuptable();
        txtCant1.setText("1");
        txtCant2.setText("1");
        getBuscarComida();
        getBuscarBebida();
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
        jPanel_Alimentos_ = new javax.swing.JPanel();
        jLabel_ComboPrecioUnitario_2 = new javax.swing.JLabel();
        jLabel_ComboSubTotal_2 = new javax.swing.JLabel();
        jLabel_ComboCantidad_2 = new javax.swing.JLabel();
        jLabel_PrecioUnitarioQ_2 = new javax.swing.JLabel();
        lblUnitarioComida = new javax.swing.JLabel();
        jLabel_SubTotalQ_2 = new javax.swing.JLabel();
        lblSubtotalComida = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtComida_ = new javax.swing.JTable();
        txtbuscarComida = new javax.swing.JTextField();
        jButton_AddPedido_ = new javax.swing.JButton();
        txtCant1 = new javax.swing.JTextField();
        jPanel_Bebidas_ = new javax.swing.JPanel();
        jLabel_ComboPrecioUnitario_1 = new javax.swing.JLabel();
        jLabel_ComboSubTotal_1 = new javax.swing.JLabel();
        jLabel_ComboCantidad_1 = new javax.swing.JLabel();
        jLabel_PrecioUnitarioQ_1 = new javax.swing.JLabel();
        jLabel_PrecioUnitarioNum_1 = new javax.swing.JLabel();
        jLabel_SubTotalQ_1 = new javax.swing.JLabel();
        lblsubtotalbebidas = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtBebidas_ = new javax.swing.JTable();
        txtBuscarBebida = new javax.swing.JTextField();
        jButton_AddPedido_1 = new javax.swing.JButton();
        txtCant2 = new javax.swing.JTextField();
        jScrollPane = new javax.swing.JScrollPane();
        jPanel_Pedidos_ = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtPedido = new javax.swing.JTable();
        jButton_Aceptar_ = new javax.swing.JButton();
        jButton_Cancelar_ = new javax.swing.JButton();
        jLabel_Nota_ = new javax.swing.JLabel();
        jLabel_Factura_ = new javax.swing.JLabel();
        jLabel_FactureNumero_ = new javax.swing.JLabel();
        jComboBox_Empleado_ = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cliente Nuevo");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel_Main_.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente Nuevo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jPanel_Alimentos_.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Comidas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel_ComboPrecioUnitario_2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_ComboPrecioUnitario_2.setText("Precio Unitario:");

        jLabel_ComboSubTotal_2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_ComboSubTotal_2.setText("Subtotal:");

        jLabel_ComboCantidad_2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_ComboCantidad_2.setText("Cantidad:");

        jLabel_PrecioUnitarioQ_2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_PrecioUnitarioQ_2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_PrecioUnitarioQ_2.setText("Q. ");

        lblUnitarioComida.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblUnitarioComida.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUnitarioComida.setText("0.0");

        jLabel_SubTotalQ_2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_SubTotalQ_2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_SubTotalQ_2.setText("Q. ");

        lblSubtotalComida.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSubtotalComida.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubtotalComida.setText("0.0");

        jtComida_.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtComida_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtComida_MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jtComida_);

        txtbuscarComida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarComidaKeyReleased(evt);
            }
        });

        jButton_AddPedido_.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_AddPedido_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/core/resources/icons/clocheX32.png"))); // NOI18N
        jButton_AddPedido_.setMaximumSize(new java.awt.Dimension(292, 93));
        jButton_AddPedido_.setMinimumSize(new java.awt.Dimension(292, 93));
        jButton_AddPedido_.setPreferredSize(new java.awt.Dimension(292, 93));
        jButton_AddPedido_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddPedido_ActionPerformed(evt);
            }
        });

        txtCant1.setText("0");
        txtCant1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCant1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel_Alimentos_Layout = new javax.swing.GroupLayout(jPanel_Alimentos_);
        jPanel_Alimentos_.setLayout(jPanel_Alimentos_Layout);
        jPanel_Alimentos_Layout.setHorizontalGroup(
            jPanel_Alimentos_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Alimentos_Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_Alimentos_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_Alimentos_Layout.createSequentialGroup()
                        .addComponent(jLabel_ComboCantidad_2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCant1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_AddPedido_, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_Alimentos_Layout.createSequentialGroup()
                        .addGroup(jPanel_Alimentos_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel_ComboSubTotal_2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_ComboPrecioUnitario_2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel_Alimentos_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_Alimentos_Layout.createSequentialGroup()
                                .addComponent(jLabel_PrecioUnitarioQ_2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblUnitarioComida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel_Alimentos_Layout.createSequentialGroup()
                                .addComponent(jLabel_SubTotalQ_2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSubtotalComida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                    .addComponent(txtbuscarComida))
                .addContainerGap())
        );
        jPanel_Alimentos_Layout.setVerticalGroup(
            jPanel_Alimentos_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_Alimentos_Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtbuscarComida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_Alimentos_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ComboPrecioUnitario_2)
                    .addComponent(jLabel_PrecioUnitarioQ_2)
                    .addComponent(lblUnitarioComida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_Alimentos_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ComboSubTotal_2)
                    .addComponent(jLabel_SubTotalQ_2)
                    .addComponent(lblSubtotalComida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_Alimentos_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_Alimentos_Layout.createSequentialGroup()
                        .addGroup(jPanel_Alimentos_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_ComboCantidad_2)
                            .addComponent(txtCant1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addComponent(jButton_AddPedido_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel_Bebidas_.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bebidas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel_ComboPrecioUnitario_1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_ComboPrecioUnitario_1.setText("Precio Unitario:");

        jLabel_ComboSubTotal_1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_ComboSubTotal_1.setText("Subtotal:");

        jLabel_ComboCantidad_1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_ComboCantidad_1.setText("Cantidad:");

        jLabel_PrecioUnitarioQ_1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_PrecioUnitarioQ_1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_PrecioUnitarioQ_1.setText("Q. ");

        jLabel_PrecioUnitarioNum_1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_PrecioUnitarioNum_1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_PrecioUnitarioNum_1.setText("0.0");

        jLabel_SubTotalQ_1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_SubTotalQ_1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_SubTotalQ_1.setText("Q. ");

        lblsubtotalbebidas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblsubtotalbebidas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblsubtotalbebidas.setText("0.0");

        jtBebidas_.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtBebidas_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtBebidas_MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jtBebidas_);

        txtBuscarBebida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarBebidaKeyReleased(evt);
            }
        });

        jButton_AddPedido_1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_AddPedido_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/core/resources/icons/clocheX32.png"))); // NOI18N
        jButton_AddPedido_1.setMaximumSize(new java.awt.Dimension(292, 93));
        jButton_AddPedido_1.setMinimumSize(new java.awt.Dimension(292, 93));
        jButton_AddPedido_1.setPreferredSize(new java.awt.Dimension(292, 93));
        jButton_AddPedido_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddPedido_1ActionPerformed(evt);
            }
        });

        txtCant2.setText("0");
        txtCant2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCant2ActionPerformed(evt);
            }
        });
        txtCant2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCant2KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel_Bebidas_Layout = new javax.swing.GroupLayout(jPanel_Bebidas_);
        jPanel_Bebidas_.setLayout(jPanel_Bebidas_Layout);
        jPanel_Bebidas_Layout.setHorizontalGroup(
            jPanel_Bebidas_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Bebidas_Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_Bebidas_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_Bebidas_Layout.createSequentialGroup()
                        .addComponent(jLabel_ComboCantidad_1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCant2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_AddPedido_1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                    .addComponent(txtBuscarBebida)
                    .addGroup(jPanel_Bebidas_Layout.createSequentialGroup()
                        .addGroup(jPanel_Bebidas_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_ComboPrecioUnitario_1)
                            .addComponent(jLabel_ComboSubTotal_1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel_Bebidas_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_Bebidas_Layout.createSequentialGroup()
                                .addComponent(jLabel_SubTotalQ_1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(133, 133, 133)
                                .addComponent(lblsubtotalbebidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel_Bebidas_Layout.createSequentialGroup()
                                .addComponent(jLabel_PrecioUnitarioQ_1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel_PrecioUnitarioNum_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel_Bebidas_Layout.setVerticalGroup(
            jPanel_Bebidas_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_Bebidas_Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscarBebida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_Bebidas_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_PrecioUnitarioNum_1)
                    .addComponent(jLabel_PrecioUnitarioQ_1)
                    .addComponent(jLabel_ComboPrecioUnitario_1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_Bebidas_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ComboSubTotal_1)
                    .addComponent(jLabel_SubTotalQ_1)
                    .addComponent(lblsubtotalbebidas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_Bebidas_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_Bebidas_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCant2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel_ComboCantidad_1))
                    .addComponent(jButton_AddPedido_1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jScrollPane.setBorder(null);
        jScrollPane.setHorizontalScrollBar(null);

        jPanel_Pedidos_.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pedidos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel_Pedidos_.setPreferredSize(new java.awt.Dimension(768, 250));

        jtPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(jtPedido);

        javax.swing.GroupLayout jPanel_Pedidos_Layout = new javax.swing.GroupLayout(jPanel_Pedidos_);
        jPanel_Pedidos_.setLayout(jPanel_Pedidos_Layout);
        jPanel_Pedidos_Layout.setHorizontalGroup(
            jPanel_Pedidos_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Pedidos_Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel_Pedidos_Layout.setVerticalGroup(
            jPanel_Pedidos_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Pedidos_Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jScrollPane.setViewportView(jPanel_Pedidos_);

        jButton_Aceptar_.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_Aceptar_.setText("Aceptar");
        jButton_Aceptar_.setMaximumSize(new java.awt.Dimension(120, 52));
        jButton_Aceptar_.setMinimumSize(new java.awt.Dimension(120, 52));
        jButton_Aceptar_.setPreferredSize(new java.awt.Dimension(120, 52));
        jButton_Aceptar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Aceptar_ActionPerformed(evt);
            }
        });

        jButton_Cancelar_.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_Cancelar_.setText("Cancelar");
        jButton_Cancelar_.setMaximumSize(new java.awt.Dimension(120, 52));
        jButton_Cancelar_.setMinimumSize(new java.awt.Dimension(120, 52));
        jButton_Cancelar_.setPreferredSize(new java.awt.Dimension(120, 52));
        jButton_Cancelar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Cancelar_ActionPerformed(evt);
            }
        });

        jLabel_Nota_.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_Nota_.setText("Mesero Encargado: ");
        jLabel_Nota_.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_Nota_.setMinimumSize(new java.awt.Dimension(85, 49));
        jLabel_Nota_.setPreferredSize(new java.awt.Dimension(85, 49));

        jLabel_Factura_.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_Factura_.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_Factura_.setText("#");

        jLabel_FactureNumero_.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_FactureNumero_.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_FactureNumero_.setText("1234567890");

        javax.swing.GroupLayout jPanel_Main_Layout = new javax.swing.GroupLayout(jPanel_Main_);
        jPanel_Main_.setLayout(jPanel_Main_Layout);
        jPanel_Main_Layout.setHorizontalGroup(
            jPanel_Main_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Main_Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel_Main_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel_Main_Layout.createSequentialGroup()
                        .addComponent(jLabel_Nota_, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox_Empleado_, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131)
                        .addComponent(jLabel_Factura_)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_FactureNumero_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Cancelar_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Aceptar_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_Main_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 977, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_Main_Layout.createSequentialGroup()
                            .addComponent(jPanel_Alimentos_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel_Bebidas_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_Main_Layout.setVerticalGroup(
            jPanel_Main_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Main_Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_Main_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel_Alimentos_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_Bebidas_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel_Main_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_Main_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_Aceptar_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_Cancelar_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel_Main_Layout.createSequentialGroup()
                        .addGroup(jPanel_Main_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_Factura_, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_FactureNumero_, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addComponent(jComboBox_Empleado_)
                    .addComponent(jLabel_Nota_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_Main_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_Main_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_Aceptar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Aceptar_ActionPerformed
        Conexion cone = new Conexion();
        com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) cone.connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer ID = null;
        try {

            ps = conn.prepareStatement("INSERT INTO `cafebar`.`temp_venta` (`estado`) VALUES (?)");
            ps.setString(1, "Activa");
            ps.execute();

            ps = conn.prepareStatement("SELECT id FROM `cafebar`.`temp_venta` ORDER BY id LIMIT 1 ");
            rs = ps.executeQuery();

            while (rs.next()) {
                ID = (rs.getInt("id"));
            }
        } catch (SQLException ex) {
        }

        try {
            int filas = jtPedido.getRowCount();
            for (int row = 0; row < filas; row++) {

                int id_comida = (int) jtPedido.getValueAt(row, 0);
                String cantidad = (String) jtPedido.getValueAt(row, 2);
                String costo = (String) jtPedido.getValueAt(row, 3);

                ps = conn.prepareStatement("INSERT INTO `cafebar`.`temp_pedido` (`temp_venta_id`, `empleado_id`, `bebida_id`, `bebida_cantidad`, `costo`) VALUES (?,?,?,?,?)");
                
                ps.setInt(1, ID);
                ps.setInt(2, jComboBox_Empleado_.getSelectedIndex() + 1);
                ps.setInt(3, id_comida);
                ps.setString(4, cantidad);
                ps.setString(5, costo);
                
                ps.execute();
             
            }
            JOptionPane.showMessageDialog(null, "Ingresado Correctamente");
                tabla();
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }

    }//GEN-LAST:event_jButton_Aceptar_ActionPerformed

    private void jButton_Cancelar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Cancelar_ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton_Cancelar_ActionPerformed

    private void jButton_AddPedido_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddPedido_ActionPerformed
        String subtotal = lblSubtotalComida.getText().replaceAll(",", "");
        DefaultTableModel modelo = (DefaultTableModel) jtPedido.getModel();
        Object[] fila = new Object[4];
        fila[0] = CODIGOCOMIDA;
        fila[1] = COMIDA;
        fila[2] = txtCant1.getText();
        fila[3] = subtotal;
        modelo.addRow(fila);
        txtCant1.setText("");
        txtbuscarComida.requestFocus();
        txtbuscarComida.setText("");

    }//GEN-LAST:event_jButton_AddPedido_ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        Menus menusLista = new Menus();
//        ArrayList<Menus> menus = menusLista.getMenus();
//        
//        Object listaData []= new Object[menus.size()];
//        
//        
//        for (int i = 0 ; i < menus.size() ; i++) {
//            listaData[i]=menus.get(i).getNombre();
//        }
//        jList_Combo_.setListData((String[]) listaData);
//        
    }//GEN-LAST:event_formWindowOpened

    private void txtbuscarComidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarComidaKeyReleased
        getBuscarComida();
    }//GEN-LAST:event_txtbuscarComidaKeyReleased

    private void txtBuscarBebidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarBebidaKeyReleased
        getBuscarBebida();
    }//GEN-LAST:event_txtBuscarBebidaKeyReleased

    private void jtComida_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtComida_MouseClicked

        int Fila = jtComida_.getSelectedRow();
        String codigo = jtComida_.getValueAt(Fila, 0).toString();
        String nombre = jtComida_.getValueAt(Fila, 1).toString();
        String precio = jtComida_.getValueAt(Fila, 2).toString();

        precio_comida = Double.parseDouble(precio);
        CODIGOCOMIDA = Integer.parseInt(codigo);
        COMIDA = nombre;
        lblUnitarioComida.setText(precio);
        lblSubtotalComida.setText(precio);
        txtCant1.setText("1");
//
//        System.out.println("id " + ID_ARTICULO);
//        System.out.println("Nombre: " + NOMBRE_ARTICULO);
//        System.out.println("CA: " + CANTIDAD);


    }//GEN-LAST:event_jtComida_MouseClicked

    private void jButton_AddPedido_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddPedido_1ActionPerformed
        String subtotal = lblsubtotalbebidas.getText().replaceAll(",", "");
        DefaultTableModel modelo = (DefaultTableModel) jtPedido.getModel();
        Object[] fila = new Object[4];
        fila[0] = CODIGOBEBIDA;
        fila[1] = BEBIDA;
        fila[2] = txtCant2.getText();
        fila[3] = subtotal;
        modelo.addRow(fila);
        txtCant2.setText("");
        txtBuscarBebida.requestFocus();


    }//GEN-LAST:event_jButton_AddPedido_1ActionPerformed

    private void txtCant1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCant1KeyReleased
        double total;
        int cantidad;

        int cant = Integer.parseInt(txtCant1.getText());

        total = precio_comida * cant;
        DecimalFormat df = new DecimalFormat("###,###,##0.00");
        df.getDecimalFormatSymbols().setDecimalSeparator('.');
        df.getDecimalFormatSymbols().setGroupingSeparator(',');
        lblSubtotalComida.setText(df.format(Double.valueOf(total)));

    }//GEN-LAST:event_txtCant1KeyReleased

    private void jtBebidas_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtBebidas_MouseClicked

        int Fila = jtBebidas_.getSelectedRow();
        String codigo = jtBebidas_.getValueAt(Fila, 0).toString();
        String nombre = jtBebidas_.getValueAt(Fila, 1).toString();
        String precio = jtBebidas_.getValueAt(Fila, 2).toString();

        precio_bebida = Double.parseDouble(precio);
        CODIGOBEBIDA = Integer.parseInt(codigo);
        BEBIDA = nombre;
        jLabel_PrecioUnitarioNum_1.setText(precio);
        lblsubtotalbebidas.setText(precio);
        txtCant2.setText("1");
    }//GEN-LAST:event_jtBebidas_MouseClicked

    private void txtCant2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCant2KeyReleased
        double total;
        int cantidad;

        int cant = Integer.parseInt(txtCant2.getText());

        total = precio_bebida * cant;
        DecimalFormat df = new DecimalFormat("###,###.##");
        lblsubtotalbebidas.setText(df.format(Double.valueOf(total)));

    }//GEN-LAST:event_txtCant2KeyReleased

    private void txtCant2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCant2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCant2ActionPerformed

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
            UIManager.setLookAndFeel("com.alee.laf.WebLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoCliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new NuevoCliente().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Aceptar_;
    private javax.swing.JButton jButton_AddPedido_;
    private javax.swing.JButton jButton_AddPedido_1;
    private javax.swing.JButton jButton_Cancelar_;
    private javax.swing.JComboBox<String> jComboBox_Empleado_;
    private javax.swing.JLabel jLabel_ComboCantidad_1;
    private javax.swing.JLabel jLabel_ComboCantidad_2;
    private javax.swing.JLabel jLabel_ComboPrecioUnitario_1;
    private javax.swing.JLabel jLabel_ComboPrecioUnitario_2;
    private javax.swing.JLabel jLabel_ComboSubTotal_1;
    private javax.swing.JLabel jLabel_ComboSubTotal_2;
    private javax.swing.JLabel jLabel_Factura_;
    private javax.swing.JLabel jLabel_FactureNumero_;
    private javax.swing.JLabel jLabel_Nota_;
    private javax.swing.JLabel jLabel_PrecioUnitarioNum_1;
    private javax.swing.JLabel jLabel_PrecioUnitarioQ_1;
    private javax.swing.JLabel jLabel_PrecioUnitarioQ_2;
    private javax.swing.JLabel jLabel_SubTotalQ_1;
    private javax.swing.JLabel jLabel_SubTotalQ_2;
    private javax.swing.JPanel jPanel_Alimentos_;
    private javax.swing.JPanel jPanel_Bebidas_;
    private javax.swing.JPanel jPanel_Main_;
    private javax.swing.JPanel jPanel_Pedidos_;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jtBebidas_;
    private javax.swing.JTable jtComida_;
    private javax.swing.JTable jtPedido;
    private javax.swing.JLabel lblSubtotalComida;
    private javax.swing.JLabel lblUnitarioComida;
    private javax.swing.JLabel lblsubtotalbebidas;
    private javax.swing.JTextField txtBuscarBebida;
    private javax.swing.JTextField txtCant1;
    private javax.swing.JTextField txtCant2;
    private javax.swing.JTextField txtbuscarComida;
    // End of variables declaration//GEN-END:variables
}
