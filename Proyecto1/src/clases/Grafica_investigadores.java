package clases;

import interfaces.Administrador;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**

 @author sebas
 */
public class Grafica_investigadores {
    
    public void graficar(int no1, int no2, int no3, String nom1, String nom2, String nom3){
        
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        //Se agregan los datos del top 3
        datos.setValue(no1, "Número de experimentos", nom1);
        datos.setValue(no2, "Número de experimentos", nom2);
        datos.setValue(no3, "Número de experimentos", nom3);
        
        JFreeChart grafico_top = ChartFactory.createBarChart3D("Investigadores con más experimentos", "Investigadores", "No. de experimentos", datos, PlotOrientation.VERTICAL, true, true, false);
        
        ChartPanel panel = new ChartPanel(grafico_top);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(900, 200));
        
        Administrador.panel_grafica.setLayout(new BorderLayout());
        Administrador.panel_grafica.add(panel, BorderLayout.NORTH);
        
    }
    
}
