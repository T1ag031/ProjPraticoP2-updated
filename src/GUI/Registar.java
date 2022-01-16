package GUI;

import BLL.Funcionario;
import BLL.FuncionarioBLL;
import BLL.UserBLL;
import BLL.Utilizadores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registar extends JFrame implements ActionListener {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JPasswordField passwordField1;
    private JButton registarButton;
    private JButton voltarButton;
    private JButton limparButton;
    private JLabel label;
    private JFrame frame1;

    public Registar(){
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
                    if (!(textField6.getText().equals(""))){
                        if (!(textField4.getText().equals(""))) {
                            if (!(textField5.getText().equals(""))) {
                                if (!(String.valueOf(passwordField1.getText()).equals(""))) {
                                    Utilizadores user = new Utilizadores();
                                    user.setNome(textField1.getText());
                                    user.setNIF(textField2.getText());
                                    user.setnTelefone(textField4.getText());
                                    user.setMorada(textField5.getText());
                                    user.setUsername(textField6.getText());
                                    user.setPassword(String.valueOf(passwordField1.getText()));
                                    UserBLL.criarCliente(user);
                                    label.setText("CLIENTE CRIADO COM SUCESSO!");

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
            textField6.setText("");
            passwordField1.setText("");
        }
    }
}
