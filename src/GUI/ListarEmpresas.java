package GUI;

import BLL.Empresa;
import BLL.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListarEmpresas extends JFrame implements ActionListener {
    private JButton voltarButton;
    private JFrame frame1;
    private JPanel panel1;
    private JTable table1;

    public ListarEmpresas(){
        frame1=new JFrame("LISTAR EMPRESAS");
        frame1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame1.setResizable(true);
        frame1.setPreferredSize(new Dimension(900, 900));
        frame1.add(panel1);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
        voltarButton.addActionListener(this);

        DefaultTableModel tableModel = (DefaultTableModel)this.table1.getModel();

        tableModel.addColumn("Nome");
        tableModel.addColumn("ID");
        tableModel.addColumn("Dono");
        tableModel.addColumn("NIF");
        tableModel.addColumn("Tipo");
        tableModel.addColumn("Estado");

        for (Empresa empresa : Repositorio.getRepositorio().getEmpresa().values()){
            tableModel.addRow(new Object[]{empresa.getNome(), empresa.getIdEmpresa(), empresa.getDono(), empresa.getNif(), empresa.getTipo(), empresa.getEstado()});
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==voltarButton){
            frame1.dispose();
            new MenuAdmin();
        }
    }
}
