package GUI;

import BLL.Repositorio;
import BLL.UserBLL;
import BLL.Utilizadores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class LogIn extends JFrame implements ActionListener {
    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton buttonlogin;
    private JLabel usernamelabel;
    private JLabel passlabel;
    private JButton limparButton;
    private JButton voltarButton;
    private JLabel label;
    private JFrame frame;


    public LogIn(){
        frame = new JFrame("INICIAR SESSÃO");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setResizable(true);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        buttonlogin.addActionListener(this);
        limparButton.addActionListener(this);
        voltarButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==limparButton){
            textField1.setText("");
            passwordField1.setText("");
        }
        if (e.getSource()==buttonlogin){

            String pass = String.valueOf(passwordField1.getPassword());

            for (Utilizadores cli : Repositorio.getRepositorio().getUsers().values()){
                if (cli.getUsername().equals(textField1.getText()) && cli.getPassword().equals(pass)){
                    new MenuCliente();
                }else {
                    label.setText("USERNAME OU PASSWORD ERRADOS! TENTE NOVAMENTE");
                }
            }
            if (textField1.getText().equals("admin") && passwordField1.getText().equals("admin")){
                frame.dispose();
                new MenuAdmin();
            }else {
                label.setText("USERNAME OU PASSWORD ERRADOS! TENTE NOVAMENTE");
                textField1.setText("");
                passwordField1.setText("");
            }
        }
        if (e.getSource()==voltarButton){
            frame.dispose();
           new EscolhaInicial();
        }
    }
}
