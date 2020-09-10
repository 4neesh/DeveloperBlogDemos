import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        Frame frame = Frame.getFrameInstance();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My frame");
        frame.setResizable(true);

        JTable table = new TableBuilder().buildTable();
//        table.setDefaultRenderer(Object.class, new CustomRenderer());
        frame.getContentPane().add(new JScrollPane(new TableBuilder().getTable()), BorderLayout.CENTER);
        frame.pack();
    }
}
