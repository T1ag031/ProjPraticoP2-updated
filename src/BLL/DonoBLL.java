package BLL;

import java.util.Collection;

public class DonoBLL {
    public static int getNextId() {
        int nextID = Repositorio.getRepositorio().getNextiDDono();
        Repositorio.getRepositorio().setNextiDDono(++nextID);
        return nextID;
    }

    public static void criarDonoEmpresa(DonoEmpresa dono){
        int nextID1 = getNextId();
        dono.setIdDono(nextID1);
        Repositorio.getRepositorio().getDonos().put(dono.getIdDono(), dono);
        Repositorio.getRepositorio().serializar("donos.repo");
    }

    public static Collection<DonoEmpresa> getAllDonos(){
        return (Collection<DonoEmpresa>) Repositorio.getRepositorio().getDonos().values();
    }
}
