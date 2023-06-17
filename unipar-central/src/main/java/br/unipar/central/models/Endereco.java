package br.unipar.central.models;

public class Endereco {

    private int id;
    private String ra;
    private String rua;
    private String numero;
    private String bairro;
    private String complemento;
    private String cep;
    private Cidade cidade;
    private Pessoa pessoa;
       
    public Endereco() {
    }

    public Endereco(int id,String ra, String rua, String numero, String bairro, String complemento, String cep, Cidade cidade, Pessoa pessoa) {
        this.id = id;
        this.ra = ra;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.pessoa = pessoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getRa(){
        return ra;
    }
    
    public void setRa(String ra){
        this.ra = ra;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id=" + id + ", rua=" + rua + ", numero=" + numero + ", bairro=" + bairro + ", complemento=" + complemento + ", cep=" + cep + ", cidade=" + cidade + ", pessoa=" + pessoa + '}';
    }

    
    
}
