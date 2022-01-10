package BLL;

import java.util.*;

public class Diagnostico {
    private String descricao;
    private Date data;

    public Diagnostico() {}

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
