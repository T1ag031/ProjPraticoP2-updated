package GUI;

import BLL.DonoBLL;
import BLL.DonoEmpresa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistarDono extends JFrame implements ActionListener {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JPasswordField passwordField1;
    private JButton voltarButton;
    private JButton registarButton;
    private JButton limparButton;
    private JLabel label;
    private JFrame frame1;

    public RegistarDono(){
        frame1=new JFrame("REGISTAR");
        frame1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame1.setResizable(true);
        frame1.setPreferredSize(new Dimension(500, 500));
        frame1.add(panel1);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
        voltarButton.addActionListener(this);
        registarButton.addActionListener(this);
        limparButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==registarButton){
            String nome1 = textField1.getText();
            String nif1 = textField2.getText();
            String ntel1 = textField3.getText();
            String morada1= textField4.getText();
            String usern1 = textField5.getText();
            String pass1 = String.valueOf(passwordField1.getPassword());

            DonoEmpresa dono = new DonoEmpresa();

            dono.setNomeDono(nome1);
            dono.setNIFDono(nif1);
            dono.setnTelefoneDono(ntel1);
            dono.setMoradaDono(morada1);
            dono.setUsernameDono(usern1);
            dono.setPasswordDono(pass1);

            DonoBLL.criarDonoEmpresa(dono);

            label.setText("DONO DE EMPRESA CRIADO COM SUCESSO!");

    }
        if (e.getSource()==voltarButton){
            frame1.dispose();
            new EscolhaInicial();
        }
        if (e.getSource()==limparButton){
            textField1.setText("");
            textField2.setText("");
            textField4.setText("");
            textField5.setText("");
            textField3.setText("");
            passwordField1.setText("");
        }

    }
}
