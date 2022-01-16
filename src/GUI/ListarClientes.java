package GUI;

import BLL.*;
import BLL.Utilizadores;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class ListarClientes extends JFrame implements ActionListener {
    private JPanel panel1;
    private JButton voltarButton1;
    private JTable table1;
    private JFrame frame1;

    public ListarClientes(){
        frame1=new JFrame("LISTAR CLIENTES");
        frame1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame1.setResizable(true);
        frame1.setPreferredSize(new Dimension(900, 900));
        frame1.add(panel1);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
        voltarButton1.addActionListener(this);

        DefaultTableModel tableModel = (DefaultTableModel)this.table1.getModel();

        tableModel.addColumn("Nome Cliente");
        tableModel.addColumn("NIF");
        tableModel.addColumn("Morada");
        tableModel.addColumn("Número Telemóvel");
        tableModel.addColumn("Username");
        tableModel.addColumn("ID");

        for (Utilizadores cli : Repositorio.getRepositorio().getUsers().values()){
            tableModel.addRow(new Object[]{cli.getNome(), cli.getNIF(), cli.getMorada(), cli.getnTelefone(), cli.getUsername(), cli.getIdUser()});
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==voltarButton1){
            frame1.dispose();
            new MenuAdmin();
        }

    }
}
