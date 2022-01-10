package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistarFuncionario extends JFrame implements ActionListener {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton registarButton;
    private JButton limparButton;
    private JButton voltarButton;
    private JPasswordField passwordField1;
    private JFrame frame;

    public RegistarFuncionario(){
        frame=new JFrame("REGISTAR FUNCIONÁRIO");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        voltarButton.addActionListener(this);
        registarButton.addActionListener(this);
        limparButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==voltarButton){
            frame.dispose();
            new EscolhaInicial();
        }
        if (e.getSource()==limparButton){
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
            textField4.setText("");
            textField5.setText("");
            textField6.setText("");
            passwordField1.setText("");
        }
    }
}
