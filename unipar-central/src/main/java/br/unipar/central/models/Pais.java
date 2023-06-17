package br.unipar.central.models;

public class Pais {

    private int id;
    private String nome;
    private String sigla;
    private String ra;

    public Pais() {
    }
    
    public Pais(int id){
        this.id = id;
    }

    public Pais(int id, String nome, String sigla, String ra) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.ra = ra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    @Override
    public String toString() {
        return "Pais{" + "id=" + id + ", nome=" + nome + ", sigla=" + sigla + ", ra=" + ra + '}';
    }
    
    
    
    
}
