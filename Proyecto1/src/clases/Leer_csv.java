package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;
import interfaces.Administrador;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebas
 */
public class Leer_csv {
    
    //Se crea un investigador temporal para asignarle los valores del csv
    Investigador investigador_temp = new Investigador();
    
    private BufferedReader lector; //Objeto que lea el archivo
    private String linea; //String para saber si una flia del csv contiene texto
    private String partes[] = null; //vector tipo string para almacenar cada dato del csv en un espacio del vector
    
    //Método para leer un archivo csv que contiene investigadores
    public void leer_archivoInvestigadores(String csv){
        try {
            lector = new BufferedReader(new FileReader(csv));
            while ((linea = lector.readLine()) != null) {
                //Se coloca cada elemento de la fila en un espacio del vector partes
                partes = linea.split(",");
                char genero = partes[2].charAt(0);
                
                //Se valida si el código de un ivestigador ya existe
                if(Escribir_investigador.comparar_codigo(partes[0]) == true){
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al ingresar al investigador " + partes[1]  + " porque el código ya existe en el sistema", "Error", JOptionPane.ERROR_MESSAGE);
                }
                //Se valida que el género ingresado sea válido
                else if(genero != 'M' && genero != 'm' && genero != 'F' && genero != 'f' ){
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al ingresar al investigador " + partes[1]  + " porque el género no es válido", "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println(partes[2]);
                }
                //Si no se cumple ninguna condición anterior, los datos ingresados se almacenan en el sistema
                else{
                    try {
                        //Se agregan los datos al investigador temporal
                        investigador_temp.setCodigo(partes[0]);
                        investigador_temp.setNombre(partes[1]);
                        investigador_temp.setGenero(Character.toUpperCase(partes[2].charAt(0))); 
                        investigador_temp.setNumExperimentos(Integer.parseInt(partes[3]));
                        investigador_temp.setContrasenia(partes[4]);
                        //El investigador temporal se agrega a la lista de investigadores
                        Escribir_investigador.investigadores.add(investigador_temp);
                        //Se actualiza la tabla de investigadores
                        Actualizar_Tabla.nuevo_elemento(Administrador.dtm1, Escribir_investigador.investigadores);
                        //Se escribe nuevamente el JComboBox
                        Escribir_investigador.Escribir_investigadorCombo(Administrador.combo_investigador, Escribir_investigador.investigadores);
                        //Se limpia el objeto investigador_temp
                        investigador_temp = new Investigador();   
                    } catch (IndexOutOfBoundsException e) {
                        JOptionPane.showMessageDialog(null, "Ocurrió un error al ingresar uno de los investigadores porque no se completaron todos los campos");
                    }
                    
                }
                genero = '\u0000'; 
            }
            
            //Se escribe el nuevo ArrayList en el archivo binario
            Escribir_InvestigadorBinario.escribir_investigadorbin(); 
            lector.close();
            linea = null;
            partes = null;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //Método para cargar un patrón a una muestra que se va a crear
    public int [][] leer_patronNuevaMuestra(String csv){
       int [][] matriz = null; //Se crea una matriz que será la que retornará el método
       int longitud, contador = 0;
       List<Integer> patron = new ArrayList<> (); //lista dinámica para almacenar los números de la matriz del csv
       
       try {
            lector = new BufferedReader(new FileReader(csv));
            while ((linea = lector.readLine()) != null) { //Mientras que la fila no esté vacía, se ejecuta el siguiente bloque:
                
                partes = linea.split(","); //Se coloca cada entero en una parte del array partes
         
                for(int j=0; j<partes.length; j++){
                    patron.add(Integer.parseInt(partes[j])); //Se agrega cada dato al ArrayList patron
                }
            }
            try {
               longitud = (int) sqrt(patron.size()); //Se obtiene la raíz de la longitud del ArrayList, que se supone que proviene de una matriz cuadrada
                matriz = new int[longitud][longitud];
          
                for(int i = 0; i<longitud; i++){
                    for(int j = 0; j<longitud; j++){
                        matriz[i][j] = patron.get(contador); //Se agrega cada dato del ArrayList a la matriz
                        contador++;
                    }
                }
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null, e); //En caso de que la matriz no sea cuadrada se captura la excepcion
           }
            
            
            lector.close(); 
            linea = null;
            partes = null;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } 
        return matriz; //variable de retorno
    }

    public void leer_cargaMuestra(String csv, int estado){
        
        try {
            lector = new BufferedReader(new FileReader(csv));
            int fila = 1;
            while ((linea = lector.readLine()) != null) {
                
                //Se coloca cada elemento de la fila en un espacio del vector partes
                partes = linea.split(",");
                
                String[] matTemporal = partes[2].split(";"); //Se guarda cada número del patrón cargado a un vector tipo String
                int longitud = (int) sqrt(matTemporal.length);
                int[][] numerosTemporal = new int[longitud][longitud]; //Se crea un vector de tipo Entero para guardar cada dato pero como valor numerico entero
                
                int contador = 0; //Contador para recorrer el vector tipo String
                if(estado == 1){ //Si el parámetro de estado es 1, se trata de una carga de muestras
                    try {
                    for(int i=0; i<sqrt(matTemporal.length); i++){
                        for(int j=0; j<sqrt(matTemporal.length); j++){
                            numerosTemporal[i][j] = Integer.parseInt(matTemporal[contador]);
                            contador++;
                        }
                    }
                    
                    //Se valida si el código de alguna muestra ya existe
                    if(Escribir_muestra.comparar_codigo(partes[0]) == true){
                        JOptionPane.showMessageDialog(null, "Ocurrió un error al ingresar la muestra \"" + partes[1]  + "\" porque el código ya existe en el sistema", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    //Se valida que existan todos los campos
                    else if(partes[0].equals("") || partes[1].equals("") || partes[2].equals("")){
                        JOptionPane.showMessageDialog(null, "Ocurrió un error con la muestra de la fila " + fila + " porque no se completaron todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    //Si no se cumple ninguna condición anterior, los datos ingresados se almacenan en el sistema
                    else{
                        Muestra muestraTemp = new Muestra();
           
                        //Se asignan los valores a una muestra temporal, incluyendo la matriz definida en las lineas de arriba
                        muestraTemp.setCodigo(partes[0]);
                        muestraTemp.setDescripcion(partes[1]);
                        muestraTemp.setPatron(numerosTemporal);

                        Escribir_muestra.muestras.add(muestraTemp); //Se añade la muestra temporal al ArrayList
                        Actualizar_Tabla.nueva_muestra(Administrador.dtm_muestras, Escribir_muestra.muestras, Administrador.ver); //Se actualiza la tabla 
                        Escribir_muestra.Escribir_muestraCombo(Administrador.combo_muestra, Escribir_muestra.muestras);
                    }      
                } 
                catch (IndexOutOfBoundsException e){
                    JOptionPane.showMessageDialog(null, "La matriz de la muestra \"" + partes[0] + " - " + partes[1] + "\" no es cuadrada");
                }
                fila++;
                }
                else if(estado == 2){ //Si el parámetro estado es igual a 2, se trata de una carga de patrones
                    try {
                    for(int i=0; i<sqrt(matTemporal.length); i++){
                        for(int j=0; j<sqrt(matTemporal.length); j++){
                            numerosTemporal[i][j] = Integer.parseInt(matTemporal[contador]);
                            contador++;
                        }
                    }
                    
                    //Se valida si el código de alguna muestra ya existe
                    if(Escribir_patron.comparar_codigo(partes[0]) == true){
                        JOptionPane.showMessageDialog(null, "Ocurrió un error al ingresar el patrón \"" + partes[1]  + "\" porque el código ya existe en el sistema", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    //Se valida que existan todos los campos
                    else if(partes[0].equals("") || partes[1].equals("") || partes[2].equals("")){
                        JOptionPane.showMessageDialog(null, "Ocurrió un error con el patrón de la fila " + fila + " porque no se completaron todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    //Si no se cumple ninguna condición anterior, los datos ingresados se almacenan en el sistema
                    else{
                        Patron patronTemp = new Patron(); //Patron temporal

                        //Se asingan los valores a un patron temporal, incluyendo la matriz definida en las lineas de arriba
                        patronTemp.setCodigo(partes[0]);
                        patronTemp.setNombre(partes[1]);
                        patronTemp.setPatron(numerosTemporal);

                        Escribir_patron.patrones.add(patronTemp); //Se añade la muestra temporal al ArrayList
                        Actualizar_Tabla.nuevo_patron(Administrador.dtm_patrones, Escribir_patron.patrones, Administrador.ver); //Se actualiza la tabla   
                    }      
                } 
                catch (IndexOutOfBoundsException e){
                    JOptionPane.showMessageDialog(null, "La matriz de la muestra \"" + partes[0] + " - " + partes[1] + "\" no es cuadrada");
                }
                fila++;
                }
            }
            if(estado == 1){
                //Se escribe el nuevo ArrayList en el archivo binario
                Escribir_muestraBinaria.escribir_muestrabin(); 
            }
            else if(estado == 2){
                //Se escribe el nuevo ArrayList en el archivo binario
                Escribir_patronBinario.escribir_patronbin(); 
            }
            lector.close();
            linea = null;
            partes = null;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
    
