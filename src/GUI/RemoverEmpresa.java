package GUI;

import BLL.Empresa;
import BLL.EmpresaBLL;
import BLL.EstadoEmpresa;
import BLL.Repositorio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Objects;

public class RemoverEmpresa extends JFrame implements ActionListener {

    private JPanel panel1;
    private JTextField textField1;
    private JButton removerButton;
    private JButton voltarButton1;
    private JButton voltarButton;
    private JButton mostrarDadosEmpresaButton;
    private JLabel labelnome;
    private JLabel labelnif;
    private JLabel labelloc;
    private JLabel labeltel;
    private JLabel lab;
    private JFrame frame;

    public RemoverEmpresa() {
        frame = new JFrame("REMOVER EMPRESA");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setResizable(true);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        removerButton.addActionListener(this);
        voltarButton.addActionListener(this);
        mostrarDadosEmpresaButton.addActionListener(this);
        voltarButton1.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == voltarButton1) {
            frame.dispose();
            new MenuAdmin();
        }
        if (e.getSource() == voltarButton) {
            textField1.setText("");
            labeltel.setText("");
            labelnif.setText("");
            labelloc.setText("");
            labelnome.setText("");
        }
        if (e.getSource() == removerButton) {
            String nif1 = textField1.getText();
            for (Empresa empresa : Repositorio.getRepositorio().getEmpresa().values()) {
                if (empresa.getNif().equals(nif1)) {

                }
            }
        }

        if (e.getSource() == mostrarDadosEmpresaButton) {

            for (Empresa empresa : Repositorio.getRepositorio().getEmpresa().values()) {
                if (empresa.getIdEmpresa() == (Integer.parseInt(textField1.getText()))) {
                    labelnome.setText("Nome: " + empresa.getNome());
                    labelnif.setText("NIF: " + empresa.getNif());
                    labeltel.setText("Número de Telemóvel: " + empresa.getnTelefone());
                    labelloc.setText("Dono: " + empresa.getDono());
                }
            }
        }

        if (e.getSource() == removerButton) {
            Repositorio repo = Repositorio.getRepositorio();
            for (Empresa empresa : Repositorio.getRepositorio().getEmpresa().values()) {
                if (empresa.getIdEmpresa() == (Integer.parseInt(textField1.getText()))) {
                    empresa.setEstado(EstadoEmpresa.DESATIVA);
                    repo.serializar("empresa.repo", Repositorio.getRepositorio().getEmpresa());
                    lab.setText("EMPRESA DESATIVADA COM SUCESSO!");
                }else {
                    lab.setText("EMPRESA NÃO ENCONTRADA!");
                    textField1.setText("");
                    labeltel.setText("");
                    labelnif.setText("");
                    labelloc.setText("");
                    labelnome.setText("");
                }
            }
        }
    }
}