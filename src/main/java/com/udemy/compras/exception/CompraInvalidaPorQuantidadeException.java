package com.udemy.compras.exception;

public class CompraInvalidaPorQuantidadeException extends DomainException {

    private final Integer quantidade;

    public CompraInvalidaPorQuantidadeException(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String getMessage() {
        return "Compra não pode conter mais que 100 itens [qtd=" + quantidade + "]";
    }
}
