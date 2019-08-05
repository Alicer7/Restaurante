/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.venta.VentasP;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Freddy Camposeco <freddy.camposeco@elementum69.com>
 * <www.elementum69.com>
 */

public class MainMenu extends javax.swing.JFrame {
    
    private static final String ICONDIR = "/core/resources/icono.png";
    private String USUARIO = "";
    private String NIVLE = "";
    private final String SAMS = " Sam's @ ";
    private VentasP ventas; 
    
    private Boolean switchMenuBar = false;
    private Boolean switchMenu = false;   
    
    private void exit() {
        
        String botones[] = {"Cerrar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(this, "¿Desea cerrar la aplicación?", "", 0, 0, null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else if (eleccion == JOptionPane.NO_OPTION) {
        }
        
    }
    
    private void datosSesion (){
        Timer tiempo = new Timer(100, new gui.MainMenu.hora());
        tiempo.start();
        System.err.println(SAMS+USUARIO.replaceAll("\\s+","")+" | "+NIVLE);
        setTitle(SAMS+USUARIO.replaceAll("\\s+","")+" | "+NIVLE);
    }
    
    private void colorNavDef(){
        jLabel_MenuVentas_.setBackground(java.awt.Color.darkGray);
        jLabel_MenuVentas_.setForeground(java.awt.Color.white);
        jLabel_MenuVentasDelDia_.setBackground(java.awt.Color.darkGray);
        jLabel_MenuVentasDelDia_.setForeground(java.awt.Color.white);
        
    }
    
    private void clicPresNav (String nameComponent){
        if (null == nameComponent){
        } else switch (nameComponent) {
            case "Ventas":
                colorNavDef();
                jLabel_MenuVentas_.setBackground(java.awt.Color.white);
                jLabel_MenuVentas_.setForeground(java.awt.Color.black);
                break;
            case "VentasDelDia":
                colorNavDef();
                jLabel_MenuVentasDelDia_.setBackground(java.awt.Color.white);
                jLabel_MenuVentasDelDia_.setForeground(java.awt.Color.black);
                break;
            default:
                break;
        }
    }
      
    private void hoverNav (String nameComponent){
        if (null == nameComponent){
        } else switch (nameComponent) {
            case "Ventas":
                colorNavDef();
                jLabel_MenuVentas_.setBackground(java.awt.Color.red);
                jLabel_MenuVentas_.setForeground(java.awt.Color.white);
                break;
            case "VentasDelDia":
                colorNavDef();
                jLabel_MenuVentasDelDia_.setBackground(java.awt.Color.red);
                jLabel_MenuVentasDelDia_.setForeground(java.awt.Color.white);
                break;
            default:
                break;
        }
    }
    
    private void ocultarMenuBar (){
        if (switchMenuBar == false){
            jMenuBar_.setPreferredSize(new Dimension(jMenuBar_.getSize().width, 0));
            switchMenuBar = true;
            jMenuItem_ShowMenuBar_.setText("Mostrar Barra de Herramientas");
        } else if (switchMenuBar == true){
            jMenuBar_.setPreferredSize(new Dimension(jMenuBar_.getSize().width, 21));
            switchMenuBar = false;
            jMenuItem_ShowMenuBar_.setText("Ocultar Barra de Herramientas");
        } else {
            System.err.println("Error al ocultar Barra de Menú");
        }
    }
    
    private void ocultarNavBar (){
        if (switchMenu == true){
            remove(jPanel_MenuBarSmall_);
            add(jPanel_MenuBar_, java.awt.BorderLayout.WEST);
            repaint();
            jMenuItem_ShowNavBar_.setText("Iconificar Barra de Navegación");
            switchMenu = false;
        }
        else if (switchMenu == false) {
            remove(jPanel_MenuBar_);
            add(jPanel_MenuBarSmall_, java.awt.BorderLayout.WEST);
            repaint();
            jMenuItem_ShowNavBar_.setText("Mostrar Barra de Navegación");
            switchMenu = true;
        }
        else {
            System.err.println("Error al mostrar el menu");
        }
    }
    
    private void addPenel_Ventas (){
        ventas = new VentasP();
        jPanel_MainContent_.add(ventas, java.awt.BorderLayout.CENTER);
    }
    
    private void settings (){   
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(ICONDIR)));
        try { 
            UIManager.setLookAndFeel("com.alee.laf.WebLookAndFeel"); 
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ignored){}
    }
    
    public static String getIconDir() {
        return ICONDIR;
    }

    public void setUSUARIO(String USUARIO) {
        this.USUARIO = USUARIO;
        System.err.println("Set User: "+USUARIO+" > "+this.USUARIO);
    }

    public void setNIVLE(String NIVLE) {
        this.NIVLE = NIVLE;
        System.err.println("Set LvL: "+NIVLE+" > "+this.NIVLE);
    }
    
    public MainMenu() {
        settings ();
        initComponents();
        addPenel_Ventas ();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_MenuBarSmall_ = new javax.swing.JPanel();
        jPanel_StatusBar_ = new javax.swing.JPanel();
        jLabel_HORA_ = new javax.swing.JLabel();
        jLabel_ResizeIcono_ = new javax.swing.JLabel();
        jPanel_MenuBar_ = new javax.swing.JPanel();
        jPanel_NormalNav_ = new javax.swing.JPanel();
        jLabel_MenuVentas_ = new javax.swing.JLabel();
        jLabel_MenuVentasDelDia_ = new javax.swing.JLabel();
        jPanel_MainContent_ = new javax.swing.JPanel();
        jMenuBar_ = new javax.swing.JMenuBar();
        jMenu_Archivos_ = new javax.swing.JMenu();
        jMenuItem_CerrarSesion_ = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem_Salir_ = new javax.swing.JMenuItem();
        jMenu_Ver_ = new javax.swing.JMenu();
        jMenuItem_ShowMenuBar_ = new javax.swing.JMenuItem();
        jMenuItem_ShowNavBar_ = new javax.swing.JMenuItem();
        jMenu_Help_ = new javax.swing.JMenu();
        jMenuItem_Help_ = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        jPanel_MenuBarSmall_.setBackground(java.awt.Color.darkGray);
        jPanel_MenuBarSmall_.setForeground(java.awt.Color.white);
        jPanel_MenuBarSmall_.setMaximumSize(null);
        jPanel_MenuBarSmall_.setMinimumSize(new java.awt.Dimension(32, 640));
        jPanel_MenuBarSmall_.setName("MenuBar"); // NOI18N
        jPanel_MenuBarSmall_.setPreferredSize(new java.awt.Dimension(32, 640));

        javax.swing.GroupLayout jPanel_MenuBarSmall_Layout = new javax.swing.GroupLayout(jPanel_MenuBarSmall_);
        jPanel_MenuBarSmall_.setLayout(jPanel_MenuBarSmall_Layout);
        jPanel_MenuBarSmall_Layout.setHorizontalGroup(
            jPanel_MenuBarSmall_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );
        jPanel_MenuBarSmall_Layout.setVerticalGroup(
            jPanel_MenuBarSmall_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 661));
        setName("mainJF"); // NOI18N
        setSize(new java.awt.Dimension(1024, 661));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel_StatusBar_.setBackground(java.awt.Color.darkGray);
        jPanel_StatusBar_.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel_StatusBar_.setForeground(java.awt.Color.white);
        jPanel_StatusBar_.setMaximumSize(null);
        jPanel_StatusBar_.setMinimumSize(new java.awt.Dimension(1024, 21));
        jPanel_StatusBar_.setPreferredSize(new java.awt.Dimension(1024, 21));

        jLabel_HORA_.setBackground(java.awt.Color.darkGray);
        jLabel_HORA_.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_HORA_.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_HORA_.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_HORA_.setText("| 2019-01-01 | dom | 00:00:00 AM |");
        jLabel_HORA_.setMaximumSize(null);
        jLabel_HORA_.setMinimumSize(new java.awt.Dimension(210, 16));
        jLabel_HORA_.setPreferredSize(new java.awt.Dimension(210, 16));

        jLabel_ResizeIcono_.setBackground(java.awt.Color.darkGray);
        jLabel_ResizeIcono_.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ResizeIcono_.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_ResizeIcono_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/core/resources/icons/ResizeCornerW0X16.gif"))); // NOI18N
        jLabel_ResizeIcono_.setMaximumSize(null);

        javax.swing.GroupLayout jPanel_StatusBar_Layout = new javax.swing.GroupLayout(jPanel_StatusBar_);
        jPanel_StatusBar_.setLayout(jPanel_StatusBar_Layout);
        jPanel_StatusBar_Layout.setHorizontalGroup(
            jPanel_StatusBar_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_StatusBar_Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_HORA_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_ResizeIcono_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel_StatusBar_Layout.setVerticalGroup(
            jPanel_StatusBar_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_StatusBar_Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel_StatusBar_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_HORA_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_ResizeIcono_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel_StatusBar_, java.awt.BorderLayout.SOUTH);

        jPanel_MenuBar_.setBackground(java.awt.Color.darkGray);
        jPanel_MenuBar_.setForeground(java.awt.Color.white);
        jPanel_MenuBar_.setMinimumSize(new java.awt.Dimension(200, 640));
        jPanel_MenuBar_.setName("MenuBar"); // NOI18N
        jPanel_MenuBar_.setPreferredSize(new java.awt.Dimension(200, 640));
        jPanel_MenuBar_.setLayout(new java.awt.BorderLayout());

        jPanel_NormalNav_.setBackground(java.awt.Color.darkGray);
        jPanel_NormalNav_.setForeground(java.awt.Color.lightGray);
        jPanel_NormalNav_.setOpaque(false);
        jPanel_NormalNav_.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel_NormalNav_MouseMoved(evt);
            }
        });

        jLabel_MenuVentas_.setBackground(java.awt.Color.darkGray);
        jLabel_MenuVentas_.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_MenuVentas_.setForeground(java.awt.Color.white);
        jLabel_MenuVentas_.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_MenuVentas_.setText("Ventas");
        jLabel_MenuVentas_.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel_MenuVentas_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_MenuVentas_.setMinimumSize(new java.awt.Dimension(180, 21));
        jLabel_MenuVentas_.setOpaque(true);
        jLabel_MenuVentas_.setPreferredSize(new java.awt.Dimension(180, 21));
        jLabel_MenuVentas_.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel_MenuVentas_MouseMoved(evt);
            }
        });
        jLabel_MenuVentas_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_MenuVentas_MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel_MenuVentas_MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel_MenuVentas_MouseReleased(evt);
            }
        });

        jLabel_MenuVentasDelDia_.setBackground(java.awt.Color.darkGray);
        jLabel_MenuVentasDelDia_.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_MenuVentasDelDia_.setForeground(java.awt.Color.white);
        jLabel_MenuVentasDelDia_.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_MenuVentasDelDia_.setText("Ver Ventas Del Día");
        jLabel_MenuVentasDelDia_.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel_MenuVentasDelDia_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_MenuVentasDelDia_.setMinimumSize(new java.awt.Dimension(180, 21));
        jLabel_MenuVentasDelDia_.setOpaque(true);
        jLabel_MenuVentasDelDia_.setPreferredSize(new java.awt.Dimension(180, 21));
        jLabel_MenuVentasDelDia_.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel_MenuVentasDelDia_MouseMoved(evt);
            }
        });
        jLabel_MenuVentasDelDia_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_MenuVentasDelDia_MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel_MenuVentasDelDia_MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel_MenuVentasDelDia_MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel_NormalNav_Layout = new javax.swing.GroupLayout(jPanel_NormalNav_);
        jPanel_NormalNav_.setLayout(jPanel_NormalNav_Layout);
        jPanel_NormalNav_Layout.setHorizontalGroup(
            jPanel_NormalNav_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_NormalNav_Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_NormalNav_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_MenuVentasDelDia_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_MenuVentas_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel_NormalNav_Layout.setVerticalGroup(
            jPanel_NormalNav_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_NormalNav_Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_MenuVentas_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_MenuVentasDelDia_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_MenuBar_.add(jPanel_NormalNav_, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel_MenuBar_, java.awt.BorderLayout.WEST);

        jPanel_MainContent_.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel_MainContent_, java.awt.BorderLayout.CENTER);

        jMenuBar_.setBackground(java.awt.Color.darkGray);
        jMenuBar_.setForeground(java.awt.Color.lightGray);
        jMenuBar_.setMinimumSize(new java.awt.Dimension(0, 0));
        jMenuBar_.setPreferredSize(new java.awt.Dimension(1024, 21));

        jMenu_Archivos_.setText("Archivo");

        jMenuItem_CerrarSesion_.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem_CerrarSesion_.setText("Cerrar Sesión");
        jMenuItem_CerrarSesion_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_CerrarSesion_ActionPerformed(evt);
            }
        });
        jMenu_Archivos_.add(jMenuItem_CerrarSesion_);
        jMenu_Archivos_.add(jSeparator1);

        jMenuItem_Salir_.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem_Salir_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/core/resources/icons/Exit0X24.png"))); // NOI18N
        jMenuItem_Salir_.setText("Salir");
        jMenuItem_Salir_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_Salir_ActionPerformed(evt);
            }
        });
        jMenu_Archivos_.add(jMenuItem_Salir_);

        jMenuBar_.add(jMenu_Archivos_);

        jMenu_Ver_.setText("Ver");

        jMenuItem_ShowMenuBar_.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem_ShowMenuBar_.setText("Mostrar Barra de Herramientas");
        jMenuItem_ShowMenuBar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ShowMenuBar_ActionPerformed(evt);
            }
        });
        jMenu_Ver_.add(jMenuItem_ShowMenuBar_);

        jMenuItem_ShowNavBar_.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem_ShowNavBar_.setText("Iconificar Barra de Navegación");
        jMenuItem_ShowNavBar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ShowNavBar_ActionPerformed(evt);
            }
        });
        jMenu_Ver_.add(jMenuItem_ShowNavBar_);

        jMenuBar_.add(jMenu_Ver_);

        jMenu_Help_.setText("Ayuda");

        jMenuItem_Help_.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem_Help_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/core/resources/icons/help0X24.png"))); // NOI18N
        jMenuItem_Help_.setText("Ayuda");
        jMenu_Help_.add(jMenuItem_Help_);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/core/resources/icons/heartX24.png"))); // NOI18N
        jMenuItem1.setText("Acerca de ..");
        jMenu_Help_.add(jMenuItem1);

        jMenuBar_.add(jMenu_Help_);

        setJMenuBar(jMenuBar_);

        getAccessibleContext().setAccessibleName("MainJF");
        getAccessibleContext().setAccessibleDescription("Menú Principal");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        datosSesion();
    }//GEN-LAST:event_formWindowOpened

    private void jMenuItem_Salir_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_Salir_ActionPerformed
        exit();
    }//GEN-LAST:event_jMenuItem_Salir_ActionPerformed

    private void jMenuItem_ShowMenuBar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ShowMenuBar_ActionPerformed
        ocultarMenuBar ();
    }//GEN-LAST:event_jMenuItem_ShowMenuBar_ActionPerformed

    private void jMenuItem_ShowNavBar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ShowNavBar_ActionPerformed
        ocultarNavBar ();
    }//GEN-LAST:event_jMenuItem_ShowNavBar_ActionPerformed

    private void jMenuItem_CerrarSesion_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_CerrarSesion_ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "\t\t¿Desea continuar?", "Esta a punto de cerrar la sesión", JOptionPane.YES_NO_OPTION, 0,
            new ImageIcon(getClass().getResource("/core/resources/icons/ExitX32.png"))) == JOptionPane.YES_OPTION) {
            this.dispose();
            new gui.login.Login().setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem_CerrarSesion_ActionPerformed

    private void jPanel_NormalNav_MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_NormalNav_MouseMoved
        colorNavDef();
    }//GEN-LAST:event_jPanel_NormalNav_MouseMoved

    private void jLabel_MenuVentas_MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MenuVentas_MouseMoved
        hoverNav("Ventas");
    }//GEN-LAST:event_jLabel_MenuVentas_MouseMoved

    private void jLabel_MenuVentas_MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MenuVentas_MousePressed
        clicPresNav("Ventas");
    }//GEN-LAST:event_jLabel_MenuVentas_MousePressed

    private void jLabel_MenuVentas_MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MenuVentas_MouseReleased
        hoverNav("Ventas");
    }//GEN-LAST:event_jLabel_MenuVentas_MouseReleased

    private void jLabel_MenuVentas_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MenuVentas_MouseClicked
        addPenel_Ventas ();
    }//GEN-LAST:event_jLabel_MenuVentas_MouseClicked

    private void jLabel_MenuVentasDelDia_MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MenuVentasDelDia_MouseReleased
        hoverNav("VentasDelDia");
    }//GEN-LAST:event_jLabel_MenuVentasDelDia_MouseReleased

    private void jLabel_MenuVentasDelDia_MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MenuVentasDelDia_MousePressed
        clicPresNav("VentasDelDia");
    }//GEN-LAST:event_jLabel_MenuVentasDelDia_MousePressed

    private void jLabel_MenuVentasDelDia_MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MenuVentasDelDia_MouseMoved
        hoverNav("VentasDelDia");
    }//GEN-LAST:event_jLabel_MenuVentasDelDia_MouseMoved

    private void jLabel_MenuVentasDelDia_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MenuVentasDelDia_MouseClicked
        
    }//GEN-LAST:event_jLabel_MenuVentasDelDia_MouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        exit ();
    }//GEN-LAST:event_formWindowClosing
    
    class hora implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Date date = new Date();
            DateFormat inFormat = new SimpleDateFormat( "| dd-MM-yyyy | E | hh:mm:ss aa |");
            DateFormat outFormat = new SimpleDateFormat( "| yyyy-MM-dd | E | HH:mm:ss | ");
            
            String myDate = outFormat.format(date);
            jLabel_HORA_.setText(outFormat.format(date));
//            jLabel_HORA_.setForeground(new java.awt.Color(255, 255, 255));
        }
    }
     
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> {
            new MainMenu().setVisible(true);
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel_HORA_;
    private javax.swing.JLabel jLabel_MenuVentasDelDia_;
    private javax.swing.JLabel jLabel_MenuVentas_;
    private javax.swing.JLabel jLabel_ResizeIcono_;
    private javax.swing.JMenuBar jMenuBar_;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem_CerrarSesion_;
    private javax.swing.JMenuItem jMenuItem_Help_;
    private javax.swing.JMenuItem jMenuItem_Salir_;
    private javax.swing.JMenuItem jMenuItem_ShowMenuBar_;
    private javax.swing.JMenuItem jMenuItem_ShowNavBar_;
    private javax.swing.JMenu jMenu_Archivos_;
    private javax.swing.JMenu jMenu_Help_;
    private javax.swing.JMenu jMenu_Ver_;
    private javax.swing.JPanel jPanel_MainContent_;
    private javax.swing.JPanel jPanel_MenuBarSmall_;
    private javax.swing.JPanel jPanel_MenuBar_;
    private javax.swing.JPanel jPanel_NormalNav_;
    private javax.swing.JPanel jPanel_StatusBar_;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
