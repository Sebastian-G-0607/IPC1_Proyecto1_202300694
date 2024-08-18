/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;
import interfaces.Administrador;

/**
 *
 * @author sebas
 */
public class Leer_csv {
    
    Investigador investigador_temp = new Investigador();
    
    private BufferedReader lector;
    private String linea;
    private String partes[] = null;
    
    public void leer_archivoInvestigadores(String csv){
        try {
            lector = new BufferedReader(new FileReader(csv));
            while ((linea = lector.readLine()) != null) {
                
                partes = linea.split(",");
                char genero = partes[2].charAt(0);
                
                if(Escribir_investigador.comparar_codigo(partes[0]) == true){
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al ingresar al investigador " + partes[1]  + " porque el código ya existe en el sistema", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(genero != 'M' && genero != 'm' && genero != 'F' && genero != 'f' ){
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al ingresar al investigador " + partes[1]  + " porque el género no es válido", "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println(partes[2]);
                }
                else{
                    investigador_temp.setCodigo(partes[0]);
                    investigador_temp.setNombre(partes[1]);
                    investigador_temp.setGenero(Character.toUpperCase(partes[2].charAt(0))); 
                    investigador_temp.setNumExperimentos(Integer.parseInt(partes[3]));
                    investigador_temp.setContrasenia(partes[4]);
                    Escribir_investigador.investigadores.add(investigador_temp);
                    Actualizar_Tabla.nuevo_elemento(Administrador.dtm1, Escribir_investigador.investigadores);
                    investigador_temp = new Investigador();   
                }
                genero = '\u0000'; 
            }
            
            Escribir_InvestigadorBinario.escribir_investigadorbin();
            lector.close();
            linea = null;
            partes = null;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
    
