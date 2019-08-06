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
import java.awt.event.KeyEvent;

/**
 *
 * @author Marko
 */
public class Login extends javax.swing.JFrame {
    /**
     * Creates new form login
     */
    
    private void limpiar() {
        txtUsuario.setText("");
        txtPassword.setText("");
    }
    
    private void settings (){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(gui.MainMenu.getIconDir())));
        setBackground(new Color (0,0,0,0));
        jPanel_Main_.setBackground(new Color (0,0,0,0));
        txtUsuario.requestFocus();
    }
    
    public Login() {
        initComponents();
        settings ();
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
        jPanel_Logo_ = new javax.swing.JPanel();
        jLabel_LogoUser_ = new javax.swing.JLabel();
        jPanel_Login_ = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        btnEntrar1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(null);
        setMinimumSize(new java.awt.Dimension(300, 500));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(360, 515));
        setType(java.awt.Window.Type.POPUP);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_Main_.setMaximumSize(null);
        jPanel_Main_.setOpaque(false);
        jPanel_Main_.setLayout(new java.awt.BorderLayout());

        jPanel_Logo_.setMaximumSize(null);
        jPanel_Logo_.setOpaque(false);
        jPanel_Logo_.setLayout(new java.awt.BorderLayout());

        jLabel_LogoUser_.setBackground(java.awt.Color.darkGray);
        jLabel_LogoUser_.setForeground(java.awt.Color.white);
        jLabel_LogoUser_.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_LogoUser_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/core/resources/icons/userGx300.png"))); // NOI18N
        jLabel_LogoUser_.setMaximumSize(null);
        jLabel_LogoUser_.setMinimumSize(new java.awt.Dimension(300, 310));
        jLabel_LogoUser_.setPreferredSize(new java.awt.Dimension(300, 310));
        jPanel_Logo_.add(jLabel_LogoUser_, java.awt.BorderLayout.CENTER);

        jPanel_Main_.add(jPanel_Logo_, java.awt.BorderLayout.NORTH);

        jPanel_Login_.setBackground(java.awt.Color.darkGray);
        jPanel_Login_.setMaximumSize(null);
        jPanel_Login_.setMinimumSize(new java.awt.Dimension(360, 205));
        jPanel_Login_.setOpaque(false);

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtUsuario.setToolTipText("Usuario");
        txtUsuario.setCaretColor(new java.awt.Color(102, 0, 0));
        txtUsuario.setMaximumSize(null);
        txtUsuario.setMinimumSize(new java.awt.Dimension(170, 32));
        txtUsuario.setPreferredSize(new java.awt.Dimension(170, 32));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Password:");
        jLabel2.setMaximumSize(null);
        jLabel2.setMinimumSize(new java.awt.Dimension(110, 32));
        jLabel2.setPreferredSize(new java.awt.Dimension(110, 32));

        btnEntrar.setBackground(new java.awt.Color(102, 0, 0));
        btnEntrar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.setMaximumSize(null);
        btnEntrar.setMinimumSize(new java.awt.Dimension(110, 32));
        btnEntrar.setPreferredSize(new java.awt.Dimension(110, 32));
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtPassword.setToolTipText("Contraseña");
        txtPassword.setCaretColor(new java.awt.Color(102, 0, 0));
        txtPassword.setMaximumSize(null);
        txtPassword.setMinimumSize(new java.awt.Dimension(170, 32));
        txtPassword.setPreferredSize(new java.awt.Dimension(170, 32));
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        btnEntrar1.setBackground(new java.awt.Color(102, 0, 0));
        btnEntrar1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnEntrar1.setText("Cancelar");
        btnEntrar1.setMaximumSize(null);
        btnEntrar1.setMinimumSize(new java.awt.Dimension(110, 32));
        btnEntrar1.setPreferredSize(new java.awt.Dimension(110, 32));
        btnEntrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrar1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Usuario:");
        jLabel1.setMaximumSize(null);
        jLabel1.setMinimumSize(new java.awt.Dimension(110, 32));
        jLabel1.setPreferredSize(new java.awt.Dimension(110, 32));

        javax.swing.GroupLayout jPanel_Login_Layout = new javax.swing.GroupLayout(jPanel_Login_);
        jPanel_Login_.setLayout(jPanel_Login_Layout);
        jPanel_Login_Layout.setHorizontalGroup(
            jPanel_Login_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Login_Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel_Login_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEntrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_Login_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_Login_Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEntrar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );
        jPanel_Login_Layout.setVerticalGroup(
            jPanel_Login_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Login_Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_Login_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel_Login_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel_Login_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEntrar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel_Main_.add(jPanel_Login_, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel_Main_, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/core/resources/Login.png"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getAccessibleContext().setAccessibleDescription("Sam's Login");

        setSize(new java.awt.Dimension(360, 515));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
//        setOpacity(0.6f);
    }//GEN-LAST:event_formFocusLost

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
//        setOpacity(1f);
    }//GEN-LAST:event_formFocusGained

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed

        SqlUsuarios modSql = new SqlUsuarios();
        Usuarios mod = new Usuarios();

        String pass = new String(txtPassword.getPassword());

        if (!txtUsuario.getText().equals("") && !pass.equals("")) {

            String nuevoPass = Hash.sha1(pass);

            mod.setUsuario(txtUsuario.getText());
            mod.setPassword(nuevoPass);

            if (modSql.login(mod)) {
                this.dispose();

                if (mod.getIdTipo() == 1) {
                    gui.MainMenu mainMenu = new MainMenu();
                    mainMenu.setVisible(true);

                    mainMenu.setUSUARIO(mod.getNombre());
                    mainMenu.setNIVLE("Administrador");

                    //                    menu.lblUser.setText(mod.getNombre());
                    //                    MenuPrincipal.lblCargo.setText("Administrador");
                } else if (mod.getIdTipo() != 1) {
                    gui.MainMenu mainMenu = new MainMenu();
                    mainMenu.setVisible(true);

                    mainMenu.setUSUARIO(mod.getNombre());
                    mainMenu.setNIVLE("Usuario");

                    //                    menu.lblUser.setText(mod.getNombre());
                    //                    MenuPrincipal.lblCargo.setText("Usuario");
                } else {
                    System.err.println("Error");
                    limpiar();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Datos incorrectos");
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar sus datos");
            limpiar();
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        char teclapresionada = evt.getKeyChar();
        if (teclapresionada == KeyEvent.VK_ENTER) {

            SqlUsuarios modSql = new SqlUsuarios();
            Usuarios mod = new Usuarios();

            String pass = new String(txtPassword.getPassword());

            if (!txtUsuario.getText().equals("") && !pass.equals("")) {

                String nuevoPass = Hash.sha1(pass);

                mod.setUsuario(txtUsuario.getText());
                mod.setPassword(nuevoPass);

                if (modSql.login(mod)) {
                    this.dispose();

                    if (mod.getIdTipo() == 1) {
                        gui.MainMenu mainMenu = new MainMenu();
                        mainMenu.setVisible(true);

                        mainMenu.setUSUARIO(mod.getNombre());
                        mainMenu.setNIVLE("Administrador");
                    } else if (mod.getIdTipo() != 1) {
                        gui.MainMenu mainMenu = new MainMenu();
                        mainMenu.setVisible(true);

                        mainMenu.setUSUARIO(mod.getNombre());
                        mainMenu.setNIVLE("Usuario");

                        //                    menu.lblUser.setText(mod.getNombre());
                        //                    MenuPrincipal.lblCargo.setText("Usuario");
                    } else {
                        System.err.println("Error");
                        limpiar();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Datos incorrectos");
                    limpiar();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe ingresar sus datos");
                limpiar();
            }
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void btnEntrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrar1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnEntrar1ActionPerformed

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
    public javax.swing.JButton btnEntrar;
    public javax.swing.JButton btnEntrar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_LogoUser_;
    private javax.swing.JPanel jPanel_Login_;
    private javax.swing.JPanel jPanel_Logo_;
    private javax.swing.JPanel jPanel_Main_;
    public javax.swing.JPasswordField txtPassword;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
