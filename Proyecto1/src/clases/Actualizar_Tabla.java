/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import interfaces.Administrador;
import java.util.List;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sebas
 */
public class Actualizar_Tabla {

    //Método estático para ingresar un nuevo investigador a la tabla del módulo de administrador
    public static void nuevo_elemento(DefaultTableModel dtm, List<Investigador> investigador) {
        
        //Se obtiene la longitud del arreglo
        int longitud = investigador.size();
        Investigador investigador_temp = new Investigador(); //Objeto Investigador temporal
        investigador_temp = investigador.get(longitud-1); //Se obtiene el último elemento de la lista
        
        dtm.addRow(new Object[]{investigador_temp.getCodigo(),investigador_temp.getNombre(), investigador_temp.getGenero(), investigador_temp.getNumExperimentos()});
        
    }
    
    //Método estático para actualizar un elemento de la tabla de investigadores
    public static void actualizar_elemento(DefaultTableModel dtm, int index, List<Investigador> investigador) {
        
        dtm.setValueAt(investigador.get(index).getNombre(), index, 1);
        dtm.setValueAt(String.valueOf(investigador.get(index).getGenero()), index, 2);
        dtm.setValueAt(investigador.get(index).getNumExperimentos(), index, 3);
        
    }
    
    //Método estático para actualizar un elemento de la tabla de muestras
    public static void actualizar_muestra(DefaultTableModel dtm, int index, List<Muestra> muestra) {
        dtm.setValueAt(muestra.get(index).getEstado(), index, 2);
    }
    
    //Método estático para eliminar un elemento de la tabla de investigadores
    public static void eliminar_elemento(DefaultTableModel dtm, int index){
        dtm.removeRow(index);
    }
    
    public static void nueva_muestra(DefaultTableModel dtm, List<Muestra> muestra, JButton btn){
        //Se obtiene el tamaño de la lista de muestras
        int longitud = muestra.size();
        Muestra muestra_temp = new Muestra(); //Objeto Muestra temporal
        muestra_temp = muestra.get(longitud-1); //Se obtiene el último elemento introducido a la lista de muestras
       
        //Se agrega el objeto a la tabla
        dtm.addRow(new Object[]{muestra_temp.getCodigo(), muestra_temp.getDescripcion(), muestra_temp.getEstado(), btn});
    }
    
    public static void nuevo_patron(DefaultTableModel dtm, List<Patron> patron, JButton btn){
        //Se obtiene el tamaño de la lista de muestras
        int longitud = patron.size();
        Patron patron_temp = new Patron(); //Objeto Muestra temporal
        patron_temp = patron.get(longitud-1); //Se obtiene el último elemento introducido a la lista de muestras
       
        //Se agrega el objeto a la tabla
        dtm.addRow(new Object[]{patron_temp.getCodigo(), patron_temp.getNombre(), btn});
    }
     
}
