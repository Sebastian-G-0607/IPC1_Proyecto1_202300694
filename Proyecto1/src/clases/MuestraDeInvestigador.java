package clases;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**

 @author sebas
 */
public class MuestraDeInvestigador {
    
    public void borrar_MuestraInvestigador(int indexInvestigador, String descripcion_muestra, List<Investigador> investigadores){
        int indexMuestra = -1; //Se crea una variable entera que almacena el índice de la muestra de la lista de muestras del investigador
        
        //Se crea una copia de la lista de muestras
        List<Object> muestra = new ArrayList<>();
        muestra = investigadores.get(indexInvestigador).getMuestra_asignada();
        
        //Se recorre cada objeto de la lista muestra, buscando coincidencia de descripción
        for(int i=0; i<muestra.size(); i++){
            Muestra muestraTemp = (Muestra) muestra.get(i); //Se crea una variable tipo Muestra temporal con el elemento i de la lista muestra. Hay que realizar un casteo para esto
            if(muestraTemp.getDescripcion().equals(descripcion_muestra)){
                indexMuestra = i;
                break;
            }
        }
        
        investigadores.get(indexInvestigador).getMuestra_asignada().remove(indexMuestra);
        
        
    }
    
    
}
