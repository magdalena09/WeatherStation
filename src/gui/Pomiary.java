package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pomiary extends JFrame{
    JPanel panel1;
    JPanel panel2;
    SecondTable tabela;
    JLabel napis1;
    JLabel napis2;
    JLabel napis3;
    JLabel napis4;
    JLabel napis5;
    JTextField tekst1;
    JTextField tekst2;
    JTextField tekst3;
    JTextField tekst4;
    JTextField tekst5;
    JButton przycisk;

    Pomiary(){
        panel1 = new JPanel();
        panel2 = new JPanel();
        tabela = new SecondTable();
        napis1 = new JLabel("ID");
        napis2 = new JLabel("Ciśnienie");
        napis3 = new JLabel("Wilgotność");
        napis4 = new JLabel("Temperatura");
        napis5 = new JLabel("Data");
        tekst1 = new JTextField();
        tekst2 = new JTextField();
        tekst3 = new JTextField();
        tekst4 = new JTextField();
        tekst5 = new JTextField();
        przycisk = new JButton("Dodaj");
        przycisk.addActionListener(new przyciskListener());

        setTitle("Pomiary");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        getContentPane().setBackground(Color.white);


        setLayout(new BorderLayout());
        getContentPane().add(BorderLayout.WEST, panel1);
        getContentPane().add(BorderLayout.EAST, panel2);

        panel1.setBackground(Color.white);
        panel2.setBackground(Color.white);

        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.add(new Box.Filler(new Dimension(300, 100), new Dimension(300, 100), new Dimension(300, 100)));

        tekst1.setMinimumSize(new Dimension(100, 25));
        tekst1.setPreferredSize(new Dimension(100, 25));
        tekst1.setMaximumSize(new Dimension(100, 25));
        tekst2.setMinimumSize(new Dimension(100, 25));
        tekst2.setPreferredSize(new Dimension(100, 25));
        tekst2.setMaximumSize(new Dimension(100, 25));
        tekst3.setMinimumSize(new Dimension(100, 25));
        tekst3.setPreferredSize(new Dimension(100, 25));
        tekst3.setMaximumSize(new Dimension(100, 25));
        tekst4.setMinimumSize(new Dimension(100, 25));
        tekst4.setPreferredSize(new Dimension(100, 25));
        tekst4.setMaximumSize(new Dimension(100, 25));
        tekst5.setMinimumSize(new Dimension(100, 25));
        tekst5.setPreferredSize(new Dimension(100, 25));
        tekst5.setMaximumSize(new Dimension(100, 25));

        napis1.setAlignmentX(Component.CENTER_ALIGNMENT);
        napis2.setAlignmentX(Component.CENTER_ALIGNMENT);
        napis3.setAlignmentX(Component.CENTER_ALIGNMENT);
        napis4.setAlignmentX(Component.CENTER_ALIGNMENT);
        napis5.setAlignmentX(Component.CENTER_ALIGNMENT);
        przycisk.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel1.add(tabela);

        panel2.add(napis1);
        panel2.add(tekst1);
        panel2.add(napis2);
        panel2.add(tekst2);
        panel2.add(napis3);
        panel2.add(tekst3);
        panel2.add(napis4);
        panel2.add(tekst4);
        panel2.add(napis5);
        panel2.add(tekst5);
        panel2.add(przycisk);

    }
    class przyciskListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (tekst1.getText().equals("") || tekst2.getText().equals("") || tekst3.getText().equals("") || tekst4.getText().equals("") || tekst5.getText().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Brak danych.");
            } else {
                ((TableModel)(tabela.getTable2().getModel())).add(new Data2(tekst1.getText(),tekst2.getText(),tekst3.getText(),tekst4.getText(),tekst5.getText()));
                SecondTable.getData2().add(new Data2(tekst1.getText(),tekst2.getText(),tekst3.getText(),tekst4.getText(),tekst5.getText()));
                tekst1.setText("");
                tekst2.setText("");
                tekst3.setText("");
                tekst4.setText("");
                tekst5.setText("");
            }
        }
    }
}

