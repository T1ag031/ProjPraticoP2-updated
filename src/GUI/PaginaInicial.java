package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaInicial extends JFrame implements ActionListener {
    private JPanel panel1;
    private JButton entrarNaAppButton;
    private JFrame frame;

    public PaginaInicial(){
        frame = new JFrame("PetBeauty");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setResizable(true);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        entrarNaAppButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==entrarNaAppButton){
            frame.dispose();
            new EscolhaInicial();
        }
    }
}
