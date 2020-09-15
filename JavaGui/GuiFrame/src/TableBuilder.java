import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TableBuilder {

    private static JTable table;

    public static JTable buildTable(){

        String[][] data = {
                {"1","Leeds United","28","9","9","93"},
                {"2","West Bromwich Albion","22","17","7","83"},
                {"3","Brentford","24","9","13","81"},
                {"4","Fulham","23","12","11","81"},
                {"5","Cardiff City","19","16","11","73"},
                {"6","Swansea City","18","16","12","70"},
                {"7","Nottingham Forest","18","16","12","70"},
                {"8","Millwall","17","17","12","68"},
                {"9","Preston North End","18","12","16","66"},
                {"10","Derby County","17","13","16","64"},
                {"11","Blackburn Rovers","17","12","17","63"},
                {"12","Bristol City","17","12","17","63"},
                {"13","Queens Park Rangers","16","10","20","58"},
                {"14","Reading","15","11","20","56"},
                {"15","Stoke City","16","8","22","56"},
                {"16","Sheffield Wednesday","15","11","20","56"},
                {"17","Middlesbrough","13","14","19","53"},
                {"18","Huddersfield Town","13","12","21","51"},
                {"19","Luton Town","14","9","23","51"},
                {"20","Birmingham City","12","14","20","50"},
                {"21","Barnsley","12","13","21","49"},
                {"22","Charlton Athletic","12","12","22","48"},
                {"23","Wigan Athletic","15","14","17","47"},
                {"24","Hull City","12","9","25","45"}
        };
        String[] columns = {"Pos", "Team", "Won", "Drawn", "Lost", "Points"};

        DefaultTableModel model = new DefaultTableModel(data, columns);

        table = new JTable(model);
        return table;
    }


}
