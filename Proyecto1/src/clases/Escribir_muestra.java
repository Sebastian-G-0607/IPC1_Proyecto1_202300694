package clases;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

/**

 @author sebas
 */
public class Escribir_muestra {
    
    //ArrayList estático que almacena las muestras, se crea estático para que todo el programa pueda acceder al mismo Array
    public static List <Muestra> muestras = new ArrayList<>(); 
    
    //Este método comprueba que no exista el código que se está ingresando
    public static boolean comparar_codigo(String codigo){
        boolean band = false;
        for(Muestra muestra_temp:muestras){
            if(codigo.equals(muestra_temp.getCodigo())){
                band = true;
                break;
            }
        }
        return band;
    }
    
    public static void Escribir_muestraCombo(JComboBox combo, List<Muestra> muestra){

        combo.removeAllItems();
        for(Muestra muestra_temp:muestra){
            combo.addItem(muestra_temp.getDescripcion());
        }    
    } 
}
