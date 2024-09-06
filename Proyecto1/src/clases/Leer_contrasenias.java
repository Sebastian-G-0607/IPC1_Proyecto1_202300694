package clases;

import java.util.List;

/**
 *
 * @author sebas
 */
public class Leer_contrasenias {
    
    public static int leer_contrasenias(String user, String password, List<Investigador> investigador){
        
        int band = -1;
        
        for(Investigador investigador_temp:investigador){
            if(user.equals(investigador_temp.getCodigo()) && password.equals(investigador_temp.getContrasenia())){
                band = investigador.indexOf(investigador_temp);
            }
        }
        return band;
    }
}
