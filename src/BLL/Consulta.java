package BLL;

import java.io.Serializable;
import java.util.*;

public class Consulta implements Serializable {
    private String dataconsulta;
    private float preco;
    private Date dataPagamento;
    private int nomeVet;
    private String animal;
    private int nConsulta;
    private float totalpreco;
    private String descricao;
    private int nifc;
    private Estado estado;
    private TipoConsulta tipoConsulta;

    //public Consulta() {}


    public int getNifcliente() {
        return nifc;
    }

    public void setNifcliente(int nifc) {
        this.nifc = nifc;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getTotalpreco() {
        return totalpreco;
    }

    public void setTotalpreco(float totalpreco) {
        this.totalpreco = totalpreco;
    }

    public TipoConsulta getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(TipoConsulta tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getDataconsulta() {
        return dataconsulta;
    }

    public void setDataconsulta(String dataconsulta) {
        this.dataconsulta = dataconsulta;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public int getNomeVet() {
        return nomeVet;
    }

    public void setNomeVet(int nomeVet) {
        this.nomeVet = nomeVet;
    }

    public int getnConsulta() {
        return nConsulta;
    }

    public void setnConsulta(int nConsulta) {
        this.nConsulta = nConsulta;
    }
}
