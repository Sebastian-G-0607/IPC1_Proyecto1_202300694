/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author sebas
 */
public class Escribir_investigador {
    
    public static List<Investigador> investigadores = new ArrayList<Investigador> ();
    
    public void registrar_investigador(String codigo, String nombre, char genero, int numExperimentos, Muestras muestra_asignada){
        investigadores.add(new Investigador(codigo, nombre, genero, numExperimentos, muestra_asignada));
    }
      
}
