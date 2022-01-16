package GUI;

import BLL.Consulta;
import BLL.Estado;
import BLL.Repositorio;

import javax.management.ObjectName;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PagarConsultas extends JFrame implements ActionListener {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton pagarButton;
    private JButton mostrarButton;
    private JButton voltarButton;
    private JButton limparButton;
    private JTable table;
    private JLabel label;
    private JFrame frame;

    public PagarConsultas(){
        frame=new JFrame("PAGAR CONSULTAS");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900, 900));
        frame.setResizable(true);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        pagarButton.addActionListener(this);
        limparButton.addActionListener(this);
        voltarButton.addActionListener(this);
        mostrarButton.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==mostrarButton){
            DefaultTableModel model = (DefaultTableModel) this.table.getModel();
            model.addColumn("NºConsulta");
            model.addColumn("Preço");
            model.addColumn("Descrição");
            model.addColumn("Estado");
            for (Consulta consulta:Repositorio.getRepositorio().getConsultas().values()){
                if (consulta.getNifcliente()==(Integer.parseInt(textField1.getText()))){
                    if (consulta.getEstado().equals(Estado.PAGA) || consulta.getEstado().equals(Estado.ANULADA)){
                        model.addRow(new Object[]{ consulta.getnConsulta(), consulta.getTotalpreco(), consulta.getDescricao(), consulta.getEstado()});
                    }
                }
            }
        }
        if (e.getSource()==pagarButton){
            Repositorio repo = Repositorio.getRepositorio();
            for (Consulta consulta:Repositorio.getRepositorio().getConsultas().values()){
                if (consulta.getNifcliente()==(Integer.parseInt(textField1.getText()))){
                    if (consulta.getnConsulta()==(Integer.parseInt(textField2.getText()))){
                        if (!(consulta.getEstado().equals(Estado.ANULADA) || consulta.getEstado().equals(Estado.PAGA))){
                            consulta.setEstado(Estado.PAGA);
                            repo.serializar("consultas.repo", Repositorio.getRepositorio().getConsultas());
                            label.setText("PAGAMENTO EFETUADO COM SUCESSO!");
                            textField1.setText("");
                            textField2.setText("");
                        }else {
                            label.setText("CONSULTA JÁ PAGA OU ANULADA");
                            textField1.setText("");
                            textField2.setText("");
                        }
                    }else {
                        label.setText("CONSULTA NÃO ENCONTRADA!");
                        textField1.setText("");
                        textField2.setText("");
                    }
                }else {
                    label.setText("CLIENTE NÃO ENCONTRADO");
                    textField1.setText("");
                    textField2.setText("");
                }
            }
        }
        if (e.getSource()==voltarButton){
            frame.dispose();
            new MenuCliente();
        }
        if (e.getSource()==limparButton){
            textField1.setText("");
            textField2.setText("");
            label.setText("");
        }
    }
}
