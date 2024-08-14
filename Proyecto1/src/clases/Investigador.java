/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.Serializable;

/**
 *
 * @author sebas
 */
public class Investigador implements Serializable{
    
    private String codigo;
    private String nombre;
    private char genero;
    private int numExperimentos;
    private Muestras muestra_asignada;
    private String contrasenia;
    
    public Investigador(){
        
    }
    
    public Investigador(String codigo, String nombre, char genero, int numExperimentos, Muestras muestra_asignada){
        this.codigo = codigo;
        this.nombre = nombre;
        this.genero = genero;
        this.numExperimentos = numExperimentos;
        this.muestra_asignada = muestra_asignada;
    }
    
    public Investigador(String codigo, String nombre, char genero, String contrasenia){
        this.codigo = codigo;
        this.nombre = nombre;
        this.genero = genero;
        this.contrasenia = contrasenia;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the genero
     */
    public char getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(char genero) {
        this.genero = genero;
        }

    /**
     * @return the numExperimentos
     */
    public int getNumExperimentos() {
        return numExperimentos;
    }

    /**
     * @param numExperimentos the numExperimentos to set
     */
    public void setNumExperimentos(int numExperimentos) {
        this.numExperimentos = numExperimentos;
    }

    /**
     * @return the muestra_asignada
     */
    public Muestras getMuestra_asignada() {
        return muestra_asignada;
    }

    /**
     * @param muestra_asignada the muestra_asignada to set
     */
    public void setMuestra_asignada(Muestras muestra_asignada) {
        this.muestra_asignada = muestra_asignada;
    }

    /**
     * @return the contrasenia
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * @param contrasenia the contrasenia to set
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    
    
}
