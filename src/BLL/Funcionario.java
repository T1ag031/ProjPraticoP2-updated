package BLL;

import java.io.Serializable;

public class Funcionario implements Serializable {
    private String nomeFun;
    private String NIFFun;
    private String nTelefoneFun;
    private String moradaFun;
    private String passwordFun;
    private String usernameFun;
    private String empresa;
    private int idFuncionario;

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getNomeFun() {
        return nomeFun;
    }

    public void setNomeFun(String nomeFun) {
        this.nomeFun = nomeFun;
    }

    public String getNIFFun() {
        return NIFFun;
    }

    public void setNIFFun(String NIFFun) {
        this.NIFFun = NIFFun;
    }

    public String getnTelefoneFun() {
        return nTelefoneFun;
    }

    public void setnTelefoneFun(String nTelefoneFun) {
        this.nTelefoneFun = nTelefoneFun;
    }

    public String getMoradaFun() {
        return moradaFun;
    }

    public void setMoradaFun(String moradaFun) {
        this.moradaFun = moradaFun;
    }

    public String getPasswordFun() {
        return passwordFun;
    }

    public void setPasswordFun(String passwordFun) {
        this.passwordFun = passwordFun;
    }

    public String getUsernameFun() {
        return usernameFun;
    }

    public void setUsernameFun(String usernameFun) {
        this.usernameFun = usernameFun;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
}
