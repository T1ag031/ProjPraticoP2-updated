package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultasMarcadasCli extends JFrame implements ActionListener {
    private JPanel panel1;
    private JButton mostrarButton;
    private JButton limparButton;
    private JButton voltarButton;
    private JLabel label;
    private JFrame frame;

    public ConsultasMarcadasCli(){
        frame= new JFrame("CONSULTAS MARCADAS");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setResizable(true);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        mostrarButton.addActionListener(this);
        limparButton.addActionListener(this);
        voltarButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(limparButton)){
            label.setText("");
        }
        if (e.getSource().equals(voltarButton)){
            frame.dispose();
            new MenuCliente();
        }
    }
}
