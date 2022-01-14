package GUI;

import BLL.Consulta;
import BLL.ConsultaBLL;
import BLL.Estado;
import BLL.Repositorio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterarEstadoConsulta extends JFrame implements ActionListener {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton alterarButton;
    private JButton limparButton;
    private JButton voltarButton;
    private JLabel label;
    private JCheckBox confirmarCheckBox;
    private JCheckBox anularCheckBox;
    private JCheckBox concluirCheckBox;
    private JLabel labelestado;
    private JButton mostrarButton;
    private JFrame frame;

    public AlterarEstadoConsulta(){
        frame= new JFrame("ALTERAR ESTADO CONSULTA");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setResizable(true);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        alterarButton.addActionListener(this);
        limparButton.addActionListener(this);
        voltarButton.addActionListener(this);
        mostrarButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==limparButton){
            textField1.setText("");
            labelestado.setText("");
        }
        if (e.getSource()==voltarButton){
            frame.dispose();
            new MenuDono();
        }
        if (e.getSource()==mostrarButton){
            int n = Integer.parseInt(textField1.getText());
            for (Consulta consulta : Repositorio.getRepositorio().getConsultas().values()){
                if (n == consulta.getnConsulta()){
                    labelestado.setText("Estado Atual: " + consulta.getEstado());
                }
            }
        }
        if (e.getSource()==alterarButton){
            int n = Integer.parseInt(textField1.getText());
            for (Consulta consulta : Repositorio.getRepositorio().getConsultas().values()){
                if (n == consulta.getnConsulta()){
                    if (confirmarCheckBox.isSelected()){
                        consulta.setEstado(Estado.CONFIRMADA);
                    }
                    if (anularCheckBox.isSelected()){
                        consulta.setEstado(Estado.ANULADA);
                    }
                    if (concluirCheckBox.isSelected()){
                        consulta.setEstado(Estado.CONCLUIDA);
                    }
                }
            }
        }
    }
}