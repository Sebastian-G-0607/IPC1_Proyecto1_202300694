package clases;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

/**

 @author sebas
 */
public class Escribir_muestraBinaria {
    
    public static void escribir_muestrabin(){
        
        String nombreArchivo = "muestras.bin"; //Nombre del archivo
        File archivo = new File(nombreArchivo); //Se crea un objeto de tipo archivo con el nombre del string definido arriba
        
        try {
            FileOutputStream fos = new FileOutputStream(archivo); 
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for(Muestra muestra_temp:Escribir_muestra.muestras){
                oos.writeObject(muestra_temp);
            }
            oos.close();
            fos.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    } 
    
    //Método estático para leer las muestras del archivo binario
    public void leer_muestrabin() throws IOException, ClassNotFoundException{
        
        String nombreArchivo = "muestras.bin";
        File archivo = new File(nombreArchivo);
        
        try {
            FileInputStream fis = new FileInputStream(archivo); //Se crea un objeto que recibe flujo de bits
            ObjectInputStream ois = new ObjectInputStream(fis); //Se c
        
            while (fis.available()>0) {
                Muestra muestra_temp = (Muestra) ois.readObject();
                Escribir_muestra.muestras.add(muestra_temp);
            }

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"El sistema almacena los datos en " + e.getMessage() + ". Se creará un archivo para almacenar los datos", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (EOFException e) {
            JOptionPane.showMessageDialog(null,"El sistema no encontró datos de muestras", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
