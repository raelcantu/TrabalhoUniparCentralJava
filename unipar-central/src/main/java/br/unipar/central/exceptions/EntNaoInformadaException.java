package br.unipar.central.exceptions;

public class EntNaoInformadaException extends Exception{

    public EntNaoInformadaException(String entidade){
        super(entidade + " não foi informada(o) e deve ser preenchida(o)");
    }
    
}
