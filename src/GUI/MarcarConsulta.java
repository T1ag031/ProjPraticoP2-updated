package GUI;

import BLL.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class MarcarConsulta extends JFrame implements ActionListener {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField5;
    private JButton marcarButton;
    private JButton limparButton;
    private JButton voltarButton;
    private JLabel label;
    private JCheckBox belezaCheckBox;
    private JCheckBox saudeCheckBox;
    private JTable table1;
    private JTable table;
    private JTextField textField3;
    private JFrame frame;


    public MarcarConsulta(){
        frame=new JFrame("MARCAR CONSULTA");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900, 900));
        frame.setResizable(true);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        marcarButton.addActionListener(this);
        limparButton.addActionListener(this);
        voltarButton.addActionListener(this);

        DefaultTableModel model = (DefaultTableModel) this.table1.getModel();
        model.addColumn("Nome");
        model.addColumn("Tipo de Animal");
        for (Animal animal : Repositorio.getRepositorio().getAnimal().values()){
            model.addRow(new Object[]{animal.getNome(), animal.getTipoAnimal()});
        }

        DefaultTableModel tableModel = (DefaultTableModel) this.table.getModel();
        tableModel.addColumn("Empresa");
        tableModel.addColumn("Tipo de Serviço");
        tableModel.addColumn("Estado");
        tableModel.addColumn("Número");

        for (Empresa empresa : Repositorio.getRepositorio().getEmpresa().values()){
            tableModel.addRow(new Object[]{empresa.getNome(), empresa.getTipo(), empresa.getEstado(), empresa.getIdEmpresa()});
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==limparButton){
            textField1.setText("");
            textField2.setText("");
            textField5.setText("");
            label.setText("");
        }
        if (e.getSource()==voltarButton){
            frame.dispose();
            new MenuCliente();
        }

        if (e.getSource()==marcarButton){

           if (textField2.getText().equals("")){
                if (textField5.getText().equals("")){
                    if (textField1.getText().equals("")){
                        if (textField3.getText().equals("")){
                            label.setText("DEVE INTRODUZIR OS DADOS CORRETAMENTE!");
                            textField1.setText("");
                            textField2.setText("");
                            textField5.setText("");
                        }
                    }
                }
           }else{
               for (Empresa empresa : Repositorio.getRepositorio().getEmpresa().values()){
                    if (empresa.getIdEmpresa()==(Integer.parseInt(textField5.getText()))){
                        if (empresa.getEstado().equals(EstadoEmpresa.DESATIVA)){
                            label.setText("EMPRESA INDISPONIVEL!");
                            textField1.setText("");
                            textField2.setText("");
                            textField3.setText("");
                            textField5.setText("");
                        }
                    } else {
                       Consulta consulta = new Consulta();
                       consulta.setDataconsulta(textField2.getText());
                       consulta.setNomeVet(Integer.parseInt(textField5.getText()));
                       consulta.setAnimal(textField1.getText());
                       consulta.setEstado(Estado.MARCADA);
                       consulta.setNifcliente(Integer.parseInt(textField3.getText()));
                       if (belezaCheckBox.isSelected()){
                           consulta.setTipoConsulta(TipoConsulta.BELEZA);
                           consulta.setPreco(30);
                           ConsultaBLL.marcarConsulta(consulta);
                           label.setText("CONSULTA MARCADA COM SUCESSO!");
                       }
                       if (saudeCheckBox.isSelected()){
                           consulta.setPreco(50);
                           consulta.setTipoConsulta(TipoConsulta.SAUDE);
                           ConsultaBLL.marcarConsulta(consulta);
                           label.setText("CONSULTA MARCADA COM SUCESSO!");
                       }
                   }
               }
           }
        }
    }
}
