package GUI;

import BLL.Consulta;
import BLL.Estado;
import BLL.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultasConcluidas extends JFrame implements ActionListener {
    private JPanel panel1;
    private JTable table1;
    private JButton listarButton;
    private JButton voltarButton;
    private JTextField textField1;
    private JFrame frame;

    public ConsultasConcluidas(){
        frame= new JFrame("CONSULTAS CONCLUÍDAS");
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
       if (e.getSource()==voltarButton){
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
            for (Consulta consulta: Repositorio.getRepositorio().getConsultas().values()){
                if (textField1.getText().equals(textField1.getText())){
                    if (consulta.getEstado().equals(Estado.CONCLUIDA) || consulta.getEstado().equals(Estado.PAGA)){
                        tableM.addRow(new Object[]{consulta.getAnimal(), consulta.getDataconsulta(), consulta.getNomeVet(), consulta.getPreco(), consulta.getTipoConsulta(), consulta.getEstado()});
                    }
                }
            }
       }
    }
}
