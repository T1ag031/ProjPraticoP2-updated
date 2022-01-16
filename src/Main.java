import BLL.Repositorio;
import GUI.EscolhaInicial;
import GUI.LogIn;
import GUI.PaginaInicial;

public class Main {
    public static void main(String[] args) {
        new PaginaInicial();
        Repositorio repo = Repositorio.getRepositorio();
        //repo.serializar("consultas.repo", Repositorio.getRepositorio().getConsultas());
    }
}
