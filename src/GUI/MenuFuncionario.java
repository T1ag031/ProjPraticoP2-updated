package GUI;

import BLL.Consulta;
import BLL.Repositorio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFuncionario extends JFrame implements ActionListener {
    private JPanel panel1;
    private JButton confirmarAnularConsultaButton;
    private JButton listarConsultasButton;
    private JButton adicionarProdutosServiçosButton;
    private JButton terminarSessãoButton;
    private JFrame frame2;

    public MenuFuncionario(){
        frame2=new JFrame("CLIENTE");
        frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame2.setPreferredSize(new Dimension(500, 500));
        frame2.setResizable(true);
        frame2.add(panel1);
        frame2.pack();
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
        confirmarAnularConsultaButton.addActionListener(this);
        listarConsultasButton.addActionListener(this);
        adicionarProdutosServiçosButton.addActionListener(this);
        terminarSessãoButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==terminarSessãoButton){
            frame2.dispose();
            new LogInFuncionario();
        }
        if (e.getSource()==confirmarAnularConsultaButton){

        }
    }
}

