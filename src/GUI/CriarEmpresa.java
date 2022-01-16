package GUI;

import BLL.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriarEmpresa extends JFrame implements ActionListener  {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton registarButton;
    private JButton limparButton;
    private JButton voltarButton;
    private JCheckBox saúdeCheckBox;
    private JCheckBox belezaCheckBox;
    private JLabel label;
    private JTextField textField5;
    private JFrame frame;


    public CriarEmpresa(){
        frame= new JFrame("CRIAR EMPRESA");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setResizable(true);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        registarButton.addActionListener(this);
        limparButton.addActionListener(this);
        voltarButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == limparButton) {
            textField1.setText("");
            textField2.setText("");
            textField4.setText("");
            textField3.setText("");
            textField5.setText("");
            label.setText("");
        }
        if (e.getSource() == voltarButton) {
            frame.dispose();
            new MenuDono();
        }
        if (e.getSource() == registarButton) {
            for (Empresa empresa : Repositorio.getRepositorio().getEmpresa().values()){
                if (!(textField1.getText().equals(""))) {
                    if (!(textField2.getText().equals(""))) {
                        if (!(textField3.getText().equals(""))) {
                            if (!(textField4.getText().equals(""))) {
                                if (!(textField5.getText().equals(""))) {
                                    Empresa empresa1 = new Empresa();
                                    empresa1.setNome(textField1.getText());
                                    empresa1.setNif(textField2.getText());
                                    empresa1.setLocalidade(textField3.getText());
                                    empresa1.setnTelefone(textField4.getText());
                                    empresa1.setDono(Integer.parseInt(textField5.getText()));
                                    empresa1.setEstado(EstadoEmpresa.ATIVA);
                                    if (belezaCheckBox.isSelected()){
                                        empresa1.setTipo(TipoEmpresa.BELEZA);
                                    }
                                    if (saúdeCheckBox.isSelected()){
                                        empresa1.setTipo(TipoEmpresa.SAUDE);
                                    }
                                    EmpresaBLL.criarEmpresa(empresa1);
                                    label.setText("EMPRESA CRIADA COM SUCESSO");
                                } else {
                                    label.setText("HÁ ESPAÇOS EM BRANCO!");
                                }
                            } else {
                                label.setText("HÁ ESPAÇOS EM BRANCO!");
                            }
                        } else {
                            label.setText("HÁ ESPAÇOS EM BRANCO!");
                        }
                    } else {
                        label.setText("HÁ ESPAÇOS EM BRANCO!");
                    }
                } else {
                    label.setText("HÁ ESPAÇOS EM BRANCO!");
                }
            }
        }
    }
}

