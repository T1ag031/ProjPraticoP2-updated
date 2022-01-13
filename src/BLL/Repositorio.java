package BLL;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class Repositorio implements Serializable {
    private static Repositorio _repo = null;
    private int nextidUser=0;
    private int nextiDDono=0;
    private int nextiDEmpresa=0;
    private Map<Integer, Utilizadores> users;
    private Map<Integer, DonoEmpresa> donos;
    private Map<Integer, Empresa> empresa;

    public Repositorio() {
        users = new HashMap<>();
        donos = new HashMap<>();
        empresa = new HashMap<>();
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

    public int getNextidUser() {
        return nextidUser;
    }

    public void setNextidUser(int nextidUser) {
        this.nextidUser = nextidUser;
    }

    public int getNextiDDono() {
        return nextiDDono;
    }

    public void setNextiDDono(int nextiDDono) {
        this.nextiDDono = nextiDDono;
    }

    public int getNextiDEmpresa() {
        return nextiDEmpresa;
    }

    public void setNextiDEmpresa(int nextiDEmpresa) {
        this.nextiDEmpresa = nextiDEmpresa;
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

    public void serializar(String filename) {
        try {
            FileOutputStream fileout = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(_repo);
            out.close();
            fileout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void desserializar(String filename){
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            _repo = (Repositorio) in.readObject();
            in.close();
            fileIn.close();
        }catch (IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }
}
