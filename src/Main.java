import BLL.Repositorio;
import GUI.EscolhaInicial;
import GUI.LogIn;
import GUI.PaginaInicial;

public class Main {
    public static void main(String[] args) {
        new PaginaInicial();

        Repositorio repo = Repositorio.getRepositorio();
        Repositorio.desserializar("cliente.repo");

        Repositorio repo1 = Repositorio.getRepositorio();
        Repositorio.desserializar("donos.repo");

        Repositorio repo2 = Repositorio.getRepositorio();
        Repositorio.desserializar("empresa.repo");
    }
}