package clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import interfaces.Investigador;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**

 @author sebas
 */
public class Tabla_resultados {

    
    public void escribir_txtResultados(JTable tabla_resultados, int resultado, String path, int contadorDeAnalisis, String nombreMuestra, String nombrePatron){
        
        if(resultado == 1){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
                bw.write(String.valueOf(contadorDeAnalisis) + ",");
                bw.write(nombreMuestra + ",");
                bw.write(nombrePatron + ",");
                Date current = new Date();
                SimpleDateFormat formato = new SimpleDateFormat("dd-MM-YYYY");
                bw.write(formato.format(current) + ",");
                DateFormat format = new SimpleDateFormat("HH:mm:ss");
                Date fecha = new Date();
                bw.write(format.format(fecha) + ",");
                bw.write("Exitoso");
                bw.write("\n");
            } catch (Exception e) {
            }
        }
        else if(resultado == 0){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
                bw.write(String.valueOf(contadorDeAnalisis) + ",");
                bw.write(nombreMuestra + ",");
                bw.write(nombrePatron + ",");
                Date current = new Date();
                SimpleDateFormat formato = new SimpleDateFormat("dd-MM-YYYY");
                bw.write(formato.format(current) + ",");
                DateFormat format = new SimpleDateFormat("HH:mm:ss");
                Date fecha = new Date();
                bw.write(format.format(fecha) + ",");
                bw.write("Fallido");
                bw.write("\n");
            } catch (Exception e) {
            }
        }
        
    }
    
    public void leer_txtResultados(String path){
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String[] partes;
            String linea;
            while((linea = br.readLine()) != null && !linea.equals("\n")){
            partes = linea.split(",");
            agregar_resultado(Investigador.dtm_resultados, partes[0], partes[1], partes[2], partes[3], partes[4], partes[5], Investigador.ver);
        }
            
        } catch (Exception e) {
        }
    }
    
    public void agregar_resultado(DefaultTableModel dtm_resultados, String no, String muestra, String patron, String fecha, String hora, String resultado, JButton ver){
        dtm_resultados.addRow(new Object[]{no, muestra, patron, fecha, hora, resultado, ver});
    }
    
    public void crear_reporteDifLong(int[][] muestra, int[][] patron, String codigoAnalisis, String Muestra, String Patron){
        //Se crea una variable que almacena la fecha
        Date current = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("ddMMYYYY");

        //Se crea una variable que almacena la hora
        DateFormat format = new SimpleDateFormat("HHmmss");
        Date fecha = new Date();
        
        String path = "Analisis" + formato.format(current) + "-" + format.format(fecha) + "_" + codigoAnalisis + ".html";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
                    
                    writer.write("<!DOCTYPE html>\n");
                    writer.write("<html>\n");
                    writer.write("<head>\n");
                    writer.write("<title>" + "Muestra " + Muestra + " - Patrón " + Patron + "</title>\n");
                    writer.write("</head>\n");
                    writer.write("<body>\n");
                    writer.write("<h2>Comparación de la muestra " + Muestra + " con el patrón " + Patron + "</h2>\n");
                    writer.write("<h3>El tamaño de los patrones no coincide</h3>");
                    writer.write("<h4>Patrón de la muestra " + Muestra +"</h4>");
                    writer.write("<table border=\"1\">\n");

                    // Escribir filas y columnas del patrón de la muestra
                    for (int i = 0; i <muestra.length; i++) {
                        writer.write("<tr>\n");
                        for (int j = 0; j <muestra.length; j++) {
                            writer.write("<td>" + muestra[i][j] + "</td>\n");
                        }
                        writer.write("</tr>\n");
                    }
                    writer.write("</table>\n");
                    
                    writer.write("<h4>Patrón del patrón " + Patron +"</h4>");
                    
                    writer.write("<table border=\"1\">\n");
                    //Escribir filas y columnas del patrón del patrón
                    for (int i = 0; i <patron.length; i++) {
                        writer.write("<tr>\n");
                        for (int j = 0; j <patron.length; j++) {
                            writer.write("<td>" + patron[i][j] + "</td>\n");
                        }
                        writer.write("</tr>\n");
                    }
                    writer.write("</table>\n");

                    
                    writer.write("</body>\n");
                    writer.write("</html>\n");
                    
                    File html = new File(path);
                    Desktop.getDesktop().open(html);

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null,e);
                }
        
    }
    
    public void crear_reporte(int[][] muestra, int[][] patron, int[][] producto, int[][] modular, String codigoAnalisis, String Muestra, String Patron, int estado){
        //Se crea una variable que almacena la fecha
        Date current = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("ddMMYYYY");

        //Se crea una variable que almacena la hora
        DateFormat format = new SimpleDateFormat("HHmmss");
        Date fecha = new Date();
        
        String path = "Analisis" + formato.format(current) + "-" + format.format(fecha) + "_" + codigoAnalisis + ".html";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
                    
            writer.write("<!DOCTYPE html>\n");
            writer.write("<html>\n");
            writer.write("<head>\n");
            writer.write("<title>" + "Muestra " + Muestra + " - Patrón " + Patron + "</title>\n");
            writer.write("</head>\n");
            writer.write("<body>\n");
            writer.write("<h2>Comparación de la muestra " + Muestra + " con el patrón " + Patron + "</h2>\n");
            if(estado ==1){
                writer.write("<h3>Los patrones coinciden</h3>");
            }
            else if(estado == 0){
                writer.write("<h3>Los patrones no coinciden</h3>");
            }
      
            writer.write("<h4>Patrón de la muestra " + Muestra +"</h4>");
            writer.write("<table border=\"1\">\n");

            // Escribir filas y columnas del patrón de la muestra
            for (int i = 0; i <muestra.length; i++) {
                writer.write("<tr>\n");
                for (int j = 0; j <muestra.length; j++) {
                    writer.write("<td>" + muestra[i][j] + "</td>\n");
                }
                writer.write("</tr>\n");
            }
            writer.write("</table>\n");
            
            writer.write("<h4>El patrón de la muestra " + Muestra +" se multiplica por 3 y se guarda en una matriz temporal 1</h4>");
            writer.write("<table border=\"1\">\n");

            // Escribir filas y columnas de la matriz temporal 1
            for (int i = 0; i <muestra.length; i++) {
                writer.write("<tr>\n");
                for (int j = 0; j <muestra.length; j++) {
                    writer.write("<td>" + muestra[i][j]*3 + "</td>\n"); //Se escribe la matriz de la muestra multiplicada por 3
                }
                writer.write("</tr>\n");
            }
            writer.write("</table>\n");
            
            //Escribir la matriz temporal 2
            writer.write("<h4>El patrón de la muestra " + Muestra +" se multiplica por 7 y se guarda en una matriz temporal 2</h4>");
            writer.write("<table border=\"1\">\n");

            // Escribir filas y columnas de la matriz temporal 2
            for (int i = 0; i <muestra.length; i++) {
                writer.write("<tr>\n");
                for (int j = 0; j <muestra.length; j++) {
                    writer.write("<td>" + muestra[i][j]*7 + "</td>\n"); //Se escribe la matriz de la muestra multiplicada por 3
                }
                writer.write("</tr>\n");
            }
            writer.write("</table>\n");
            
            //Escribir filas y columnas del producto de las dos matrices temporales
            writer.write("<h4>Se multiplica la matriz temporal 1 por la matriz temporal 2 y se almacena en una matriz temporal 3</h4>");
            writer.write("<table border=\"1\">\n");

            // Escribir filas y columnas del producto de las dos matrices temporales
                for (int i = 0; i < producto.length; i++) {
                    for (int j = 0; j < producto.length; j++) {
                        writer.write("<td>" + producto[i][j] + "</td>\n");
                    }
                    writer.write("</tr>\n");
                }
            writer.write("</table>\n");
            
          //Escribir filas y columnas de la matriz temporal 3 MOD 2
            writer.write("<h4>A la matriz temporal se le aplica la división modular de 2 y se almacena el resultado en una Matriz 2</h4>");
            writer.write("<table border=\"1\">\n");

            // Escribir filas y columnas de la matriz temporal 3 MOD 2
                for (int i = 0; i < modular.length; i++) {
                    for (int j = 0; j < modular.length; j++) {
                            writer.write("<td>" + modular[i][j] + "</td>\n");                       
                    }
                    writer.write("</tr>\n");
                }
            writer.write("</table>\n");

            writer.write("<h4>Patrón del patrón " + Patron +"</h4>");

            writer.write("<table border=\"1\">\n");
            //Escribir filas y columnas del patrón del patrón
            for (int i = 0; i <patron.length; i++) {
                writer.write("<tr>\n");
                for (int j = 0; j <patron.length; j++) {
                    writer.write("<td>" + patron[i][j] + "</td>\n");
                }
                writer.write("</tr>\n");
            }
            writer.write("</table>\n");
            
            if(estado ==1){
                writer.write("<h2>Según el análisis, el patrón de la Matriz 2 sí coincide con el patrón " + Patron + "</h2>");
            }
            else if(estado == 0){
                writer.write("<h2>Según el análisis, el patrón de la Matriz 2 no coincide con el patrón " + Patron + "</h2>");
            }

            writer.write("</body>\n");
            writer.write("</html>\n");

            File html = new File(path);
            Desktop.getDesktop().open(html);

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,e);
            }
    }
    
}
