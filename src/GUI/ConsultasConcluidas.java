package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultasConcluidas extends JFrame implements ActionListener {
    private JPanel panel1;
    private JButton listarButton;
    private JButton limparButton;
    private JButton voltarButton;
    private JLabel label;
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
        limparButton.addActionListener(this);
        voltarButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource()==limparButton){
           label.setText("");
       }
       if (e.getSource()==voltarButton){
           frame.dispose();
           new MenuCliente();
       }
    }
}
