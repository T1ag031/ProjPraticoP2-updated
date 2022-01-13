package BLL;

import java.io.Serializable;
import java.util.ArrayList;

public class Empresa implements Serializable {
    private String nome;
    private String nif;
    private String localidade;
    private String nTelefone;
    private int idEmpresa;
    private TipoEmpresa tipo;

    public TipoEmpresa getTipo() {
        return tipo;
    }

    public void setTipo(TipoEmpresa tipo) {
        this.tipo = tipo;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getnTelefone() {
        return nTelefone;
    }

    public void setnTelefone(String nTelefone) {
        this.nTelefone = nTelefone;
    }
}
