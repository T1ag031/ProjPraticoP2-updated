package GUI;

import BLL.FuncionarioBLL;
import BLL.Funcionario;

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
    private JButton registarButton;
    private JButton limparButton;
    private JButton voltarButton;
    private JPasswordField passwordField1;
    private JLabel label;
    private JFrame frame;

    public RegistarFuncionario(){
        frame=new JFrame("REGISTAR");
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
            new MenuDono();
        }
        if (e.getSource()==limparButton){
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
            textField4.setText("");
            textField5.setText("");
            passwordField1.setText("");
        }
        if (e.getSource()==registarButton){


            if (!(textField1.getText().equals(""))){
                if (!(textField2.getText().equals(""))) {
                    if (!(textField3.getText().equals(""))){
                        if (!(textField4.getText().equals(""))) {
                            if (!(textField5.getText().equals(""))) {
                                if (!(String.valueOf(passwordField1.getText()).equals(""))) {
                                    Funcionario funcionario = new Funcionario();
                                    funcionario.setnTelefoneFun(textField3.getText());
                                    funcionario.setNomeFun(textField1.getText());
                                    funcionario.setNIFFun(textField2.getText());
                                    funcionario.setMoradaFun(textField4.getText());
                                    funcionario.setUsernameFun(textField5.getText());
                                    funcionario.setPasswordFun(passwordField1.getText());
                                    FuncionarioBLL.criarFuncionario(funcionario);
                                    label.setText("FUNCIONÁRIO CRIADO COM SUCESSO!");
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
    }
}
