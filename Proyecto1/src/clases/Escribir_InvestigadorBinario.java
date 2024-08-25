package clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author sebas
 */
public class Escribir_InvestigadorBinario {
    
    //Método estático para escribir el arraylist de tipo Investigador en el archivo binario
    public static void escribir_investigadorbin(){
        
        String nombreArchivo = "investigadores.bin"; //Nombre del archivo
        File archivo = new File(nombreArchivo);
        
        try {
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for(Investigador investigador_temp:Escribir_investigador.investigadores){
                oos.writeObject(investigador_temp);
            }
            oos.close();
            fos.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage() , "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    //Método estático para leer el archivo binario cargar los elementos en el arraylist de tipo Investigador
    public void leer_investigadorbin() throws IOException, ClassNotFoundException{
        
        String nombreArchivo = "investigadores.bin";
        File archivo = new File(nombreArchivo);
        
        try {
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
        
        while (fis.available()>0) {
            Investigador investigador_temp = (Investigador) ois.readObject();
            Escribir_investigador.investigadores.add(investigador_temp);
        }

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "El sistema almacena los datos en " + e.getMessage() + ". Se creará un archivo para almacenar los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
