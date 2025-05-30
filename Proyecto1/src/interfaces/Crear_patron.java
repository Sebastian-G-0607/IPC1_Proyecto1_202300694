package interfaces;

import clases.Actualizar_Tabla;
import clases.Cargar_csv;
import clases.Escribir_patron;
import clases.Escribir_patronBinario;
import clases.Patron;
import java.io.IOException;
import javax.swing.JOptionPane;

/**

 @author sebas
 */
public class Crear_patron extends javax.swing.JFrame {
    
    //Se crea una matriz que almacenará temporalmente la matriz del patrón
    int[][] patron = null;

    /** Creates new form Crear_patron */
    public Crear_patron() {
        initComponents();
        setTitle("Crear Patrón");
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     initialize the form.
     WARNING: Do NOT modify this code. The content of this method is
     always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        field_codigo = new javax.swing.JTextField();
        field_nombre = new javax.swing.JTextField();
        cargar_btn = new javax.swing.JButton();
        crear_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Código: ");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Patrón: ");

        cargar_btn.setText("CARGAR PATRON");
        cargar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargar_btnActionPerformed(evt);
            }
        });

        crear_btn.setText("CREAR");
        crear_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crear_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(field_codigo)
                    .addComponent(field_nombre)
                    .addComponent(cargar_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(192, Short.MAX_VALUE)
                .addComponent(crear_btn)
                .addGap(186, 186, 186))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(field_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(field_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cargar_btn))
                .addGap(42, 42, 42)
                .addComponent(crear_btn)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargar_btnActionPerformed
        Cargar_csv cargar = new Cargar_csv(); //Se instancia un objeto de la clase Cargar_csv
        if (cargar.cargarCSV() == 1) { //Si se cumple esta condición, el usuario sí seleccionó un archivo csv
            try {
                patron = cargar.cargarMuestra(cargar.ruta); //
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_cargar_btnActionPerformed

    private void crear_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crear_btnActionPerformed
        //Se crean strings que almacenan los textos de los JTextField
        String codigo;
        String nombre;
        
        Patron patronTemp = new Patron(); //Se crea un objeto Patron temporal que almacena los datos del formulario
        
        codigo = field_codigo.getText(); //Se guarda el código introducido en el String codigo
        nombre = field_nombre.getText(); //Se guarda el nombre introducido en el JTextField en el String nombre
        
        //Si alguno de los campos está vacío o no se ha cargado una matriz, se muestra un mensaje de error
        if(codigo.equals("") || nombre.equals("") || patron == null){
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos", "Error", JOptionPane.ERROR_MESSAGE); //Mensaje de error
        }
        else if(Escribir_patron.comparar_codigo(codigo)){ //Se invoca el método comparar_codigo() de la clase Escribir_patron, si este es True, significa que el código ya existe
            JOptionPane.showMessageDialog(null, "El código que ingresó ya existe en el sistema", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{ //Si no se cumple ninguna condición anterior, los datos se almacenarán en el sistema
            
            //En el Objeto de tipo Patron se guardan los atributos ingresados
            patronTemp.setCodigo(codigo);
            patronTemp.setNombre(nombre);
            patronTemp.setPatron(patron); //La matriz del csv se guardó previamente en una matriz que se declaró como variable global en esta clase

            
            Escribir_patron.patrones.add(patronTemp); //El patron temporal se ingresa en el ArrayList
            
            Escribir_patronBinario.escribir_patronbin();//Se escribe el Array de patrones en el archivo binario
            Actualizar_Tabla.nuevo_patron(Administrador.dtm_patrones, Escribir_patron.patrones, Administrador.ver); //Se actualiza la tabla de patrones
            
            JOptionPane.showMessageDialog(null, "Se ha introducido la muestra correctamente"); //Mensaje de agregado con éxito
            patron = null; //Se limpia la variable patron para que se pueda ingresar otro patrón posteriormente
            dispose(); //Se cierra el formulario
        }
    }//GEN-LAST:event_crear_btnActionPerformed

    /**
     @param args the command line arguments
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
            java.util.logging.Logger.getLogger(Crear_patron.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Crear_patron.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Crear_patron.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Crear_patron.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Crear_patron().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cargar_btn;
    private javax.swing.JButton crear_btn;
    private javax.swing.JTextField field_codigo;
    private javax.swing.JTextField field_nombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
