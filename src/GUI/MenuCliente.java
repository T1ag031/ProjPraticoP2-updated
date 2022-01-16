package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuCliente extends JFrame implements ActionListener {
    private JPanel panel1;
    private JButton criarAnimalButton;
    private JButton marcarConsultaButton;
    private JButton consultarMarcaçõesButton;
    private JButton voltarButton;
    private JButton consultarConsultasConcluidasButton;
    private JButton fazerPagamentoButton;
    private JFrame frame2;

    public MenuCliente(){
        frame2=new JFrame("CLIENTE");
        frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame2.setPreferredSize(new Dimension(500, 500));
        frame2.setResizable(true);
        frame2.add(panel1);
        frame2.pack();
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
        voltarButton.addActionListener(this);
        criarAnimalButton.addActionListener(this);
        marcarConsultaButton.addActionListener(this);
        consultarMarcaçõesButton.addActionListener(this);
        consultarConsultasConcluidasButton.addActionListener(this);
        fazerPagamentoButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==voltarButton){
            frame2.dispose();
            new EscolhaInicial();
        }
        if(e.getSource()==criarAnimalButton){
            new CriarAnimal();
            frame2.dispose();
        }
        if(e.getSource()==marcarConsultaButton){
            frame2.dispose();
            new MarcarConsulta();
        }
        if(e.getSource()==consultarMarcaçõesButton){
            frame2.dispose();
            new ConsultasMarcadasCli();
        }
        if(e.getSource()==consultarConsultasConcluidasButton){
            frame2.dispose();
            new ConsultasConcluidas();
        }
        if (e.getSource()==fazerPagamentoButton){
            frame2.dispose();
            new PagarConsultas();
        }
    }
}
