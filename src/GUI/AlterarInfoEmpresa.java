package GUI;

import BLL.Empresa;
import BLL.Repositorio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterarInfoEmpresa extends JFrame implements ActionListener {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton alterarButton;
    private JButton voltarButton;
    private JButton limparButton;
    private JButton mostrarDadosButton;
    private JLabel labelnome;
    private JLabel labeltel;
    private JLabel labellocal;
    private JLabel labelres;
    private JFrame frame;

    public AlterarInfoEmpresa() {
        frame = new JFrame("ALTERAR INFORMAÇÃO EMPRESA");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setResizable(true);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        mostrarDadosButton.addActionListener(this);
        limparButton.addActionListener(this);
        voltarButton.addActionListener(this);
        alterarButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == voltarButton) {
            frame.dispose();
            new MenuDono();
        }
        if (e.getSource() == limparButton) {
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
            textField4.setText("");
            labelnome.setText("");
            labellocal.setText("");
            labeltel.setText("");
        }
        if (e.getSource() == mostrarDadosButton) {
            String nif = textField1.getText();
            for (Empresa empresa : Repositorio.getRepositorio().getEmpresa().values()) {
                if (empresa.getNif().equals(nif)) {
                    labelnome.setText("Nome: " + empresa.getNome());
                    labeltel.setText("Número de Telefone: " + empresa.getnTelefone());
                    labellocal.setText("Localidade: " + empresa.getLocalidade());
                }
            }
        }

        if (e.getSource() == alterarButton) {
            Repositorio repo = Repositorio.getRepositorio();
            String nif = textField1.getText();
            for (Empresa empresa : Repositorio.getRepositorio().getEmpresa().values()) {
                if(empresa.getNif().equals(nif)) {
                    if (!textField2.getText().equals("")) {
                        empresa.setNome(textField2.getText());
                        repo.serializar("empresa.repo", Repositorio.getRepositorio().getEmpresa());
                        labelres.setText("ALTERAÇÃO EFETUADA COM SUCESSO!");
                    }else {
                        empresa.setNome(empresa.getNome());
                    }
                    if (!textField3.getText().equals("")) {
                        empresa.setnTelefone(textField3.getText());
                        repo.serializar("empresa.repo", Repositorio.getRepositorio().getEmpresa());
                        labelres.setText("ALTERAÇÃO EFETUADA COM SUCESSO!");
                    }else {
                        empresa.setnTelefone(empresa.getnTelefone());
                    }
                    if (!textField4.getText().equals("")) {
                        empresa.setLocalidade(textField4.getText());
                        repo.serializar("empresa.repo", Repositorio.getRepositorio().getEmpresa());
                        labelres.setText("ALTERAÇÃO EFETUADA COM SUCESSO!");
                    }else {
                        empresa.setLocalidade(empresa.getLocalidade());
                    }
                }
            }
        }
    }
}