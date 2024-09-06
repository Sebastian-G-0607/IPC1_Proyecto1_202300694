package clases;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author sebas
 */

//Clase para cargar un csv al programa
public class Cargar_csv {
    
    public String ruta;
    
    //Método para seleccionar el archivo desde el JFileChooser
    public int cargarCSV() { 
        int band = 0; //Bandera para saber si el usuario cargó un archivo
        JFileChooser selArchivo = new JFileChooser("C:\\Users\\sebas\\OneDrive\\Escritorio"); //Abrir un JFileChooser desde la dirección específicada
        int val = selArchivo.showOpenDialog(null); //Se muestra la interfaz
        if(val != selArchivo.CANCEL_OPTION){ //Si el usuario no cerró el JFileChooser:
            ruta = selArchivo.getSelectedFile().getAbsolutePath(); //Se guarda la ruta del archivo que el usuario seleccionó
            band = 1; //Se cambia la bandera a 1
            return band; //se retorna band
        }
        else {
            return band; //Se retorna band como false
        }
    }
    
    //Método para cargar los investigadores al array
    public void cargarAlArray(String rutaArchivo) throws IOException{
        
        String extension = null;
        
        int i = rutaArchivo.lastIndexOf("."); //Obtengo el índice donde se encuentra el punto de la ruta del archivo
        if(i>0){
           extension = rutaArchivo.substring(i+1); 
            
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
    
    //Método para cargar la matriz del csv a una matriz int[][]
    public int[][] cargarMuestra(String rutaArchivo) throws IOException{
        
        int[][] matrix = null;
        String extension = null;
        
        int i = rutaArchivo.lastIndexOf("."); //Obtengo el índice donde se encuentra el punto de la ruta del archivo
        if(i>0){
           extension = rutaArchivo.substring(i+1); 
            
            if(extension.equals("csv")){ //Si la extensión es csv, el archivo se puede leer
               Leer_csv lector = new Leer_csv(); // Se instancia un objeto de la clase Leer_csv para leer la matriz del csv
               matrix = lector.leer_patronNuevaMuestra(rutaArchivo); //Se iguala la variable local matrix a la matriz que retorna la el método leer_patronNuevaMuestra
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
    
    public void cargarcsvMuestra(String rutaArchivo, int estado) throws IOException{
        
        String extension = null;
        
        int i = rutaArchivo.lastIndexOf("."); //Obtengo el índice donde se encuentra el punto de la ruta del archivo
        if(i>0){
           extension = rutaArchivo.substring(i+1); 
            
            if(extension.equals("csv")){ //Si la extensión es csv, el archivo se puede leer
               Leer_csv lector = new Leer_csv(); // Se instancia un objeto de la clase Leer_csv para leer la matriz del csv
               lector.leer_cargaMuestra(rutaArchivo, estado); //Se invoca el método leer_cargaMuestra para cargar las muestras del csv
            }
            else{
                JOptionPane.showMessageDialog(null,"El tipo de archivo no es válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Archivo no reconocido", "Error", JOptionPane.ERROR_MESSAGE);
        }       
    }
    
}
