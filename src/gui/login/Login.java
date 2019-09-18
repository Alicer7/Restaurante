/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.login;

import core.utils.login.Hash;
import javax.swing.JOptionPane;
import core.utils.login.SqlUsuarios;
import core.utils.login.Usuarios;
import gui.MainMenu;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.UIManager;
import com.placeholder.PlaceHolder;
import java.awt.event.WindowEvent;

/**
 *
 * @author Marko
 */
public class Login extends javax.swing.JFrame {
    
    private void limpiar() {
        txtUsuario.setText("");
        txtPassword.setText(""); 
    }
           
    private void ingresar(){
        SqlUsuarios modSql = new SqlUsuarios();
        Usuarios mod = new Usuarios();

        String pass = new String(txtPassword.getPassword());

        if (!txtUsuario.getText().equals("") && !pass.equals("")) {

            String nuevoPass = Hash.sha1(pass);

            mod.setUsuario(txtUsuario.getText());
            mod.setPassword(nuevoPass);

            if (modSql.login(mod)) {
                this.dispose();

                switch (mod.getIdTipo()) {
                    case 1:
                        {
                            gui.MainMenu mainMenu = new MainMenu();
                            mainMenu.setUSUARIO(mod.getNombre());
                            mainMenu.setNIVLE("ROOT");
                            mainMenu.setVisible(true);
                            break;
                        }
                    case 2:
                        {
                            gui.MainMenu mainMenu = new MainMenu();
                            mainMenu.setUSUARIO(mod.getNombre());
                            mainMenu.setNIVLE("Administrador");
                            mainMenu.setVisible(true);
                            break;
                        }
                    case 3:
                        {
                            gui.MainMenu mainMenu = new MainMenu();
                            mainMenu.setUSUARIO(mod.getNombre());
                            mainMenu.setNIVLE("Contador");
                            mainMenu.setVisible(true);
                            break;
                        }
                    case 4:
                        {
                            gui.MainMenu mainMenu = new MainMenu();
                            mainMenu.setUSUARIO(mod.getNombre());
                            mainMenu.setNIVLE("Encargado");
                            mainMenu.setVisible(true);
                            break;
                        }
                    case 5:
                        {
                            gui.MainMenu mainMenu = new MainMenu();
                            mainMenu.setUSUARIO(mod.getNombre());
                            mainMenu.setNIVLE("Cajero");
                            mainMenu.setVisible(true);
                            break;
                        }
                    case 6:
                        {
                            gui.MainMenu mainMenu = new MainMenu();
                            mainMenu.setUSUARIO(mod.getNombre());
                            mainMenu.setNIVLE("Mesero");
                            mainMenu.setVisible(true);
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
        setAlwaysOnTop(true);
    }
    
    private void settingsPos(){
        setBackground(new Color (0,0,0,160));
        jPanel_Main_.setBackground(new Color (0,0,0,2));
    }
   
    public Login() {
        settings();
        initComponents();
        settingsPos();
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
        jPanel_Main_ = new javax.swing.JPanel();
        jPanel_Logo_ = new javax.swing.JPanel();
        jLabel_LogoUser_ = new javax.swing.JLabel();
        jPanel_Login_ = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnEntrar_ = new javax.swing.JButton();
        btnCancelar_ = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMaximumSize(null);
        setMinimumSize(new java.awt.Dimension(360, 515));
        setName("frameLogin"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(360, 515));
        setSize(new java.awt.Dimension(360, 515));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_Main_.setMinimumSize(new java.awt.Dimension(360, 515));
        jPanel_Main_.setOpaque(false);
        jPanel_Main_.setPreferredSize(new java.awt.Dimension(360, 515));
        jPanel_Main_.setLayout(new java.awt.BorderLayout());

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

        jPanel_Main_.add(jPanel_Logo_, java.awt.BorderLayout.NORTH);

        jPanel_Login_.setBackground(java.awt.Color.darkGray);
        jPanel_Login_.setMaximumSize(null);
        jPanel_Login_.setMinimumSize(new java.awt.Dimension(360, 196));
        jPanel_Login_.setOpaque(false);
        jPanel_Login_.setPreferredSize(new java.awt.Dimension(360, 196));

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
        txtPassword.setNextFocusableComponent(btnEntrar_);
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

        btnEntrar_.setBackground(new java.awt.Color(153, 0, 51));
        btnEntrar_.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnEntrar_.setText("Entrar");
        btnEntrar_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntrar_.setMinimumSize(new java.awt.Dimension(150, 64));
        btnEntrar_.setNextFocusableComponent(btnCancelar_);
        btnEntrar_.setPreferredSize(new java.awt.Dimension(150, 64));
        btnEntrar_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEntrar_MouseEntered(evt);
            }
        });
        btnEntrar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrar_ActionPerformed(evt);
            }
        });

        btnCancelar_.setBackground(new java.awt.Color(153, 0, 51));
        btnCancelar_.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnCancelar_.setText("Cancelar");
        btnCancelar_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar_.setMinimumSize(new java.awt.Dimension(150, 64));
        btnCancelar_.setPreferredSize(new java.awt.Dimension(150, 64));
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

        javax.swing.GroupLayout jPanel_Login_Layout = new javax.swing.GroupLayout(jPanel_Login_);
        jPanel_Login_.setLayout(jPanel_Login_Layout);
        jPanel_Login_Layout.setHorizontalGroup(
            jPanel_Login_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_Login_Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_Login_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel_Login_Layout.createSequentialGroup()
                        .addComponent(btnCancelar_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(btnEntrar_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel_Login_Layout.setVerticalGroup(
            jPanel_Login_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Login_Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel_Login_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEntrar_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_Main_.add(jPanel_Login_, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel_Main_, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getAccessibleContext().setAccessibleDescription("Sam's Login");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrar_ActionPerformed
        ingresar();
    }//GEN-LAST:event_btnEntrar_ActionPerformed

    private void btnCancelar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar_ActionPerformed
        System.exit(0);
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

    private void btnEntrar_MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrar_MouseEntered
        opacityIn();
    }//GEN-LAST:event_btnEntrar_MouseEntered

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
            btnEntrar_.requestFocus();
        }
    }//GEN-LAST:event_txtPasswordKeyReleased

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    public javax.swing.JButton btnCancelar_;
    public javax.swing.JButton btnEntrar_;
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
