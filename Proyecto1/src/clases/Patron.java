package clases;

import java.io.Serializable;

/**

 @author sebas
 */
public class Patron implements Serializable{
    
    private String codigo;
    private String nombre;
    private int[][] patron;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int[][] getPatron() {
        return patron;
    }

    public void setPatron(int[][] patron) {
        this.patron = patron;
    }
    
    
}
