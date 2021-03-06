package GUI;

import BLL.Consulta;
import BLL.Empresa;
import BLL.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerConsultasMarcadas extends JFrame implements ActionListener {
    private JButton listarButton;
    private JButton voltarButton;
    private JFrame frame1;
    private JPanel panel1;
    private JTable table1;
    private JTextField textField1;

    public VerConsultasMarcadas(){
        frame1=new JFrame("LISTAR CONSULTAS MARCADAS");
        frame1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame1.setResizable(true);
        frame1.setPreferredSize(new Dimension(900, 900));
        frame1.add(panel1);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
        listarButton.addActionListener(this);
        voltarButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==voltarButton){
            frame1.dispose();
            new MenuDono();
        }
        if (e.getSource()==listarButton){
            DefaultTableModel tableM = (DefaultTableModel)this.table1.getModel();
                tableM.addColumn("Nome Animal");
                tableM.addColumn("Data");
                tableM.addColumn("Empresa");
                tableM.addColumn("Preco");
                tableM.addColumn("Tipo");
                tableM.addColumn("Estado");

            for (Consulta consulta : Repositorio.getRepositorio().getConsultas().values()){
                if (consulta.getNomeVet()==(Integer.parseInt(textField1.getText()))){
                        tableM.addRow(new Object[]{consulta.getAnimal(), consulta.getDataconsulta(), consulta.getNomeVet(), consulta.getPreco(), consulta.getTipoConsulta(), consulta.getEstado()});
                }
            }
        }
    }
}
