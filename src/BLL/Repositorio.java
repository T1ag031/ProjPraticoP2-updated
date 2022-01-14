package BLL;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public class Repositorio implements Serializable {
    private static Repositorio _repo = null;
    private int nextidUser=0;
    private int nextiDDono=0;
    private int nextiDEmpresa=0;
    private int nextiDConsulta=0;
    private int nextIDFuncionario=0;
    private int nextIDAnimal=0;
    private Map<Integer, Utilizadores> users;
    private Map<Integer, DonoEmpresa> donos;
    private Map<Integer, Empresa> empresa;
    private Map<Integer, Consulta> consultas;
    private Map<Integer, Funcionario> funcionario;
    private Map<Integer, Animal> animal;

    public Repositorio() {
        users = (Map<Integer, Utilizadores>) desserializar("cliente.repo");
        donos = (Map<Integer, DonoEmpresa>) desserializar("donos.repo");
        empresa = (Map<Integer, Empresa>) desserializar("empresa.repo");
        consultas = (Map<Integer, Consulta>) desserializar("consultas.repo");
        funcionario = (Map<Integer, Funcionario>) desserializar("funcionarios.repo");
        animal = (Map<Integer, Animal>) desserializar("animal.repo");
    }
    public Map<Integer, DonoEmpresa> getDonos() {
        return donos;
    }

    public Map<Integer, Utilizadores> getUsers() {
        return users;
    }

    public Map<Integer, Empresa> getEmpresa() {
        return empresa;
    }

    public Map<Integer, Consulta> getConsultas() {
        return consultas;
    }

    public Map<Integer, Funcionario> getFuncionario() {
        return funcionario;
    }

    public Map<Integer, Animal> getAnimal() {
        return animal;
    }

    public int getNextIDAnimal() {
        if(_repo.getAnimal().isEmpty())return 0;
        return (int) _repo.getAnimal().keySet().toArray()[_repo.getAnimal().keySet().size() -1] +1;
    }

    public void setNextIDAnimal(int nextIDAnimal) {
        this.nextIDAnimal = nextIDAnimal;
    }

    public int getNextIDFuncionario() {
        if(_repo.getFuncionario().isEmpty())return 0;
        return (int) _repo.getFuncionario().keySet().toArray()[_repo.getFuncionario().keySet().size() -1] +1;

    }

    public void setNextIDFuncionario(int nextIDFuncionario) {
        this.nextIDFuncionario = nextIDFuncionario;
    }

    public int getNextidUser() {
        if(_repo.getUsers().isEmpty())return 0;
        return (int) _repo.getUsers().keySet().toArray()[_repo.getUsers().keySet().size() -1] +1;
    }

    public void setNextidUser(int nextidUser) {
        this.nextidUser = nextidUser;
    }

    public int getNextiDDono() {
        if(_repo.getDonos().isEmpty())return 0;
        return (int) _repo.getDonos().keySet().toArray()[_repo.getDonos().keySet().size() -1] +1;
    }

    public void setNextiDDono(int nextiDDono) {
        this.nextiDDono = nextiDDono;
    }

    public int getNextiDEmpresa() {
        if(_repo.getEmpresa().isEmpty())return 0;
        return (int) _repo.getEmpresa().keySet().toArray()[_repo.getEmpresa().keySet().size() -1] +1;
    }

    public void setNextiDEmpresa(int nextiDEmpresa) {
        this.nextiDEmpresa = nextiDEmpresa;
    }

    public int getNextiDConsulta() {
        if(_repo.getConsultas().isEmpty())return 0;
        return (int) _repo.getConsultas().keySet().toArray()[_repo.getConsultas().keySet().size() -1] +1;
    }

    public void setNextiDConsulta(int nextiDConsulta) {
        this.nextiDConsulta = nextiDConsulta;
    }

    public static Repositorio getRepositorio() {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        if (_repo == null) {
            _repo = new Repositorio();
        }
        lock.unlock();
        return _repo;
    }

    public void  serializar(String filename, Object t) {
        try {
            FileOutputStream fileout = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(t);
            out.close();
            fileout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public <T> Object desserializar(String filename){
        Object obj = new HashMap<Integer,Object>();
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
             obj =  in.readObject();
            in.close();
            fileIn.close();
        }catch (IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return obj;
    }
}
