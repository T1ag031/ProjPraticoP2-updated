package GUI;

import BLL.UserBLL;
import BLL.Utilizadores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class ListarClientes extends JFrame implements ActionListener {
    private JPanel panel1;
    private JButton listarButton;
    private JButton voltarButton1;
    private JButton limparButton;
    private JLabel label;
    private JTextField textField1;
    private JLabel labelmor;
    private JLabel labeltel;
    private JLabel labelnif;
    private JFrame frame1;

    public ListarClientes(){
        frame1=new JFrame("LISTAR CLIENTES");
        frame1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame1.setResizable(true);
        frame1.setPreferredSize(new Dimension(500, 500));
        frame1.add(panel1);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
        voltarButton1.addActionListener(this);
        listarButton.addActionListener(this);
        limparButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==limparButton){
            label.setText("");
            labelnif.setText("");
            labeltel.setText("");
            labelmor.setText("");
        }
        if (e.getSource()==voltarButton1){
            frame1.dispose();
            new MenuAdmin();
        }
        if (e.getSource()==listarButton){
            String nif11= textField1.getText();
            Collection<Utilizadores> users = UserBLL.getAllUsers();
            for (Utilizadores cli : users){
                if (cli.getNIF().equals(nif11)){
                    label.setText("Nome: " + cli.getNome());
                    labelnif.setText("NIF: " + cli.getNIF());
                    labeltel.setText("Número de Telemóvel: " + cli.getnTelefone());
                    labelmor.setText("Morada: " + cli.getMorada());
                }else {
                    //label.setText("CLIENTE NÃO ENCONTRADO");
                }
            }
        }
    }
}
