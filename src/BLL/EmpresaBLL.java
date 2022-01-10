package BLL;

import java.util.Collection;

public class EmpresaBLL {
    public static int getNextIdEmpresa(){
        int nextid = Repositorio.getRepositorio().getNextiDEmpresa();
        Repositorio.getRepositorio().setNextidUser(++nextid);
        return nextid;
    }

    public static void criarEmpresa(Empresa empresa){
        int nextid = getNextIdEmpresa();
        empresa.setIdEmpresa(nextid);
        Repositorio.getRepositorio().getEmpresa().put(empresa.getIdEmpresa(), empresa);
        Repositorio.getRepositorio().serializar("empresa.repo");
    }

    public static Collection<Empresa> getAllEmpresas(){
        return (Collection<Empresa>) Repositorio.getRepositorio().getEmpresa().values();
    }
}
