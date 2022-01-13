package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuDono extends JFrame implements ActionListener {
    private JPanel panel1;
    private JButton criarEmpresaButton;
    private JButton pesquisarEmpresaButton;
    private JButton registarFuncionárioButton;
    private JButton verConsultasMarcadasButton;
    private JButton confirmarAnularConsultaButton;
    private JButton voltarButton;
    private JButton alterarInformaçãoEmpresaButton;
    private JFrame frame2;

    public MenuDono(){
        frame2=new JFrame("DONO EMPRESA");
        frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame2.setPreferredSize(new Dimension(500, 500));
        frame2.setResizable(true);
        frame2.add(panel1);
        frame2.pack();
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
        criarEmpresaButton.addActionListener(this);
        pesquisarEmpresaButton.addActionListener(this);
        registarFuncionárioButton.addActionListener(this);
        verConsultasMarcadasButton.addActionListener(this);
        confirmarAnularConsultaButton.addActionListener(this);
        voltarButton.addActionListener(this);
        alterarInformaçãoEmpresaButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==voltarButton){
            frame2.dispose();
            new EscolhaInicial();
        }
        if (e.getSource()==criarEmpresaButton){
            frame2.dispose();
            new CriarEmpresa();
        }
        if (e.getSource()==pesquisarEmpresaButton){
            frame2.dispose();
            new PesquisarEmpresa();
        }
        if (e.getSource()==registarFuncionárioButton){
            frame2.dispose();
            new RegistarFuncionario();
        }
        if (e.getSource()==verConsultasMarcadasButton){
            frame2.dispose();
            new ConsultasMarcadas();

        }
        if (e.getSource()==confirmarAnularConsultaButton){
            frame2.dispose();
            new AlterarEstadoConsulta();
        }
        if (e.getSource()==alterarInformaçãoEmpresaButton){
            frame2.dispose();
            new AlterarInfoEmpresa();
        }
    }
}
