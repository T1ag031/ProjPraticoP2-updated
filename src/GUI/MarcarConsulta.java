package GUI;

import BLL.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

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
    private JCheckBox saúdeCheckBox;
    private JFrame frame;
    Collection<Empresa> empresas;

    public MarcarConsulta(){
        frame=new JFrame("MARCAR CONSULTA");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setResizable(true);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        marcarButton.addActionListener(this);
        limparButton.addActionListener(this);
        voltarButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==limparButton){
            textField1.setText("");
            textField2.setText("");
            textField5.setText("");
        }
        if (e.getSource()==voltarButton){
            frame.dispose();
            new MenuCliente();
        }
        if (e.getSource()==marcarButton){
            String Animal = textField1.getText();
            String dataC = textField2.getText();
            String vet = textField5.getText();

            Consulta consulta = new Consulta();

            consulta.setDataconsulta(dataC);
            consulta.setNomeVet(vet);
            consulta.setAnimal(Animal);
            consulta.setEstado(Estado.MARCADA);
            if (belezaCheckBox.isSelected()){
                consulta.setTipoConsulta(TipoConsulta.BELEZA);
            }
            if (saúdeCheckBox.isSelected()){
                consulta.setTipoConsulta(TipoConsulta.SAUDE);
            }
            ConsultaBLL.marcarConsulta(consulta);

            label.setText("CONSULTA MARCADA COM SUCESSO!");

        }
    }
}
