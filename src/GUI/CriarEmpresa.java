package GUI;

import BLL.Empresa;
import BLL.EmpresaBLL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

public class CriarEmpresa extends JFrame implements ActionListener {
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
        if (e.getSource()==limparButton){
            textField1.setText("");
            textField2.setText("");
            textField4.setText("");
            textField3.setText("");
        }
        if (e.getSource()==voltarButton){
            frame.dispose();
            new MenuDono();
        }
        if (e.getSource()==registarButton){
            String nome = textField1.getText();
            String nif = textField2.getText();
            String localidade = textField3.getText();
            String tel = textField4.getText();

            Empresa empresa = new Empresa();

            empresa.setNome(nome);
            empresa.setNif(nif);
            empresa.setLocalidade(localidade);
            empresa.setnTelefone(tel);

            EmpresaBLL.criarEmpresa(empresa);

            label.setText("EMPRESA CRIADA COM SUCESSO");
        }
    }
}
