package br.unipar.central.models;

import java.sql.Date;

public class Transacao {

    private int id;
    private Date datahora;
    private String ra;
    private long valor;
    private int tipo;
    private Conta contaDestino;
    private Conta contaOrigem;

    public Transacao() {
    }

    public Transacao(int id, Date datahora, String ra, long valor, int tipo, Conta contaDestino, Conta contaOrigem) {
        this.id = id;
        this.datahora = datahora;
        this.ra = ra;
        this.valor = valor;
        this.tipo = tipo;
        this.contaDestino = contaDestino;
        this.contaOrigem = contaOrigem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatahora() {
        return datahora;
    }

    public void setDatahora(Date datahora) {
        this.datahora = datahora;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }


    public Conta getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }

    public Conta getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    @Override
    public String toString() {
        return "Transacao{" + "id=" + id + ", datahora=" + datahora + ", ra=" + ra + ", valor=" + valor + ", tipo=" + tipo + ", contaDestino=" + contaDestino + ", contaOrigem=" + contaOrigem + '}';
    }


}
