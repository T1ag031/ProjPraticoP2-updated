package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscolhaInicial extends JFrame implements ActionListener {
    private JPanel panel1;
    private JButton RegiCli;
    private JButton iniDono;
    private JButton registarDonoEmpresaButton;
    private JButton iniciarSessãoClienteButton;
    private JButton sairButton;
    private JButton logInFuncionarioButton;
    private JButton adminButton;
    private JFrame frame;
    public EscolhaInicial(){
        frame= new JFrame("PetBeauty");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setResizable(true);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        RegiCli.addActionListener(this);
        iniDono.addActionListener(this);
        registarDonoEmpresaButton.addActionListener(this);
        iniciarSessãoClienteButton.addActionListener(this);
        sairButton.addActionListener(this);
        logInFuncionarioButton.addActionListener(this);
        adminButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== RegiCli){
            frame.dispose();
            new Registar();
        }
        if (e.getSource()== iniDono){
            frame.dispose();
            new LogInDono();
        }
        if (e.getSource()==registarDonoEmpresaButton){
            frame.dispose();
             new RegistarDono();
        }
        if (e.getSource()==iniciarSessãoClienteButton){
            frame.dispose();
            new LogIn();
        }
        if (e.getSource()==sairButton){
            frame.dispose();
            new PaginaInicial();
        }
        if (e.getSource()==adminButton){
            frame.dispose();
            new LogIn();
        }
        if (e.getSource()==logInFuncionarioButton){
            frame.dispose();
            new LogInFuncionario();
        }
    }
}