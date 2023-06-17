package br.unipar.central.models;

public class Conta {

    private int id;
    private String numero;
    private String digito;
    private long saldo;
    private int tipo;
    private String ra;
    private Agencia agencia;
    private Pessoa pessoa;

    public Conta() {
    }

    public Conta(int id) {
        this.id=id;
    }

    public Conta(int id, String numero, String digito, long saldo, int tipo, String ra, Agencia agencia, Pessoa pessoa) {
        this.id = id;
        this.numero = numero;
        this.digito = digito;
        this.saldo = saldo;
        this.tipo = tipo;
        this.ra = ra;
        this.agencia = agencia;
        this.pessoa = pessoa;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDigito() {
        return digito;
    }

    public void setDigito(String digito) {
        this.digito = digito;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "Conta{" + "id=" + id + ", numero=" + numero + ", digito=" + digito + ", saldo=" + saldo + ", tipo=" + tipo + ", ra=" + ra + ", agencia=" + agencia + ", pessoa=" + pessoa + '}';
    }

}
