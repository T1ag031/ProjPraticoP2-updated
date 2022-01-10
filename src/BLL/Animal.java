package BLL;

public class Animal {
    private String nome;
    private int idade;
    private int nChip;
    private String tipoAnimal;

    public Animal(){}

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

    public String getTipoAnimal() {return tipoAnimal;}

    public void setTipoAnimal(String tipoAnimal) {this.tipoAnimal = tipoAnimal;}
}
