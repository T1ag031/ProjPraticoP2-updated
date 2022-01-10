package BLL;

import java.io.Serializable;

public class DonoEmpresa implements Serializable {
    private String nomeDono;
    private String NIFDono;
    private String nTelefoneDono;
    private String moradaDono;
    private String passwordDono;
    private String usernameDono;
    private int idDono;


    public String getNomeDono() {
        return nomeDono;
    }

    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }

    public String getNIFDono() {
        return NIFDono;
    }

    public void setNIFDono(String NIFDono) {
        this.NIFDono = NIFDono;
    }

    public String getnTelefoneDono() {
        return nTelefoneDono;
    }

    public void setnTelefoneDono(String nTelefoneDono) {
        this.nTelefoneDono = nTelefoneDono;
    }

    public String getMoradaDono() {
        return moradaDono;
    }

    public void setMoradaDono(String moradaDono) {
        this.moradaDono = moradaDono;
    }

    public String getPasswordDono() {
        return passwordDono;
    }

    public void setPasswordDono(String passwordDono) {
        this.passwordDono = passwordDono;
    }

    public String getUsernameDono() {
        return usernameDono;
    }

    public void setUsernameDono(String usernameDono) {
        this.usernameDono = usernameDono;
    }

    public int getIdDono() {
        return idDono;
    }

    public void setIdDono(int idDono) {
        this.idDono = idDono;
    }
}
