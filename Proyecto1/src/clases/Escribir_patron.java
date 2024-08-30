/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import static clases.Escribir_muestra.muestras;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

/**

 @author sebas
 */
public class Escribir_patron {
    
    public static List<Patron> patrones = new ArrayList<> ();
    
    //Este método comprueba que no exista el código que se está ingresando
    public static boolean comparar_codigo(String codigo){
        boolean band = false;
        for(Patron patron_temp:patrones){
            if(codigo.equals(patron_temp.getCodigo())){
                band = true;
                break;
            }
        }
        return band;
    }
    
    public static void Escribir_patronCombo(JComboBox combo, List<Patron> patron){

        combo.removeAllItems();
        for(Patron patron_temp:patron){
            combo.addItem(patron_temp.getNombre());
        }    
    } 
    
}
