package GUI;

import BLL.Empresa;
import BLL.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListarEmpresasDono extends JFrame implements ActionListener {
    private JPanel panel1;
    private JTable table1;
    private JButton listarButton;
    private JButton voltarButton;
    private JTextField textField1;
    private JFrame frame1;

    public ListarEmpresasDono(){
        frame1=new JFrame("LISTAR EMPRESAS");
        frame1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame1.setResizable(true);
        frame1.setPreferredSize(new Dimension(900, 900));
        frame1.add(panel1);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
        voltarButton.addActionListener(this);
        listarButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==voltarButton){
            frame1.dispose();
            new MenuDono();
        }
        if (e.getSource()==listarButton){
            DefaultTableModel table = (DefaultTableModel)this.table1.getModel();
            table.addColumn("Nome");
            table.addColumn("ID");
            table.addColumn("Número Telemóvel");
            table.addColumn("Tipo");
            table.addColumn("Estado");

            for (Empresa empresa : Repositorio.getRepositorio().getEmpresa().values()){
                if (empresa.getDono()==(Integer.parseInt(textField1.getText()))){
                    table.addRow(new Object[]{empresa.getNome(), empresa.getIdEmpresa(), empresa.getnTelefone(), empresa.getTipo(), empresa.getEstado()});
                }
            }
        }
    }
}

