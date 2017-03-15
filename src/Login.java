
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fariz
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        tUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bLogin = new javax.swing.JButton();
        tPass = new javax.swing.JPasswordField();
        bHelp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("LOGIN");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 10, 90, 40);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 50, 400, 2);

        tUser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(tUser);
        tUser.setBounds(110, 100, 190, 40);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(170, 140, 60, 30);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Username");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(170, 70, 60, 30);

        bLogin.setText("Login");
        bLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoginActionPerformed(evt);
            }
        });
        getContentPane().add(bLogin);
        bLogin.setBounds(160, 220, 73, 40);

        tPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(tPass);
        tPass.setBounds(110, 170, 190, 40);

        bHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHelpActionPerformed(evt);
            }
        });
        getContentPane().add(bHelp);
        bHelp.setBounds(110, 20, 20, 23);

        setSize(new java.awt.Dimension(415, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoginActionPerformed
        Connection connection;
        PreparedStatement ps;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_utspbo?zeroDateTimeBehavior=convertToNull","root","");
            ps = connection.prepareStatement("SELECT `username`, `password` FROM `tb_akun` WHERE `username` = ? AND `password` = ?");
            ps.setString(1, tUser.getText());
            ps.setString(2, tPass.getText());
            ResultSet result = ps.executeQuery();
            if(result.next()) {
                new mainFrm().show();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane,"Salah!");
                tUser.setText("");
                tPass.requestFocus();
            }
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(rootPane,"Gagal");
        }
    }//GEN-LAST:event_bLoginActionPerformed

    private void bHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHelpActionPerformed
        JOptionPane.showMessageDialog(this, "username : admin\npassword : admin", "User & pass", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_bHelpActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bHelp;
    private javax.swing.JButton bLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPasswordField tPass;
    private javax.swing.JTextField tUser;
    // End of variables declaration//GEN-END:variables
}
