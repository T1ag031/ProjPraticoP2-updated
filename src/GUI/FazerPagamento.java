package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FazerPagamento extends JFrame implements ActionListener {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton pagarButton;
    private JButton voltarButton;
    private JButton limparButton;
    private JLabel label;
    private JFrame frame;

    public FazerPagamento(){
        frame=new JFrame("FAZER PAGAMENTO");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
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
            textField2.setText("");
        }
        if (e.getSource()==voltarButton){
            frame.dispose();
            new MenuCliente();
        }
        if (e.getSource()==pagarButton){
            /*.......*/
            label.setText("Pagamento Efetuado com Sucesso");
        }
    }
}
