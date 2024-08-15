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
public class Leer_contrasenias {
    
    public static boolean leer_contrasenias(String user, String password, List<Investigador> investigador){
        boolean band = false;
        
        for(Investigador investigador_temp:investigador){
            if(user.equals(investigador_temp.getCodigo()) && password.equals(investigador_temp.getContrasenia())){
                band = true;
            }
        }
        
        return band;
    }
}
