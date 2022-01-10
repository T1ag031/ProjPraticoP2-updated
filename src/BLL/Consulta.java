package BLL;

import java.util.*;

public class Consulta {
    private Date dataconsulta;
    private float preco;
    private Date dataPagamento;
    private String nomeVet;
    private int nConsulta;

    public Consulta() {}

    public Date getDataconsulta() {
        return dataconsulta;
    }

    public void setDataconsulta(Date dataconsulta) {
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

    public String getNomeVet() {
        return nomeVet;
    }

    public void setNomeVet(String nomeVet) {
        this.nomeVet = nomeVet;
    }

    public int getnConsulta() {
        return nConsulta;
    }

    public void setnConsulta(int nConsulta) {
        this.nConsulta = nConsulta;
    }
}
