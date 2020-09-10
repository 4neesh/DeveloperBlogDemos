import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class CustomRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        JTextField editor = new JTextField();


        if(row %2 ==0){
            editor.setBackground(Color.gray);
            editor.setForeground(Color.BLACK);
        }


        return editor;
    }
}
