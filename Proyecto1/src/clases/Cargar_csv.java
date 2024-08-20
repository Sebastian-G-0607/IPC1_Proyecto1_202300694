/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author sebas
 */

//Clase para cargar un csv al programa
public class Cargar_csv {
    
    public String ruta;
    public File ruta_archivo;
    
    //Método para seleccionar el archivo desde el JFileChooser
    public int cargarCSV() { 
        int band = 0;
        JFileChooser selArchivo = new JFileChooser("C:\\Users\\sebas\\OneDrive\\Escritorio");
        int val = selArchivo.showOpenDialog(null);
        if(val != selArchivo.CANCEL_OPTION){
            ruta = selArchivo.getSelectedFile().getAbsolutePath(); 
//            ruta_archivo = selArchivo.getSelectedFile(); 
//            System.out.println(ruta); 
            band = 1;
            return band;
        }
        else {
            return band;
        }
    }
    
    //Método para cargar los investigadores al array
    public void cargarAlArray(String rutaArchivo) throws IOException{
        
        String extension = null;
        
        int i = rutaArchivo.lastIndexOf("."); //Obtengo el índice donde se encuentra el punto de la ruta del archivo
        if(i>0){
           extension = rutaArchivo.substring(i+1); 
//            System.out.println(extension);
            
            if(extension.equals("csv")){ //Si la extensión es csv, el archivo se puede leer
               Leer_csv lector = new Leer_csv();
               lector.leer_archivoInvestigadores(rutaArchivo);
            }
            else{
                JOptionPane.showMessageDialog(null,"El tipo de archivo no es válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Archivo no reconocido", "Error", JOptionPane.ERROR_MESSAGE);
        }

        
                
    }
    
    public int[][] cargarMuestra(String rutaArchivo) throws IOException{
        
        int[][] matrix = null;
        String extension = null;
        
        int i = rutaArchivo.lastIndexOf("."); //Obtengo el índice donde se encuentra el punto de la ruta del archivo
        if(i>0){
           extension = rutaArchivo.substring(i+1); 
//            System.out.println(extension);
            
            if(extension.equals("csv")){ //Si la extensión es csv, el archivo se puede leer
               Leer_csv lector = new Leer_csv();
               matrix = lector.leer_patronNuevaMuestra(rutaArchivo);
            }
            else{
                JOptionPane.showMessageDialog(null,"El tipo de archivo no es válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Archivo no reconocido", "Error", JOptionPane.ERROR_MESSAGE);
        }       
        return matrix;
    }
    
}
