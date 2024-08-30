package clases;

import java.io.Serializable;

/* @author sebas */
public class Muestra implements Serializable{

    //Atributos que tendrá un objeto de tipo Muestra
    private String codigo;
    private String descripcion;
    private int[][] patron;
    private String estado = "Ingreso"; //Los estados posibles son: "Ingreso", "En proceso" y "Procesado"
    
    //Constructor para una muestra

    //Método para obtener el código a una muestra
    public String getCodigo() {
        return codigo;
    }

    //Método para establecer el código de una muestra
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    //Método para obtener la descripción de una muestra
    public String getDescripcion() {
        return descripcion;
    }

    //Método setter para establecer la descripción de una muestra
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //Método getter para obtener el patrón de una muestra
    public int[][] getPatron() {
        return patron;
    }

    //Método setter para establecer el patrón de una muestra
    public void setPatron(int[][] patron) {
        this.patron = patron;
    }

    //Método getter para obtener el estado de una muestra
    public String getEstado() {
        return estado;
    }

    //Método setter para establecer el estado de una muestra
    public void setEstado(String estado) {
        this.estado = estado;
    }

}
