/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sebas
 */
public class Actualizar_Tabla {

    public static void nuevo_elemento(DefaultTableModel dtm, List<Investigador> investigador) {
        
        int longitud = investigador.size();
        Investigador investigador_temp = new Investigador();
        investigador_temp = investigador.get(longitud-1);
        
        dtm.addRow(new Object[]{investigador_temp.getCodigo(),investigador_temp.getNombre(), investigador_temp.getGenero(), investigador_temp.getNumExperimentos()});
        
    }
    
    public static void actualizar_elemento(DefaultTableModel dtm, int index, List<Investigador> investigador) {
        
        dtm.setValueAt(investigador.get(index).getNombre(), index, 1);
        dtm.setValueAt(String.valueOf(investigador.get(index).getGenero()), index, 2);
        dtm.setValueAt(investigador.get(index).getContrasenia(), index, 3);
        
    }
    
    
    
}
