package gui;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class Data1 {
    @Override
    public String toString() {
        //return "Data [ID=" + id + ", Nazwa stacji=" + nazwa+"]";
        return id;
    }
    public String id;
    public String nazwa;

    public Data1(String id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
    }
}
class MyTable extends AbstractTableModel {
    public List<Data1> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data1> dataList) {
        this.dataList = dataList;
    }

    public void add(Data1 data) {
        this.dataList.add(data);
        this.fireTableRowsInserted(dataList.size(), dataList.size());

    }
    public MyTable(List<Data1> dataList) {
        this.dataList = dataList;
    }
    private static final long serialVersionUID = 1L;
    private String[] columnNames = {"Identyfikator","Nazwa stacji"};
    private List<Data1> dataList;


    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return dataList.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        if (col == 0) return dataList.get(row).id;
        if (col == 1) return dataList.get(row).nazwa;
        return null;
    }

    public Class<?> getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        return true;
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    public void setValueAt(Object value, int row, int col) {
        if (col == 0) dataList.get(row).id = (String) value;
        if (col == 1) dataList.get(row).nazwa = (String) value;
        fireTableCellUpdated(row, col);
    }
}
public class FirstTable extends JPanel {
    public JTable getTable() {
        return table;
    }

    private static final long serialVersionUID = 1L;
    public static JTable table;
    public static List<Data1> data;

    public FirstTable() {
        setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.CENTER);

        data = new ArrayList<>();
        data.add(new Data1("1","Wrocław"));
        data.add(new Data1("2","Warszawa"));
        data.add(new Data1("3","Gdańsk"));
        data.add(new Data1("4","Zakopane"));
        data.add(new Data1("5","Lódź"));
        data.add(new Data1("6","Lublin"));
        data.add(new Data1("7","Szczecin"));
        data.add(new Data1("8","Kraków"));
        table = new JTable();
        table.setModel(new MyTable(data));
        scrollPane.setPreferredSize(new Dimension(200,200));
        scrollPane.setViewportView(table);


    }
    void removeRow(int row){
        int [] remover = new int[1];
        remover[0]=row;
        data.remove(row);
    }
}
