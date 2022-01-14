package GUI;

import BLL.Consulta;
import BLL.Estado;
import BLL.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultasMarcadasCli extends JFrame implements ActionListener {
    private JPanel panel1;
    private JTable table1;
    private JButton listarButton;
    private JButton voltarButton;
    private JTextField textField1;
    private JFrame frame;

    public ConsultasMarcadasCli(){
        frame= new JFrame("CONSULTAS MARCADAS");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setResizable(true);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        listarButton.addActionListener(this);
        voltarButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(voltarButton)){
            frame.dispose();
            new MenuCliente();
        }
        if (e.getSource()==listarButton){
            DefaultTableModel tableM = (DefaultTableModel)this.table1.getModel();

            tableM.addColumn("Animal");
            tableM.addColumn("Data");
            tableM.addColumn("Funcionário");
            tableM.addColumn("Preço");
            tableM.addColumn("Tipo");
            tableM.addColumn("Estado");
            for (Consulta consulta1: Repositorio.getRepositorio().getConsultas().values()){
                if (consulta1.getEstado().equals(Estado.MARCADA)){
                    if (consulta1.getNifcliente()==(Integer.parseInt(textField1.getText()))){
                        tableM.addRow(new Object[]{consulta1.getAnimal(), consulta1.getDataconsulta(), consulta1.getNomeVet(), consulta1.getPreco(), consulta1.getTipoConsulta(), consulta1.getEstado()});
                    }
                }
            }
        }
    }
}
