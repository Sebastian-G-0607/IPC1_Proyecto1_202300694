/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import clases.Actualizar_Tabla;
import clases.Escribir_patron;
import clases.Escribir_patronBinario;
import javax.swing.JOptionPane;

/**

 @author sebas
 */
public class Eliminar_patron extends javax.swing.JFrame {

    /** Creates new form Eliminar_patron */
    public Eliminar_patron() {
        initComponents();
        setTitle("Eliminar Patrón");
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

        label_codigo = new javax.swing.JLabel();
        field_codigo = new javax.swing.JTextField();
        eliminar_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        label_codigo.setText("Código:");

        field_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_codigoActionPerformed(evt);
            }
        });

        eliminar_btn.setText("ELIMINAR");
        eliminar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(label_codigo)
                        .addGap(35, 35, 35)
                        .addComponent(field_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(eliminar_btn)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_codigo)
                    .addComponent(field_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(eliminar_btn)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void field_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_codigoActionPerformed

    private void eliminar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_btnActionPerformed
        
        String codigo, nombre; //Strings auxiliares para guardar codigo y nombre
        codigo = field_codigo.getText(); //El se guarda el código almacenado en el JFrame
        int index = -1; //Se inicializa un entero que servirá como bandera
        
        int longitud = Escribir_patron.patrones.size(); //Se guarda la longitud del ArrayList de Patrones
        
        //Se crea un bucle que recorra el ArrayList y que compare el código ingresado con los existentes en el array
        for(int i=0; i<longitud; i++){
            if(codigo.equals(Escribir_patron.patrones.get(i).getCodigo())){ //Se compara el codigo ingresado con cada codigo en el ArrayList
                index = i; //Si se encuentran coincidencias, se guarda el índice de la posición del Patrón
            }
        }
        if(index == -1){ //Si no se encontraron coincidencias se ejecuta el siguiente bloque
            JOptionPane.showMessageDialog(null, "No se encontraron coincidencias de código");
        }
        else{ //Si se econtraron coincidencias, se ejecuta el siguiente bloque de código
            nombre = Escribir_patron.patrones.get(index).getNombre(); //Se guarda el nombre del patron para mostrarle al usuario qué patron eliminó
            Escribir_patron.patrones.remove(index); //Se elimina el usuario del ArrayList
            Actualizar_Tabla.eliminar_elemento(Administrador.dtm_patrones, index); //Se elimina el registro de la tabla
            JOptionPane.showMessageDialog(null,"Se eliminó el patrón " + codigo + " - " + nombre); //Se muestra el mensaje de que se eliminó el patron, junto con su nombre y su código
            dispose();
            Escribir_patronBinario.escribir_patronbin(); //Se sobreescribe el binario con el nuevo arrayList
        }
    }//GEN-LAST:event_eliminar_btnActionPerformed

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
            java.util.logging.Logger.getLogger(Eliminar_patron.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Eliminar_patron.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Eliminar_patron.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Eliminar_patron.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Eliminar_patron().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton eliminar_btn;
    private javax.swing.JTextField field_codigo;
    private javax.swing.JLabel label_codigo;
    // End of variables declaration//GEN-END:variables
}
