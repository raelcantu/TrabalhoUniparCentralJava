package br.unipar.central.exceptions;

public class TamanhoInvalidoException extends Exception {

    public TamanhoInvalidoException(String entidade, String tamanho){
        super(entidade + " possui tamanho inválido, seu tamanho deve ser " + tamanho);
    }
    
}
