package BLL;

import java.util.Collection;

public class FuncionarioBLL {
    public static int getNextIDFuncionario(){
        int nextID = Repositorio.getRepositorio().getNextIDFuncionario();
        Repositorio.getRepositorio().setNextIDFuncionario(++nextID);
        return nextID;
    }

    public static void criarFuncionario(Funcionario funcionario){
        int nextID = getNextIDFuncionario();
        funcionario.setIdFuncionario(nextID);
        Repositorio.getRepositorio().getFuncionario().put(funcionario.getIdFuncionario(), funcionario);
        Repositorio.getRepositorio().serializar("funcionarios.repo",Repositorio.getRepositorio().getFuncionario());

    }

    public static Collection<Funcionario> getAllFuncionarios(){
        return (Collection<Funcionario>) Repositorio.getRepositorio().getFuncionario().values();
    }
}
