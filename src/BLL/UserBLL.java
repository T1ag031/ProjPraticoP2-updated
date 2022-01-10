package BLL;

import java.util.Collection;

public class UserBLL{
    public static int getNextId() {
        int nextID = Repositorio.getRepositorio().getNextidUser();
        Repositorio.getRepositorio().setNextidUser(++nextID);
        return nextID;
    }

    public static void criarCliente(Utilizadores User){
        int nextID = getNextId();
        User.setIdUser(nextID);
        Repositorio.getRepositorio().getUsers().put(User.getIdUser(), User);
        Repositorio.getRepositorio().serializar("cliente.repo");
    }

    public static Collection<Utilizadores> getAllUsers(){
        return (Collection<Utilizadores>) Repositorio.getRepositorio().getUsers().values();
    }
}