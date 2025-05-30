package interfaces;

import clases.Actualizar_Tabla;
import clases.Escribir_InvestigadorBinario;
import clases.Escribir_investigador;
import clases.Grafica_investigadores;
import clases.Investigador;
import clases.Top_3;
import javax.swing.JOptionPane;

/**
 *
 * @author sebas
 */
public class Actualizar_Investigador extends javax.swing.JFrame {

    /**
     * Creates new form Actualizar_Investigador
     */
    public Actualizar_Investigador() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Actualizar investigador");
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
        field_codigo = new javax.swing.JTextField();
        buscar_btn = new javax.swing.JButton();
        field_nombre = new javax.swing.JTextField();
        field_genero = new javax.swing.JTextField();
        field_contra = new javax.swing.JTextField();
        actualizar_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        label_codigo.setText("Código: ");

        label_nombre.setText("Nombre: ");

        label_genero.setText("Género (M/F): ");

        label_contrasenia.setText("Contraseña:");

        field_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_codigoActionPerformed(evt);
            }
        });

        buscar_btn.setText("BUSCAR");
        buscar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_btnActionPerformed(evt);
            }
        });

        actualizar_btn.setText("ACTUALIZAR");
        actualizar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizar_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_genero)
                                .addGap(39, 39, 39)
                                .addComponent(field_genero, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_codigo)
                                    .addComponent(label_nombre)
                                    .addComponent(label_contrasenia))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(field_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(buscar_btn))
                                    .addComponent(field_nombre)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(field_contra)
                                        .addGap(2, 2, 2))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(actualizar_btn)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_codigo)
                    .addComponent(field_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar_btn))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_nombre)
                    .addComponent(field_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_genero)
                    .addComponent(field_genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_contrasenia)
                    .addComponent(field_contra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(actualizar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void field_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_codigoActionPerformed

    private void buscar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_btnActionPerformed
        
        String codigo, nombre, contrasenia;
        char genero = '\u0000';
        //Investigador investigador = new Investigador();
        
        codigo = field_codigo.getText();
        nombre = field_nombre.getText();
        contrasenia = field_contra.getText();
      
        for(Investigador investigador_temp:Escribir_investigador.investigadores){
            
            String codigoTemp = investigador_temp.getCodigo();
            
            if(codigoTemp.equals(codigo)){
                field_nombre.setText(investigador_temp.getNombre());
                field_genero.setText(String.valueOf(investigador_temp.getGenero()));
                field_contra.setText(investigador_temp.getContrasenia());
                break;
            }
            
        }
        
    }//GEN-LAST:event_buscar_btnActionPerformed

    private void actualizar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizar_btnActionPerformed
      
        String codigo, nombre, contrasenia;
        char genero = '\u0000';
        
        codigo = field_codigo.getText();
        
        int index = -1;
        int tamanio = Escribir_investigador.investigadores.size();
        
        for(int i = 0; i<tamanio; i++){
            if(Escribir_investigador.investigadores.get(i).getCodigo().equals(codigo)){
                index = i;
                break;
        }
        }
            
        nombre = field_nombre.getText();
        contrasenia = field_contra.getText();
        
        if(!field_genero.getText().equals("")){
            genero = field_genero.getText().charAt(0);
            genero = Character.toUpperCase(genero);
        }
        
        if(codigo.equals("") || nombre.equals("") || contrasenia.equals("") || genero == '\u0000'){
            JOptionPane.showMessageDialog(null,"Ingrese todos los campos");
        }
        else if(genero != 'M' && genero != 'F' ){
            JOptionPane.showMessageDialog(null, "Ingrese un género válido");
        }
        else if(index != -1){
            if(Escribir_investigador.investigadores.get(index).getNombre().equals(nombre) && Escribir_investigador.investigadores.get(index).getGenero() == genero && Escribir_investigador.investigadores.get(index).getContrasenia().equals(contrasenia)){
                JOptionPane.showMessageDialog(null,"Debe actualizar al menos un campo");
        }
        else{
                
            Escribir_investigador.investigadores.get(index).setNombre(nombre);
            Escribir_investigador.investigadores.get(index).setGenero(genero);
            Escribir_investigador.investigadores.get(index).setContrasenia(contrasenia);
            Escribir_InvestigadorBinario.escribir_investigadorbin();
            Actualizar_Tabla.actualizar_elemento(Administrador.dtm1, index, Escribir_investigador.investigadores);
            Escribir_investigador.Escribir_investigadorCombo(Administrador.combo_investigador, Escribir_investigador.investigadores);
            JOptionPane.showMessageDialog(null,"Se actualizó el investigador correctamente");

            if(Escribir_investigador.investigadores != null && Escribir_investigador.investigadores.size() >= 3){

                Administrador.panel_grafica.removeAll();

                Grafica_investigadores graficador1 = new Grafica_investigadores();

                Top_3 top = new Top_3();
                top.obtener_top3(Escribir_investigador.investigadores);
                top.nombres_experimentos(Escribir_investigador.investigadores, top.getCodigo1(), top.getCodigo2(), top.getCodigo3());

                graficador1.graficar(top.getNum1(), top.getNum2(), top.getNum3(), top.getNombre1(), top.getNombre2(), top.getNombre3());
            }
            dispose();
        }
            
        }
        else if(index == -1){
            JOptionPane.showMessageDialog(null,"No se encontraron coincidencias");
            field_codigo.setText("");
            field_nombre.setText("");
            field_genero.setText("");
            field_contra.setText("");
        }
                
    }//GEN-LAST:event_actualizar_btnActionPerformed

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
            java.util.logging.Logger.getLogger(Actualizar_Investigador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Actualizar_Investigador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Actualizar_Investigador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Actualizar_Investigador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Actualizar_Investigador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar_btn;
    private javax.swing.JButton buscar_btn;
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
