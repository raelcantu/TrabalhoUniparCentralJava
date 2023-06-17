package br.unipar.central.models;

public class Telefone {

    private int id;
    private String numero;
    private int operadora;
    private String ra;
    private Pessoa pessoa;
    private Agencia agencia;

    public Telefone() {
    }

    public Telefone(int id, String numero, String ra,int operadora,  Pessoa pessoa, Agencia agencia) {
        this.id = id;
        this.numero = numero;
        this.operadora = operadora;
        this.ra = ra;
        this.pessoa = pessoa;
        this.agencia = agencia;
    }

    public int getOperadora() {
        return operadora;
    }

    public void setOperadora(int operadora) {
        this.operadora = operadora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    @Override
    public String toString() {
        return "Telefone{" + "id=" + id + ", numero=" + numero + ", ra=" + ra + ", pessoa=" + pessoa + ", agencia=" + agencia + '}';
    }
    
    
    
}
