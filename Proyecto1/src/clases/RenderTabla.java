package clases;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author sebas
 */

//Clase para poder crear tablas con botones
public class RenderTabla extends DefaultTableCellRenderer{
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if(value instanceof JButton){
            JButton boton = (JButton)value;
            return boton;
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
    }
    
}
