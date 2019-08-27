/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.login;

import core.utils.themplate.Detalle;
import core.utils.login.Hash;
import javax.swing.JOptionPane;
import core.utils.login.SqlUsuarios;
import core.utils.login.Usuarios;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.UIManager;
import com.placeholder.PlaceHolder;
import java.awt.event.WindowEvent;

/**
 *
 * @author Marko
 */
public class OnDemandLogin extends javax.swing.JFrame {
    private String tipo = null;
    private Integer FACTURAID= null;
    private String lvl = null;
    private Integer LVL = null;
    private boolean logged = false;
    
    private void limpiar() {
        txtUsuario.setText("");
        txtPassword.setText(""); 
    }
           
    private void ingresar(){
        SqlUsuarios modSql = new SqlUsuarios();
        Usuarios mod = new Usuarios();
        Integer id=null;

        String pass = new String(txtPassword.getPassword());

        if (!txtUsuario.getText().equals("") && !pass.equals("")) {

            String nuevoPass = Hash.sha1(pass);

            mod.setUsuario(txtUsuario.getText());
            mod.setPassword(nuevoPass);
            
            id=mod.getIdTipo();
            
            if (modSql.login(mod)) {
                
                this.dispose();
                
                switch (id) {
                    case 1:
                        {
                            logged=true;
                            lvl="ROOT";
                            LVL=1;
                            break;
                        }
                    case 2:
                        {
                            lvl="Administrador";
                            logged=true;
                            LVL=2;
                            break;
                        }
                    case 3:
                        {
                            logged=true;
                            lvl="Contador";
                            LVL=3;
                            break;
                        }
                    case 4:
                        {
                            logged=true;
                            lvl="Encargado";
                            LVL=4;
                            break;
                        }
                    case 5:
                        {
                            logged=true;
                            lvl="Cajero";
                            LVL=5;
                            break;
                        }
                    case 6:
                        {
                            logged=true;
                            lvl="Mesero";
                            LVL=6;
                            break;
                        }
                    default:
                        System.err.println("Error");
                        limpiar();
                        txtUsuario.requestFocus();
                        break;
                }

            } else {
                JOptionPane.showMessageDialog(null, "Datos incorrectos");
                limpiar();
                txtUsuario.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar sus datos");
            limpiar();
            txtUsuario.requestFocus();
        }
    }
    
    private void onExit(){
        WindowEvent winClosingEvent = new WindowEvent(null,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    
    private void opacityIn(){
        setOpacity(1f);
    }
    private void opacityOut(){
        setOpacity(0.75f);
    }
    private void settings(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(gui.MainMenu.getIconDir())));
        setBackground(new Color (200,0,0,200));
        jPanel_Main_.setBackground(new Color (0,0,0,0));
    }
    
    public void setDefault(){
        lvl=null;
        LVL=null;
        logged=false;
    }

    public String getLvL() {
        return lvl;
    }
    
    public Integer getLVL() {
        return LVL;
    }

    public boolean isLogged() {
        return logged;
    }
   
    private void runTipo(){
        if ("AnularFactura".equals(tipo)) {
            adminAnularFactura();
        }
    }
    
    public OnDemandLogin() {
        initComponents();
        settings();
    }
    
    public OnDemandLogin(String tipo) {
        this.tipo = tipo;
        initComponents();
        settings();
    }
    
    public OnDemandLogin(String tipo, Integer FACTURAID) {
        initComponents();
        settings();
        if ("AnularFactura".equals(tipo)) {
            this.tipo = tipo;
            this.FACTURAID = FACTURAID;
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

        jLabel_User_ = new javax.swing.JLabel();
        jLabel_Password_ = new javax.swing.JLabel();
        jPanel_Logo_ = new javax.swing.JPanel();
        jLabel_LogoUser_ = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();
        jPanel_Main_ = new javax.swing.JPanel();
        jPanel_Login_ = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnAceptar_ = new javax.swing.JButton();
        btnCancelar_ = new javax.swing.JButton();

        jLabel_User_.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel_User_.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_User_.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_User_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/core/resources/icons/login/userWX32.png"))); // NOI18N
        jLabel_User_.setToolTipText("");
        jLabel_User_.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_User_.setMaximumSize(null);
        jLabel_User_.setMinimumSize(new java.awt.Dimension(42, 48));
        jLabel_User_.setPreferredSize(new java.awt.Dimension(42, 48));

        jLabel_Password_.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel_Password_.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Password_.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Password_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/core/resources/icons/login/passwordWX32.png"))); // NOI18N
        jLabel_Password_.setMaximumSize(null);
        jLabel_Password_.setMinimumSize(new java.awt.Dimension(42, 48));
        jLabel_Password_.setPreferredSize(new java.awt.Dimension(42, 48));

        jPanel_Logo_.setMinimumSize(new java.awt.Dimension(360, 320));
        jPanel_Logo_.setOpaque(false);
        jPanel_Logo_.setPreferredSize(new java.awt.Dimension(360, 320));
        jPanel_Logo_.setLayout(new java.awt.BorderLayout());

        jLabel_LogoUser_.setBackground(java.awt.Color.darkGray);
        jLabel_LogoUser_.setForeground(java.awt.Color.white);
        jLabel_LogoUser_.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_LogoUser_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/core/resources/icons/userGx300.png"))); // NOI18N
        jLabel_LogoUser_.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_LogoUser_.setMaximumSize(null);
        jLabel_LogoUser_.setMinimumSize(new java.awt.Dimension(300, 310));
        jLabel_LogoUser_.setPreferredSize(new java.awt.Dimension(300, 310));
        jPanel_Logo_.add(jLabel_LogoUser_, java.awt.BorderLayout.CENTER);

        Background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/core/resources/Login.png"))); // NOI18N
        Background.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Background.setMaximumSize(null);
        Background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackgroundMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BackgroundMouseExited(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(null);
        setMinimumSize(new java.awt.Dimension(360, 196));
        setName("frameLogin"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(360, 196));
        setResizable(false);
        setSize(new java.awt.Dimension(360, 196));
        setType(java.awt.Window.Type.POPUP);

        jPanel_Main_.setMinimumSize(new java.awt.Dimension(360, 196));
        jPanel_Main_.setOpaque(false);
        jPanel_Main_.setPreferredSize(new java.awt.Dimension(360, 196));
        jPanel_Main_.setLayout(new java.awt.BorderLayout());

        jPanel_Login_.setBackground(java.awt.Color.darkGray);
        jPanel_Login_.setMinimumSize(new java.awt.Dimension(360, 196));
        jPanel_Login_.setOpaque(false);
        jPanel_Login_.setPreferredSize(new java.awt.Dimension(360, 196));
        jPanel_Login_.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsuario.setBackground(new java.awt.Color(51, 51, 51, 127));
        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtUsuario.setForeground(java.awt.Color.white);
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setToolTipText("Usuario");
        txtUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtUsuario.setCaretColor(new java.awt.Color(255, 255, 255));
        txtUsuario.setDisabledTextColor(java.awt.Color.lightGray);
        txtUsuario.setMaximumSize(null);
        txtUsuario.setMinimumSize(new java.awt.Dimension(256, 48));
        txtUsuario.setNextFocusableComponent(txtPassword);
        txtUsuario.setPreferredSize(new java.awt.Dimension(256, 48));
        txtUsuario.setSelectionColor(new java.awt.Color(153, 0, 0));
        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusGained(evt);
            }
        });
        txtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtUsuarioMouseEntered(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyReleased(evt);
            }
        });
        jPanel_Login_.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 340, -1));

        txtPassword.setBackground(new java.awt.Color(51, 51, 51, 127));
        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtPassword.setForeground(java.awt.Color.white);
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword.setToolTipText("Contraseña");
        txtPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPassword.setCaretColor(new java.awt.Color(255, 255, 255));
        txtPassword.setDisabledTextColor(java.awt.Color.lightGray);
        txtPassword.setMaximumSize(null);
        txtPassword.setMinimumSize(new java.awt.Dimension(256, 48));
        txtPassword.setNextFocusableComponent(btnAceptar_);
        txtPassword.setPreferredSize(new java.awt.Dimension(256, 48));
        txtPassword.setSelectionColor(new java.awt.Color(153, 0, 0));
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
        });
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtPasswordMouseEntered(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });
        jPanel_Login_.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 340, -1));

        btnAceptar_.setBackground(new java.awt.Color(153, 0, 51));
        btnAceptar_.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnAceptar_.setText("Aceptar");
        btnAceptar_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar_.setMinimumSize(new java.awt.Dimension(150, 64));
        btnAceptar_.setNextFocusableComponent(btnCancelar_);
        btnAceptar_.setPreferredSize(new java.awt.Dimension(150, 48));
        btnAceptar_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAceptar_MouseEntered(evt);
            }
        });
        btnAceptar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptar_ActionPerformed(evt);
            }
        });
        jPanel_Login_.add(btnAceptar_, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, -1, -1));

        btnCancelar_.setBackground(new java.awt.Color(153, 0, 51));
        btnCancelar_.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnCancelar_.setText("Cancelar");
        btnCancelar_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar_.setMinimumSize(new java.awt.Dimension(150, 64));
        btnCancelar_.setPreferredSize(new java.awt.Dimension(150, 48));
        btnCancelar_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelar_MouseEntered(evt);
            }
        });
        btnCancelar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar_ActionPerformed(evt);
            }
        });
        jPanel_Login_.add(btnCancelar_, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jPanel_Main_.add(jPanel_Login_, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel_Main_, java.awt.BorderLayout.CENTER);

        getAccessibleContext().setAccessibleDescription("Sam's Login");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar_ActionPerformed
        ingresar();
        runTipo();
        setDefault();
    }//GEN-LAST:event_btnAceptar_ActionPerformed

    private void btnCancelar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar_ActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelar_ActionPerformed

    private void BackgroundMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackgroundMouseEntered
        opacityIn();
    }//GEN-LAST:event_BackgroundMouseEntered

    private void BackgroundMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackgroundMouseExited
        opacityOut();
    }//GEN-LAST:event_BackgroundMouseExited

    private void txtUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMouseEntered
        opacityIn();
    }//GEN-LAST:event_txtUsuarioMouseEntered

    private void txtPasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMouseEntered
        opacityIn();
    }//GEN-LAST:event_txtPasswordMouseEntered

    private void txtUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusGained
        opacityIn();
    }//GEN-LAST:event_txtUsuarioFocusGained

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        opacityIn();
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        opacityIn();
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyTyped
        opacityIn();
    }//GEN-LAST:event_txtPasswordKeyTyped

    private void btnAceptar_MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptar_MouseEntered
        opacityIn();
    }//GEN-LAST:event_btnAceptar_MouseEntered

    private void btnCancelar_MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelar_MouseEntered
        opacityIn();
    }//GEN-LAST:event_btnCancelar_MouseEntered

    private void txtUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyReleased
        int key = evt.getKeyCode();
        if ( java.awt.event.KeyEvent.VK_ENTER == key){
            txtPassword.requestFocus();
        }
    }//GEN-LAST:event_txtUsuarioKeyReleased

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        int key = evt.getKeyCode();
        if ( java.awt.event.KeyEvent.VK_ENTER == key){
            btnAceptar_.requestFocus();
        }
    }//GEN-LAST:event_txtPasswordKeyReleased

    private boolean checkAdmin(){
        if (    
            logged == true 
            && ( LVL== 1 || LVL== 2 || LVL== 4 ) 
            && ( "ROOT".equals(lvl) || "Administrador".equals(lvl) || "Encargado".equals(lvl) ) 
        ) {
            return true;
        } else if ( logged == false && LVL==null && lvl==null ) {
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Sin permisos para ésta acción!");
            return false;
        }
    }
    
    private void adminAnularFactura(){
        Detalle detalle = new Detalle();
        if (checkAdmin()) {
            detalle.anularFactura(FACTURAID);
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.setLookAndFeel("com.alee.laf.WebLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OnDemandLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new OnDemandLogin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    public javax.swing.JButton btnAceptar_;
    public javax.swing.JButton btnCancelar_;
    private javax.swing.JLabel jLabel_LogoUser_;
    private javax.swing.JLabel jLabel_Password_;
    private javax.swing.JLabel jLabel_User_;
    private javax.swing.JPanel jPanel_Login_;
    private javax.swing.JPanel jPanel_Logo_;
    private javax.swing.JPanel jPanel_Main_;
    public javax.swing.JPasswordField txtPassword;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
