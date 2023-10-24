package MyStore;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private ArrayList<Produs> produse = new ArrayList<>();  //lista obiecte stocate
    private JList<Produs> produseList = new JList<>();     //lista obiecte afisate

    //Cream campuri de introducere a datelor
    JTextField numeField = new JTextField(10);
    JTextField pretField = new JTextField(10);
    JTextField stocField = new JTextField(10);
    JTextField vanzariField = new JTextField(10);

    public void initialize() {
        // Cream etichete pentru a indica câmpurile de introducere
        JLabel lab1 = new JLabel("Nume:");
        JLabel lab2 = new JLabel("Pret:");
        JLabel lab3 = new JLabel("Stoc:");
        JLabel lab4 = new JLabel("Vanzari:");

        // Cream un panou pentru inserarea datelor
        JPanel inserare = new JPanel();
        inserare.setLayout(new GridLayout(5,2,7,7));
        inserare.add(lab1);
        inserare.add(numeField);
        inserare.add(lab2);
        inserare.add(pretField);
        inserare.add(lab3);
        inserare.add(stocField);
        inserare.add(lab4);
        inserare.add(vanzariField);

        // Cream butonul "Adauga"
        JButton enter = new JButton("Adauga");
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n = numeField.getText();
                double p = Double.parseDouble(pretField.getText());
                double s = Double.parseDouble(stocField.getText());
                double v = Double.parseDouble(vanzariField.getText());

                if (n.isEmpty() || p == 0 || s == 0) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Eroare! Campuri goale.");
                    return;
                }

                try {
                    Produs afis;
                    if (v == 0) {
                        afis = new Produs(n, p, s);
                    } else {
                        afis = new Produs(n, p, s, v);
                    }
                    produse.add(afis);
                    afisareLista();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Valorile trebuie sa fie corecte.");
                }
            }
        });

        // Cream butonul "Clear"
        JButton clear = new JButton("Clear");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numeField.setText("");
                pretField.setText("");
                stocField.setText("");
                vanzariField.setText("");
                
                // Clear lista de produse
                produse.clear();
                
                afisareLista();
            }
        });

        // Cream un panou pentru butoane
        JPanel butoane = new JPanel();
        butoane.setLayout(new GridLayout(1, 2, 5, 5));
        butoane.add(enter);
        butoane.add(clear);

        // Cream panoul principal
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setLayout(new BorderLayout ());
        mainPanel.add(inserare, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(produseList), BorderLayout.CENTER);
        mainPanel.add(butoane, BorderLayout.SOUTH);

        // Adaugam panoul principal la fereastra
        add(mainPanel);

        // Setăm titlul, facem fereastra să se ajusteze la conținut și afișăm fereastra
        setTitle("Lista Produse");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //Realizam afisarea listei
    private void afisareLista() {
        produseList.setListData(produse.toArray(new Produs[0]));
    }

    public static void main(String[] args) {
        MainFrame myFrame = new MainFrame();
        myFrame.initialize();
    }
}