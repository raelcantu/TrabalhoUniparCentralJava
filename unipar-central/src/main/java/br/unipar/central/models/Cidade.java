package br.unipar.central.models;

public class Cidade {

    private int id;
    private String nome;
    private Estado estado;
    private String ra;

    public Cidade() {
    }

    public Cidade(int id) {
        this.id = id;
    }

    public Cidade(int id, String nome, Estado estado, String ra) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    @Override
    public String toString() {
        return "Cidade{" + "id=" + id + ", nome=" + nome + ", estado=" + estado + ", ra=" + ra + '}';
    }

}
