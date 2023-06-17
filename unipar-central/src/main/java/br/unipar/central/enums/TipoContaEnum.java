package br.unipar.central.enums;

public enum TipoContaEnum {
    
    CONTACORRENTE("1"),
    CONTAPOUPANCA("2"),
    CONTASALARIO("3");
    
    String numero;
    
    TipoContaEnum(String numero){
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    
    
}
