package br.unipar.central.models;

public class Pessoa {

    private int id;
    private String email;
    private String ra;
    
    public Pessoa(int id){
        this.id = id;
    }
    
    public Pessoa(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", email=" + email + ", ra=" + ra + '}';
    }
    
    
}
