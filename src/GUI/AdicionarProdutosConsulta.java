package GUI;

import BLL.Consulta;
import BLL.Estado;
import BLL.Repositorio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarProdutosConsulta extends JFrame implements ActionListener {
    private JPanel panel1;
    private JCheckBox raioXCheckBox;
    private JCheckBox internamentoCheckBox;
    private JCheckBox banhoCheckBox;
    private JCheckBox comidaCheckBox;
    private JCheckBox injeçõesCheckBox;
    private JCheckBox cirurgiaCheckBox;
    private JButton adicionarButton;
    private JButton voltarButton;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel label;
    private JFrame frame;

    public AdicionarProdutosConsulta(){
        frame=new JFrame("ADICIONAR PRODUTOS/SERVIÇOS");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900, 900));
        frame.setResizable(true);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        adicionarButton.addActionListener(this);
        voltarButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == voltarButton) {
            frame.dispose();
            new MenuFuncionario();
        }
        if (e.getSource() == adicionarButton) {
            Repositorio repo = Repositorio.getRepositorio();

            for (Consulta consulta : Repositorio.getRepositorio().getConsultas().values()) {
                if (consulta.getnConsulta() == Integer.parseInt(textField1.getText())) {
                    if (consulta.getEstado().equals(Estado.CONCLUIDA) || consulta.getEstado().equals(Estado.PAGA) || consulta.getEstado().equals(Estado.ANULADA)) {
                        consulta.setTotalpreco(consulta.getPreco());
                        if (raioXCheckBox.isSelected()) {
                            consulta.setTotalpreco(consulta.getPreco() + 50);
                            consulta.setDescricao("\nFoi feito um Raio-X;");
                            repo.serializar("consultas.repo", Repositorio.getRepositorio().getConsultas());
                        }
                        if (internamentoCheckBox.isSelected()) {
                            consulta.setTotalpreco(consulta.getTotalpreco() + (Integer.parseInt(textField2.getText()) * 30));
                            consulta.setDescricao(consulta.getDescricao() + (Integer.parseInt(textField2.getText()) + " em internamento;"));
                            repo.serializar("consultas.repo", Repositorio.getRepositorio().getConsultas());
                        }
                        if (banhoCheckBox.isSelected()) {
                            consulta.setTotalpreco(consulta.getTotalpreco() + 5);
                            consulta.setDescricao(consulta.getDescricao() + "\nTomou um banho;");
                            repo.serializar("consultas.repo", Repositorio.getRepositorio().getConsultas());
                        }
                        if (comidaCheckBox.isSelected()) {
                            consulta.setTotalpreco(consulta.getTotalpreco() + 2);
                            consulta.setDescricao(consulta.getDescricao() + "\nTeve uma Refeição;");
                            repo.serializar("consultas.repo", Repositorio.getRepositorio().getConsultas());
                        }
                        if (cirurgiaCheckBox.isSelected()) {
                            consulta.setTotalpreco(consulta.getTotalpreco() + 150);
                            consulta.setDescricao(consulta.getDescricao() + "\nRealizou uma Cirurgia;");
                            repo.serializar("consultas.repo", Repositorio.getRepositorio().getConsultas());
                        }
                    }else {
                        label.setText("  IMPOSSÍVEL ADICIONAR PRODUTOS A ESTA CONSULTA!");
                    }
                }
            }
        }
    }
}

