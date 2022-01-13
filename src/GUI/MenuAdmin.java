package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class MenuAdmin extends JFrame implements ActionListener {
    private JPanel panel1;
    private JButton eliminarEmpresaButton;
    private JButton eliminarDonoDeEmpresaButton;
    private JButton listarConsultasButton;
    private JButton listarClientesButton;
    private JButton criarAlterarRemoverEspecialidadesButton;
    private JButton voltarButton;
    private JFrame frame;

    public MenuAdmin(){
        frame= new JFrame("ADMINISTRADOR");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setResizable(true);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        eliminarEmpresaButton.addActionListener(this);
        eliminarDonoDeEmpresaButton.addActionListener(this);
        listarConsultasButton.addActionListener(this);
        listarClientesButton.addActionListener(this);
        criarAlterarRemoverEspecialidadesButton.addActionListener(this);
        voltarButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==voltarButton){
            frame.dispose();
            new EscolhaInicial();
        }
        if (e.getSource()==listarClientesButton){
            frame.dispose();
            new ListarClientes();
        }
        if (e.getSource()==eliminarEmpresaButton){
            frame.dispose();
            new RemoverEmpresa();
        }
    }
}