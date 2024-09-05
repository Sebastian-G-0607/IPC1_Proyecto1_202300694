package clases;

import java.util.List;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author sebas
 */
public class Escribir_investigador {
    
    public static List<Investigador> investigadores = new ArrayList<Investigador> ();
    
    public void Escribir_investigador(String codigo, String nombre, char genero, int numExperimentos, Muestra muestra_asignada){
        investigadores.add(new Investigador(codigo, nombre, genero, numExperimentos, muestra_asignada));
    }
    
    public void Escribir_investigador(String codigo, String nombre, char genero, String contrasenia){
        investigadores.add(new Investigador(codigo, nombre, genero, contrasenia));
    }
    
    public static boolean comparar_codigo(String codigo){
        boolean band = false;
        for(Investigador investigador:investigadores){
            if(investigador.getCodigo().equals(codigo)){
                band = true;
                break;
            }
        }
        return band;
    }
    
    public static void Escribir_investigadorCombo(JComboBox combo, List<Investigador> investigador){

        combo.removeAllItems();
        for(Investigador investigador_temp:investigador){
            combo.addItem(investigador_temp.getNombre());
        }    
        
    }
       
}
