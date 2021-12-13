package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Wykresy extends JFrame{
    JPanel panel;
    JLabel napis1;
    JLabel napis2;
    JTextField tekst1;
    JRadioButton cisnienie;
    JRadioButton wilgotnosc;
    JRadioButton temperatura;
    JButton klik;
    SecondTable tabela;
    ButtonGroup group;

    Wykresy(){
        panel = new JPanel();
        napis1 = new JLabel("Wpisz ID");
        napis2 = new JLabel("Wybierz pomiar");
        tekst1 = new JTextField();
        cisnienie = new JRadioButton("ciśnienie");
        wilgotnosc = new JRadioButton("wilgotność");
        temperatura = new JRadioButton("temperatura");
        klik = new JButton("Utwórz wykres");
        tabela = new SecondTable();

        setTitle("Wykresy");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.white);
        cisnienie.setBackground(Color.white);
        wilgotnosc.setBackground(Color.white);
        temperatura.setBackground(Color.white);
        napis1.setAlignmentX(Component.CENTER_ALIGNMENT);
        napis2.setAlignmentX(Component.CENTER_ALIGNMENT);
        tekst1.setAlignmentX(Component.CENTER_ALIGNMENT);
        cisnienie.setAlignmentX(Component.CENTER_ALIGNMENT);
        wilgotnosc.setAlignmentX(Component.CENTER_ALIGNMENT);
        temperatura.setAlignmentX(Component.CENTER_ALIGNMENT);
        klik.setAlignmentX(Component.CENTER_ALIGNMENT);

        tekst1.setMinimumSize(new Dimension(100, 25));
        tekst1.setPreferredSize(new Dimension(100, 25));
        tekst1.setMaximumSize(new Dimension(100, 25));

        group = new ButtonGroup();
        group.add(cisnienie);
        group.add(wilgotnosc);
        group.add(temperatura);

        panel.add(napis1);
        panel.add(tekst1);
        panel.add(napis2);
        panel.add(cisnienie);
        panel.add(wilgotnosc);
        panel.add(temperatura);
        panel.add(klik);

        cisnienie.setSelected(true);

        klik.addActionListener(new wykresListener());
    }

    class wykresListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Chart panel = new Chart();
            String id = tekst1.getText();
            String nazwa = "";
            int k = 0;
            for (int i = 0; i < tabela.getTable2().getModel().getRowCount(); i++) {
                String first = (String)(tabela.getTable2().getValueAt(i,0));
                if (first.equals(id)) {
                    k+=1;
                }
            }
            if (id.equals("")){
                JOptionPane.showMessageDialog(new JFrame(), "Brak danych.");
            } else if(k == 0){
                JOptionPane.showMessageDialog(new JFrame(), "Zły indeks.");
            }else {
                if(cisnienie.isSelected()){
                    nazwa = "ciśnienia.";
                    for (int i = 0; i < tabela.getTable2().getModel().getRowCount(); i++) {
                        String first = (String)(tabela.getTable2().getValueAt(i,0));
                        if (first.equals(id)) {
                            panel.addHistogramColumn(tabela.getTable2().getValueAt(i,4).toString(),tabela.getTable2().getValueAt(i,2) , Color.RED);
                        }
                    }
                }
                if (wilgotnosc.isSelected()){
                    nazwa = "wilgotności.";
                    for (int i = 0; i < tabela.getTable2().getModel().getRowCount(); i++) {
                        String first = (String)(tabela.getTable2().getValueAt(i,0));
                        if (first.equals(id)) {
                            panel.addHistogramColumn(tabela.getTable2().getValueAt(i,4).toString(),tabela.getTable2().getValueAt(i,1) , Color.YELLOW);
                        }
                    }
                }
                if (temperatura.isSelected()){
                    nazwa = "temperatury.";
                    for (int i = 0; i < tabela.getTable2().getModel().getRowCount(); i++) {
                        String first = (String)(tabela.getTable2().getValueAt(i,0));
                        if (first.equals(id)) {
                            panel.addHistogramColumn(tabela.getTable2().getValueAt(i,4).toString(),tabela.getTable2().getValueAt(i,3) , Color.GREEN);
                        }
                    }
                }
                panel.layoutHistogram();
                JFrame frame = new JFrame("Wykres " + nazwa);
                frame.add(panel);
                frame.pack();
                frame.setVisible( true );
            }
        }
    }
}
