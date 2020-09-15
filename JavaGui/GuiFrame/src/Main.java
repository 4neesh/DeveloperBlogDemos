import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        Frame frame = Frame.getFrameInstance();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My frame");
        frame.setResizable(true);

        JTable table = new TableBuilder().buildTable();
        JScrollPane viewComponent = new JScrollPane(table);
        frame.add(viewComponent);
        table.setDefaultRenderer(Object.class, new TableCellRendererImpl());
        setColumnWidths(table);
        frame.pack();
    }

    private static void setColumnWidths(JTable table) {
        for (int column = 0; column < table.getColumnCount(); column++)
        {
            TableColumn tableColumn = table.getColumnModel().getColumn(column);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();

            for (int row = 0; row < table.getRowCount(); row++)
            {
                TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
                Component c = table.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);

                if (preferredWidth >= maxWidth)
                {
                    preferredWidth = maxWidth;
                    break;
                }
            }

            tableColumn.setPreferredWidth( preferredWidth );
        }
    }
}
