package br.unipar.central.models;

public class Agencia {

    private int id;
    private String codigo;
    private String ra;
    private String razaoSocial;
    private String cnpj;
    private Banco banco;
 
    public Agencia() {
    }

    public Agencia(int id, String codigo, String razaoSocial, String cnpj, Banco banco, String ra) {
        this.id = id;
        this.codigo = codigo;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.banco = banco;
        this.ra = ra;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }


    @Override
    public String toString() {
        return "Agencia{" + "id=" + id + ", codigo=" + codigo + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", banco=" + banco + '}';
    }

    
    
    
}
