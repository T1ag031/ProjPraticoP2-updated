package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PesquisarEmpresa extends JFrame implements ActionListener {
    private JPanel panel1;
    private JButton procurarButton;
    private JButton limparButton;
    private JButton voltarButton;
    private JTextField textField1;
    private JLabel labellistar;
    private JFrame frame;

    public PesquisarEmpresa(){
        frame = new JFrame("PESQUISAR EMPRESA");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setResizable(true);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        procurarButton.addActionListener(this);
        limparButton.addActionListener(this);
        voltarButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==limparButton){
            textField1.setText("");
        }
        if (e.getSource()==voltarButton){
            frame.dispose();
            new MenuDono();
        }
        if (e.getSource()==procurarButton){
            /*String nif1 = textField1.getText();
            if (nif1.equals()){
                labellistar.setText();*/
            }
        }
    }
