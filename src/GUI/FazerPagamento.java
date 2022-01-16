package GUI;

import BLL.Consulta;
import BLL.Estado;
import BLL.Repositorio;
import BLL.Utilizadores;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FazerPagamento extends JFrame implements ActionListener {
    private JPanel panel1;
    private JTextField textField1;
    private JButton pagarButton;
    private JButton voltarButton;
    private JButton limparButton;
    private JLabel label;
    private JButton mostarDadosConsultaButton;
    private JTable table;
    private JTextField textField2;
    private JButton mostrarConsultasButton;
    private JFrame frame;

    public FazerPagamento(){
        frame=new JFrame("FAZER PAGAMENTO");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 800));
        frame.setResizable(true);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        pagarButton.addActionListener(this);
        voltarButton.addActionListener(this);
        limparButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==limparButton){
            textField1.setText("");
            label.setText("");
        }
        if (e.getSource()==voltarButton){
            frame.dispose();
            new MenuCliente();
        }
        if (e.getSource()==mostarDadosConsultaButton) {
            DefaultTableModel model = (DefaultTableModel) this.table.getModel();
            model.addColumn("NºConsulta");
            model.addColumn("Preço");
            model.addColumn("Descrição");
            for (Consulta consulta1 : Repositorio.getRepositorio().getConsultas().values()) {
                if (consulta1.getNifcliente() == (Integer.parseInt(textField1.getText()))) {
                    model.addRow(new Object[]{consulta1.getnConsulta(), consulta1.getTotalpreco(), consulta1.getDescricao()});
                }
            }
        }

        if (e.getSource()==pagarButton){
            Repositorio repo = Repositorio.getRepositorio();
            for (Consulta consulta : Repositorio.getRepositorio().getConsultas().values()){
                if (consulta.getnConsulta() == (Integer.parseInt(textField2.getText()))) {
                        consulta.setEstado(Estado.PAGA);
                        repo.serializar("consultas.repo", Repositorio.getRepositorio().getConsultas());
                }
            }
        }

    }
}
