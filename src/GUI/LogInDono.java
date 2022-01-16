package GUI;

import BLL.*;
import BLL.DonoEmpresa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class LogInDono extends JFrame implements ActionListener {
    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton logInButton;
    private JButton limparButton;
    private JButton voltarButton;
    private JLabel label;
    private JFrame frame;

    public LogInDono(){
        frame = new JFrame("INICIAR SESSÃO");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setResizable(true);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        logInButton.addActionListener(this);
        limparButton.addActionListener(this);
        voltarButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==limparButton){
            textField1.setText("");
            passwordField1.setText("");
        }

        if (e.getSource()==logInButton){
            String pass = String.valueOf(passwordField1.getPassword());
            for (DonoEmpresa donoEmpresa : Repositorio.getRepositorio().getDonos().values()){
                if (donoEmpresa.getUsernameDono().equals(textField1.getText()) && donoEmpresa.getPasswordDono().equals(pass)){
                        frame.dispose();
                        new MenuDono();
                }else {
                    label.setText("\"USERNAME OU PASSWORD ERRADOS! TENTE NOVAMENTE\"");
                    textField1.setText("");
                    passwordField1.setText("");
                }
            }
        }

        if (e.getSource()==voltarButton){
            frame.dispose();
            new EscolhaInicial();
        }
    }
}