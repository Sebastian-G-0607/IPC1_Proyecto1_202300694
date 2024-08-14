package interfaces;

 //Importando las librerías que escriben el arraylist y el binario:
import clases.Escribir_InvestigadorBinario;
import clases.Escribir_investigador;
import javax.swing.JOptionPane;

/**
 *
 * @author sebas
 */
public class Login extends javax.swing.JFrame {
    
    //Variables que almacenarán los datos del JTextField
    private String user = "";
    private String password = "";

    /**
     * Creates new form Login
     */
    public Login() {
        
        initComponents();
        setSize(600, 400);
        setResizable(false);
        setTitle("Inicio de sesión");
        setLocationRelativeTo(null);
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label_boton = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        panel_verde = new javax.swing.JPanel();
        label_password = new javax.swing.JLabel();
        label_logo = new javax.swing.JLabel();
        label_sesion = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        label_user = new javax.swing.JLabel();
        log_user = new javax.swing.JTextField();
        log_password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_boton.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        label_boton.setForeground(new java.awt.Color(255, 255, 255));
        label_boton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_boton.setText("ENTRAR");
        label_boton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_botonMouseClicked(evt);
            }
        });
        jPanel1.add(label_boton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 120, 40));

        jPanel2.setBackground(new java.awt.Color(0, 204, 102));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 120, 40));

        panel_verde.setBackground(new java.awt.Color(153, 255, 153));

        javax.swing.GroupLayout panel_verdeLayout = new javax.swing.GroupLayout(panel_verde);
        panel_verde.setLayout(panel_verdeLayout);
        panel_verdeLayout.setHorizontalGroup(
            panel_verdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        panel_verdeLayout.setVerticalGroup(
            panel_verdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        jPanel1.add(panel_verde, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 220, 400));

        label_password.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        label_password.setText("CONTRASEÑA");
        jPanel1.add(label_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 300, 40));

        label_logo.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        label_logo.setText("     QUIMIK");
        jPanel1.add(label_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 160, 20));

        label_sesion.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        label_sesion.setText("INICIAR SESION");
        jPanel1.add(label_sesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 300, 40));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 290, 10));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 290, 10));

        label_user.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        label_user.setText("USUARIO");
        jPanel1.add(label_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 300, 40));

        log_user.setBorder(null);
        log_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_userActionPerformed(evt);
            }
        });
        jPanel1.add(log_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 290, 40));

        log_password.setBorder(null);
        log_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_passwordActionPerformed(evt);
            }
        });
        jPanel1.add(log_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 260, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void log_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log_userActionPerformed
        
    }//GEN-LAST:event_log_userActionPerformed

    private void log_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log_passwordActionPerformed
        
    }//GEN-LAST:event_log_passwordActionPerformed

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked

    }//GEN-LAST:event_jPanel2MouseClicked

    //Método que captura el evento del botón del Login.
    private void label_botonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_botonMouseClicked
        
        //Se capturan las cadenas ingresadas en el JTextField
        user = log_user.getText().trim();
        password = String.valueOf(log_password.getPassword());
        
        //Instrucciones si el usuario no ingresa algún campo
        if(user.equals("") || password.equals("")){
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
            log_user.setText("");
            log_password.setText("");
        }
        //Si el usuario ingresa "admin" como usuario y contraseña, se desplegará el modulo de administrador
        else if(user.equals("admin") && password.equals("admin")){
            dispose();
            new Administrador().setVisible(true);
        }
        //Condición si el usuario ingresa un usuario y contraseña de un investigador válido
        /*else if(){
            
        }*/
        else{
            JOptionPane.showMessageDialog(null, "No se encontraron coincidencias, ingrese un usuario y contraseña válidos");
            log_user.setText("");
            log_password.setText("");
        }
    }//GEN-LAST:event_label_botonMouseClicked

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
        
        //Al iniciar el programa, se leen los objetos de tipo Investigador del archivo binario y se agreguen al arraylist
        Escribir_InvestigadorBinario.leer_investigadorbin();
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel label_boton;
    private javax.swing.JLabel label_logo;
    private javax.swing.JLabel label_password;
    private javax.swing.JLabel label_sesion;
    private javax.swing.JLabel label_user;
    private javax.swing.JPasswordField log_password;
    private javax.swing.JTextField log_user;
    private javax.swing.JPanel panel_verde;
    // End of variables declaration//GEN-END:variables
}
