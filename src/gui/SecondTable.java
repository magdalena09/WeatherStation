package gui;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class Data2 {
    @Override
    public String toString() {
        //return "Data2 [ID="+ id + "cisnienie" + cisnienie + ", wilg=" + wilgotnosc+",temperatura="+temp+ "data" + date +"]";
        return id;
    }
    public String id;
    public String cisnienie;
    public String wilgotnosc;
    public String temp;
    public String date;

    public Data2(String id, String cisnienie, String wilgotnosc, String temp, String date) {
        this.id = id;
        this.cisnienie = cisnienie;
        this.wilgotnosc = wilgotnosc;
        this.temp = temp;
        this.date = date;
    }
    public String getId(){
        return this.id;
    }
}
class TableModel extends AbstractTableModel {
    public List<Data2> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data2> dataList) {
        this.dataList = dataList;
    }

    public void add(Data2 data2){
        this.dataList.add(data2);
        this.fireTableRowsInserted(dataList.size()-1, dataList.size());
    }

    public TableModel(List<Data2> dataList) {
        this.dataList = dataList;
    }
    private static final long serialVersionUID = 1L;
    private String[] columnNames = {"ID","Wilgotnosc %","Ciśnienie hPa","Temperatura C","Data"};
    private List<Data2> dataList = new ArrayList<>();



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
        if (col == 1) return dataList.get(row).wilgotnosc;
        if (col == 2) return dataList.get(row).cisnienie;
        if (col == 3) return dataList.get(row).temp;
        if (col == 4) return dataList.get(row).date;
        return null;
    }

    public Class<?> getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col) {
        return true;
    }

    public void setValueAt(Object value, int row, int col) {
        if (col == 0) dataList.get(row).id = FirstTable.data.get(row).id;
        if (col == 1) dataList.get(row).wilgotnosc = (String) value;
        if (col == 2) dataList.get(row).cisnienie = (String) value;
        if (col == 3) dataList.get(row).temp = (String) value;
        if (col == 4) dataList.get(row).date = (String) value;
        fireTableCellUpdated(row, col);
    }
}

public class SecondTable extends JPanel {
    public JTable getTable2() {
        return table2;
    }

    private static final long serialVersionUID = 1L;
    private JTable table2;

    public static List<Data2> getData2() {
        return data2;
    }

    public static List<Data2> data2;

    public SecondTable() {
        setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.EAST);


        data2 = new ArrayList<>();
        data2.add(new Data2((String)FirstTable.table.getValueAt(0,0),"1003","3", "12","1"));
        data2.add(new Data2((String)FirstTable.table.getValueAt(0,0),"1002","5", "15","2"));
        data2.add(new Data2((String)FirstTable.table.getValueAt(0,0),"1000","9", "16","3"));
        data2.add(new Data2((String)FirstTable.table.getValueAt(1,0),"1002","4","15","1"));
        data2.add(new Data2((String)FirstTable.table.getValueAt(1,0),"999","8","14","2"));
        data2.add(new Data2((String)FirstTable.table.getValueAt(1,0),"1000","12","13","3"));
        data2.add(new Data2((String)FirstTable.table.getValueAt(2,0),"1005","6","12","1"));
        data2.add(new Data2((String)FirstTable.table.getValueAt(2,0),"1010","10","13","2"));
        data2.add(new Data2((String)FirstTable.table.getValueAt(2,0),"1006","8","16","3"));
        data2.add(new Data2((String)FirstTable.table.getValueAt(3,0),"1002","2","12","1"));
        data2.add(new Data2((String)FirstTable.table.getValueAt(3,0),"1008","5","15","2"));
        data2.add(new Data2((String)FirstTable.table.getValueAt(3,0),"1009","9","18","3"));
        data2.add(new Data2((String)FirstTable.table.getValueAt(4,0),"1003","3", "12","1"));
        data2.add(new Data2((String)FirstTable.table.getValueAt(4,0),"1002","5", "15","2"));
        data2.add(new Data2((String)FirstTable.table.getValueAt(4,0),"1000","9", "16","3"));
        data2.add(new Data2((String)FirstTable.table.getValueAt(5,0),"1002","4","15","1"));
        data2.add(new Data2((String)FirstTable.table.getValueAt(5,0),"999","8","14","2"));
        data2.add(new Data2((String)FirstTable.table.getValueAt(5,0),"1000","12","13","3"));
        data2.add(new Data2((String)FirstTable.table.getValueAt(6,0),"1005","6","12","1"));
        data2.add(new Data2((String)FirstTable.table.getValueAt(6,0),"1010","10","13","2"));
        data2.add(new Data2((String)FirstTable.table.getValueAt(6,0),"1006","8","16","3"));
        data2.add(new Data2((String)FirstTable.table.getValueAt(7,0),"1002","2","12","1"));
        data2.add(new Data2((String)FirstTable.table.getValueAt(7,0),"1008","5","15","2"));
        data2.add(new Data2((String)FirstTable.table.getValueAt(7,0),"1009","9","18","3"));
        table2 = new JTable();
        table2.setModel(new TableModel(data2));
        scrollPane.setViewportView(table2);

    }
    void removeRow2(int row){
        data2.remove(row);
    }

}
