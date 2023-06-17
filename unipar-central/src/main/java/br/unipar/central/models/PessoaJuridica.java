package br.unipar.central.models;

public class PessoaJuridica extends Pessoa {

    private String razaoSocial;
    private String cnpj;
    private String cnaePrincipal;
    private String fantasia;
    private Pessoa pessoa;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String razaoSocial, Pessoa pessoa, String cnpj, String cnaePrincipal, String fantasia) {
        this.razaoSocial = razaoSocial;
        this.pessoa = pessoa;
        this.cnpj = cnpj;
        this.cnaePrincipal = cnaePrincipal;
        this.fantasia = fantasia;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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

    public String getCnaePrincipal() {
        return cnaePrincipal;
    }

    public void setCnaePrincipal(String cnaePrincipal) {
        this.cnaePrincipal = cnaePrincipal;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" + "razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", cnaePrincipal=" + cnaePrincipal + ", fantasia=" + fantasia + ", pessoa=" + pessoa + '}';
    }

}
