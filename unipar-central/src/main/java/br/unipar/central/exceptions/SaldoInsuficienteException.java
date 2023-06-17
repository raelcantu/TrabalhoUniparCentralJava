package br.unipar.central.exceptions;

public class SaldoInsuficienteException extends Exception {

    public SaldoInsuficienteException(long saldo, long valor) {
        super("Saldo insuficiente, seu saldo é de: "+ saldo + "r$ e sua transferência é de " + valor + "r$");
    }

}
