package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Main {
    JButton przycisk1;
    JFrame ramka;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JTextField tekst1;
    JTextField tekst2;
    JLabel napis1;
    JLabel napis2;
    FirstTable dataPanel;
    SecondTable tabela;
    JComboBox lista;
    Pomiary pomiary;
    Wykresy wykresy;

    String[] wyborDzialania = {"Dodaj stacje", "Wprowadz pomiar", "Wykresy"};

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main gui = new Main();
                    gui.doDziela();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void doDziela() {
        ramka = new JFrame();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        tekst1 = new JTextField();
        tekst2 = new JTextField();
        napis1 = new JLabel("ID");
        napis2 = new JLabel("Nazwa");
        dataPanel = new FirstTable();
        tabela = new SecondTable();
        pomiary = new Pomiary();
        pomiary.setVisible(false);
        wykresy = new Wykresy();
        wykresy.setVisible(false);


        ramka.setTitle("Stacje pogodowe");
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.getContentPane().setBackground(Color.white);

        panel1.setBackground(Color.white);
        panel2.setBackground(Color.white);
        panel3.setBackground(Color.white);

        przycisk1 = new JButton("Dodaj");
        przycisk1.addActionListener(new przycisk2Listener());

        ramka.setLayout(new BorderLayout());
        ramka.getContentPane().add(BorderLayout.WEST, panel1);
        ramka.getContentPane().add(BorderLayout.EAST, panel2);
        ramka.getContentPane().add(BorderLayout.NORTH, panel3);

        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.add(new Box.Filler(new Dimension(300, 100), new Dimension(300, 100), new Dimension(300, 100)));

        tekst1.setMinimumSize(new Dimension(100, 25));
        tekst1.setPreferredSize(new Dimension(100, 25));
        tekst1.setMaximumSize(new Dimension(100, 25));
        tekst2.setMinimumSize(new Dimension(100, 25));
        tekst2.setPreferredSize(new Dimension(100, 25));
        tekst2.setMaximumSize(new Dimension(100, 25));

        panel2.add(napis1);
        panel2.add(tekst1);
        panel2.add(napis2);
        panel2.add(tekst2);
        panel2.add(przycisk1);

        przycisk1.setAlignmentX(Component.CENTER_ALIGNMENT);
        napis1.setAlignmentX(Component.CENTER_ALIGNMENT);
        napis2.setAlignmentX(Component.CENTER_ALIGNMENT);

        lista = new JComboBox(wyborDzialania);
        lista.addItemListener(new jcomboboxListener());

        panel3.add(lista);
        panel1.add(dataPanel);

        ramka.setSize(600, 400);
        ramka.setVisible(true);
    }


    class przycisk2Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (tekst1.getText().equals("") || tekst2.getText().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Brak danych.");
            } else {
                int k = 0;
                for (int i = 0; i < dataPanel.getTable().getModel().getRowCount(); i++) {
                    String first = (String)(dataPanel.getTable().getValueAt(i,0));
                    String second = tekst1.getText();
                    if (first.equals(second)) {
                        k+=1;
                    }
                }
                if (k == 0)
                    ((MyTable) (dataPanel.getTable().getModel())).add(new Data1(tekst1.getText(), tekst2.getText()));
                else
                    JOptionPane.showMessageDialog(new JFrame(), "Zły indeks.");
            }
            tekst1.setText("");
            tekst2.setText("");
        }
    }

/*
    class przycisk3Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            int selectedRow = FirstTable.table.getSelectedRow();
            dataPanel.removeRow(selectedRow);
            ((MyTable) (dataPanel.getTable().getModel())).fireTableDataChanged();

            int id = Integer.parseInt((String)dataPanel.getTable().getModel().getValueAt(selectedRow,0)) - 1;
            int value;
            for(int i = 0; i < tabela.getTable2().getModel().getRowCount(); i++){
                value = Integer.parseInt((String)(tabela.getTable2().getModel().getValueAt(i,0))); //
                //SecondTable.data2.toString();
                System.out.println(value);
                if(id == value){
                    tabela.removeRow2(i);
                }
            }
            ((TableModel)(tabela.getTable2().getModel())).fireTableDataChanged();
        }
    }*/

    class jcomboboxListener implements ItemListener {
        public void itemStateChanged(ItemEvent e){
            String item = (String)(lista.getSelectedItem());
            if (item.equals(wyborDzialania[1])){
                pomiary.setVisible(true);
                pomiary.setSize(800, 600);
                lista.setSelectedItem(wyborDzialania[0]);
            } else if (item.equals(wyborDzialania[2])){
                wykresy.setVisible(true);
                wykresy.setSize(300,500);
                lista.setSelectedItem(wyborDzialania[0]);
            }
        }
    }
}
