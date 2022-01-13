package GUI;

import BLL.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class ListarClientes extends JFrame implements ActionListener {
    private JPanel panel1;
    private JButton listarButton;
    private JButton voltarButton1;
    private JTable table1;
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
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==voltarButton1){
            frame1.dispose();
            new MenuAdmin();
        }
        if (e.getSource()==listarButton){


            DefaultTableModel model = (DefaultTableModel)this.table1.getModel();

            model.addColumn("Nome Cliente");
            model.addColumn("NIF");
            model.addColumn("Morada");
            model.addColumn("Número Telemóvel");
            Collection<Utilizadores> listaCli = UserBLL.getAllUsers();

            /*String nif11= textField1.getText();
            Collection<Utilizadores> users = UserBLL.getAllUsers();
            for (Utilizadores cli : users){
                if (cli.getNIF().equals(nif11)){
                    label.setText("Nome: " + cli.getNome());
                    labelnif.setText("NIF: " + cli.getNIF());
                    labeltel.setText("Número de Telemóvel: " + cli.getnTelefone());
                    labelmor.setText("Morada: " + cli.getMorada());
                }else {
                    label.setText("CLIENTE NÃO ENCONTRADO");
                }
            }*/

            /*String nif11= textField1.getText();
            Collection<DonoEmpresa> dono = DonoBLL.getAllDonos();
            for (DonoEmpresa donoEmpresa : dono){
                if (donoEmpresa.getNIFDono().equals(nif11)){
                    label.setText("Nome: " + donoEmpresa.getNomeDono());
                    labelnif.setText("NIF: " + donoEmpresa.getNIFDono());
                    labeltel.setText("Número de Telemóvel: " + donoEmpresa.getnTelefoneDono());
                    labelmor.setText("Morada: " + donoEmpresa.getMoradaDono());
                }else {
                    label.setText("DONO DE EMPRESA NÃO ENCONTRADO");
                }
            }*/
        }
    }
}
