package com.udemy.compras.exception;

public abstract class DomainException extends RuntimeException {

    @Override
    public abstract String getMessage();
}
