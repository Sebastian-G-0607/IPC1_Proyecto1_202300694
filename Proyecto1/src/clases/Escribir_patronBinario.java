/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class Escribir_patronBinario {
    public static void escribir_patronbin(){
        
        String nombreArchivo = "patrones.bin"; //Nombre del archivo
        File archivo = new File(nombreArchivo); //Se crea un objeto de tipo archivo con el nombre del string definido arriba
        
        try {
            FileOutputStream fos = new FileOutputStream(archivo); 
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for(Patron patron_temp:Escribir_patron.patrones){
                oos.writeObject(patron_temp);
            }
            oos.close();
            fos.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    } 
    
    //Método estático para leer las muestras del archivo binario
    public void leer_patronbin() throws IOException, ClassNotFoundException{
        
        String nombreArchivo = "patrones.bin";
        File archivo = new File(nombreArchivo);
        
        try {
            FileInputStream fis = new FileInputStream(archivo); //Se crea un objeto que recibe flujo de bits
            ObjectInputStream ois = new ObjectInputStream(fis); 
        
            while (fis.available()>0) { //Mientras existan bits para leer, se ejecuta el siguiente bloque
                Patron patron_temp = (Patron) ois.readObject();
                Escribir_patron.patrones.add(patron_temp);
            }

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"El sistema almacena los datos en " + e.getMessage() + ". Se creará un archivo para almacenar los datos", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (EOFException e) {
            JOptionPane.showMessageDialog(null,"El sistema no encontró datos de patrones", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
