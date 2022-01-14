package BLL;

import java.io.Serializable;

public class Animal implements Serializable {
    private String nome;
    private int idade;
    private int nChip;
    private int nifDono;
    private TipoAnimal tipoAnimal;

    public Animal(){}

    public int getNifDono() {
        return nifDono;
    }

    public void setNifDono(int nifDono) {
        this.nifDono = nifDono;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getnChip() {
        return nChip;
    }

    public void setnChip(int nChip) {
        this.nChip = nChip;
    }

    public TipoAnimal getTipoAnimal() {return tipoAnimal;}

    public void setTipoAnimal(TipoAnimal tipoAnimal) {this.tipoAnimal = tipoAnimal;}
}
