package GUI;

import BLL.Empresa;
import BLL.Repositorio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PesquisarEmpresa extends JFrame implements ActionListener {
    private JPanel panel1;
    private JButton procurarButton;
    private JButton limparButton;
    private JButton voltarButton;
    private JTextField textField1;
    private JLabel labelnome;
    private JLabel labelnif;
    private JLabel labellocal;
    private JLabel labeltel;
    private JLabel labelestado;
    private JLabel labeldono;
    private JFrame frame;

    public PesquisarEmpresa(){
        frame = new JFrame("PESQUISAR EMPRESA");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setResizable(true);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        procurarButton.addActionListener(this);
        limparButton.addActionListener(this);
        voltarButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==limparButton){
            textField1.setText("");
            labeldono.setText("");
            labellocal.setText("");
            labelnome.setText("");
            labelnif.setText("");
            labeltel.setText("");
            labelestado.setText("");
        }
        if (e.getSource()==voltarButton){
            frame.dispose();
            new MenuDono();
        }
        if (e.getSource()==procurarButton){
            String nif1 = textField1.getText();
            for (Empresa empresa: Repositorio.getRepositorio().getEmpresa().values()){
                if (empresa.getNif().equals(nif1)){
                    labelnome.setText("Nome: " + empresa.getNome());
                    labelnif.setText("NIF: " + empresa.getNif());
                    labeltel.setText("Número de Telemóvel: " + empresa.getnTelefone());
                    labellocal.setText("Localidade: " + empresa.getLocalidade());
                    labellocal.setText("Tipo de Empresa: " + empresa.getTipo());
                    labeldono.setText("NIF Dono: " + empresa.getDono());
                }
            }
        }
    }
}
