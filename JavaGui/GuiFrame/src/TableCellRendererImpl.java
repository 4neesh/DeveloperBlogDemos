import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TableCellRendererImpl implements TableCellRenderer {


    private TableCellRenderer RENDERER = new DefaultTableCellRenderer();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        Component editor = RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        editor.setBackground(Color.white);
        editor.setForeground(Color.black);

        if(row % 2  == 0){
            editor.setBackground(Color.lightGray);
        }
        boolean topOfLeague = table.getModel().getValueAt(row, 0).equals("1");
        String relegationZone = (String)table.getModel().getValueAt(row, 0);
        boolean relegated = Integer.parseInt(relegationZone) > 21 ? true : false;
        if(topOfLeague){
            editor.setForeground(Color.getHSBColor(17, 86, 146));
        }
        if(relegated){
            editor.setForeground(Color.red);
        }

        return editor;
    }
}
