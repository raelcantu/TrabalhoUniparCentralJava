package br.unipar.central.models;

public class Estado {

    private int id;
    private String nome;
    private String sigla;
    private Pais pais;
    private String ra;

    public Estado() {
    }

    public Estado(int id, String nome, String sigla, Pais pais, String ra) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.pais = pais;
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

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    @Override
    public String toString() {
        return "Estado{" + "id=" + id + ", nome=" + nome + ", sigla=" + sigla + ", pais=" + pais + ", ra=" + ra + '}';
    }
    
    

    
    
    
}
