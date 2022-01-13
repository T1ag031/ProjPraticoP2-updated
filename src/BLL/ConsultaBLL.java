package BLL;

import java.util.Collection;

public class ConsultaBLL{
    public static int getNextIdConsulta() {
        int nextID = Repositorio.getRepositorio().getNextiDConsulta();
        Repositorio.getRepositorio().setNextiDConsulta(++nextID);
        return nextID;
    }

    public static void marcarConsulta(Consulta consulta){
        int nextIDC = getNextIdConsulta();
        consulta.setnConsulta(nextIDC);
        Repositorio.getRepositorio().getConsultas().put(consulta.getnConsulta(), consulta);
        Repositorio.getRepositorio().serializar("consultas.repo", Repositorio.getRepositorio().getConsultas());
    }

    public static Collection<Consulta> getAllConsultas(){
        return (Collection<Consulta>) Repositorio.getRepositorio().getConsultas().values();
    }
}
