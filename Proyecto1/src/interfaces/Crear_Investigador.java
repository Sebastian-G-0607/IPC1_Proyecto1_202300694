package interfaces;

//Importando librerías 
import clases.Actualizar_Tabla;
import clases.Escribir_InvestigadorBinario;
import clases.Escribir_investigador;
import clases.Investigador;
import javax.swing.JOptionPane;

/* @author sebas */
public class Crear_Investigador extends javax.swing.JFrame {

    /* Creates new form NuevoInvestigador */
    public Crear_Investigador() {
        initComponents();
        setTitle("Crear Investigador");
        setResizable(false);
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

        label_codigo = new javax.swing.JLabel();
        label_nombre = new javax.swing.JLabel();
        label_genero = new javax.swing.JLabel();
        label_contrasenia = new javax.swing.JLabel();
        crear_btn = new javax.swing.JButton();
        field_codigo = new javax.swing.JTextField();
        field_nombre = new javax.swing.JTextField();
        field_genero = new javax.swing.JTextField();
        field_contra = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        label_codigo.setText("Código: ");

        label_nombre.setText("Nombre:");

        label_genero.setText("Género (M/F):");

        label_contrasenia.setText("Contraseña:");

        crear_btn.setText("CREAR");
        crear_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crear_btnActionPerformed(evt);
            }
        });

        field_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_codigoActionPerformed(evt);
            }
        });

        field_genero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_generoActionPerformed(evt);
            }
        });
        field_genero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                field_generoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_genero)
                                .addGap(40, 40, 40)
                                .addComponent(field_genero, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_codigo)
                                    .addComponent(label_nombre)
                                    .addComponent(label_contrasenia))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(field_nombre)
                                    .addComponent(field_contra)
                                    .addComponent(field_codigo)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(crear_btn)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_codigo)
                    .addComponent(field_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_nombre)
                    .addComponent(field_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_genero)
                    .addComponent(field_genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_contrasenia)
                    .addComponent(field_contra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(crear_btn)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Método que captura el evento del botón crear
    private void crear_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crear_btnActionPerformed
        
        //Variables auxiliares
        String codigo, nombre, contrasenia;
        char genero = '\u0000';
        Investigador investigador = new Investigador();
        
        codigo = field_codigo.getText();
        nombre = field_nombre.getText();
        contrasenia = field_contra.getText();
        
        if(!field_genero.getText().equals("")){ //Si el género no está vacío, se ejecuta el siguiente bloque
            genero = field_genero.getText().charAt(0);
            genero = Character.toUpperCase(genero);
        }
        
        //Si el usuario no ingresa todos los datos, se ejecuta el siguiente bloque:
        if(codigo.equals("") || nombre.equals("") || contrasenia.equals("") || genero == '\u0000'){
            JOptionPane.showMessageDialog(null,"Ingrese todos los campos", "Error al crear el investigador", JOptionPane.WARNING_MESSAGE);
        }
        //Si el usuario ingresa un género distinto de F o M, se ejecuta el siguente bloque
        else if(genero != 'M' && genero != 'F' ){
            JOptionPane.showMessageDialog(null, "Ingrese un género válido", "Error al crear el investigador", JOptionPane.WARNING_MESSAGE);
        }
        //Si el código que ingresó el usuario ya existe en el registro, se ejecuta el siguiente bloque
        else if(!Escribir_investigador.investigadores.isEmpty() && Escribir_investigador.comparar_codigo(codigo) == true){
            JOptionPane.showMessageDialog(null,"El código que ingresó ya existe, ingrese uno válido");
        }
        //Si ninguna condición anterior se cumple, los datos ingresados son correctos y se ejecuta el siguiente bloque
        else{
            //Se asignan los valores ingresados en los JTextField al investigador temporal
            investigador.setCodigo(codigo);
            investigador.setNombre(nombre);
            investigador.setGenero(genero);
            investigador.setContrasenia(contrasenia);
            investigador.setNumExperimentos(0);
            
            //Se agrega el investigador temporal a la lista
            Escribir_investigador.investigadores.add(investigador);
            Escribir_InvestigadorBinario.escribir_investigadorbin();
            
            //Se agrega el investigador a la tabla
            Actualizar_Tabla.nuevo_elemento(Administrador.dtm1, Escribir_investigador.investigadores);
            //Se agrega el investigador al JComboBox de investigadores de la pestaña de asignar muestras
            Escribir_investigador.Escribir_investigadorCombo(Administrador.combo_investigador, Escribir_investigador.investigadores);
            
            JOptionPane.showMessageDialog(null,"Investigador ingresado correctamente");
            
            dispose();
        }
    }//GEN-LAST:event_crear_btnActionPerformed

    private void field_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_codigoActionPerformed

    private void field_generoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_generoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_generoActionPerformed

    //Método para que en el género solo se pueda ingresar M o F y únicamente un caracter
    private void field_generoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_generoKeyTyped
        int key = evt.getKeyChar();
        
        boolean genero = (key == 70) || (key == 77) || (key == 102)  || (key == 109); //Se valida que genero sea M o F, en mayuscula o minuscula
        
        if(!genero){ //Si no se ingresa un género válido (M o F) se elimina el caracter
            evt.consume();
        }
        
        if(field_genero.getText().trim().length() == 1){ //Si ya se ingresó un caracter, no se pueden ingresar más
            evt.consume();
        }
    }//GEN-LAST:event_field_generoKeyTyped

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
            java.util.logging.Logger.getLogger(Crear_Investigador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Crear_Investigador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Crear_Investigador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Crear_Investigador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Crear_Investigador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton crear_btn;
    private javax.swing.JTextField field_codigo;
    private javax.swing.JTextField field_contra;
    private javax.swing.JTextField field_genero;
    private javax.swing.JTextField field_nombre;
    private javax.swing.JLabel label_codigo;
    private javax.swing.JLabel label_contrasenia;
    private javax.swing.JLabel label_genero;
    private javax.swing.JLabel label_nombre;
    // End of variables declaration//GEN-END:variables
}
