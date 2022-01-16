package GUI;

import BLL.DonoBLL;
import BLL.DonoEmpresa;
import BLL.UserBLL;
import BLL.Utilizadores;

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

            if (!(textField1.getText().equals(""))){
                if (!(textField2.getText().equals(""))) {
                    if (!(textField3.getText().equals(""))){
                        if (!(textField4.getText().equals(""))) {
                            if (!(textField5.getText().equals(""))) {
                                if (!(String.valueOf(passwordField1.getText()).equals(""))) {
                                    DonoEmpresa dono = new DonoEmpresa();
                                    dono.setNomeDono(textField1.getText());
                                    dono.setNIFDono(textField2.getText());
                                    dono.setnTelefoneDono(textField3.getText());
                                    dono.setMoradaDono(textField4.getText());
                                    dono.setUsernameDono(textField5.getText());
                                    dono.setPasswordDono(String.valueOf(passwordField1.getPassword()));
                                    DonoBLL.criarDonoEmpresa(dono);
                                    label.setText("DONO DE EMPRESA CRIADO COM SUCESSO!");
                                } else {
                                    label.setText("HÁ ESPAÇOS EM BRANCO!");
                                }
                            } else {
                                label.setText("HÁ ESPAÇOS EM BRANCO!");
                            }
                        }else{
                            label.setText("HÁ ESPAÇOS EM BRANCO!");
                        }
                    }else{
                        label.setText("HÁ ESPAÇOS EM BRANCO!");
                    }
                }else{
                    label.setText("HÁ ESPAÇOS EM BRANCO!");
                }
            }else{
                label.setText("HÁ ESPAÇOS EM BRANCO!");
            }
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
