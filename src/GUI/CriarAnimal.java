package GUI;

import BLL.Animal;
import BLL.AnimalBLL;
import BLL.TipoAnimal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriarAnimal extends JFrame implements ActionListener {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;

    private JButton registarButton;
    private JButton limparButton;
    private JButton voltarButton;
    private JCheckBox domésticoCheckBox;
    private JCheckBox réptilCheckBox;
    private JCheckBox outroCheckBox;
    private JTextField textField3;
    private JFrame frame;

    public CriarAnimal(){
        frame= new JFrame("CRIAR ANIMAL");
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
        }
        if (e.getSource()==voltarButton){
            frame.dispose();
            new MenuCliente();
        }
        if (e.getSource()==registarButton){
            Animal animal = new Animal();
            animal.setNome(textField1.getText());
            animal.setIdade(Integer.parseInt(textField2.getText()));
            animal.setNifDono(Integer.parseInt(textField3.getText()));
            if (domésticoCheckBox.isSelected()){
                animal.setTipoAnimal(TipoAnimal.DOMESTICO);
            }
            if (réptilCheckBox.isSelected()){
                animal.setTipoAnimal(TipoAnimal.REPTIL);
            }
            if (outroCheckBox.isSelected()){
                animal.setTipoAnimal(TipoAnimal.OUTRO);
            }
            AnimalBLL.criarAnimal(animal);
        }
    }
}
