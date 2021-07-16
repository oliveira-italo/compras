package com.udemy.compras.enuns;

import java.util.Optional;
import java.util.stream.Stream;

public enum CompraStatus {
    OK;

    public static Optional<CompraStatus> fromString(String status) {
        return Stream.of(CompraStatus.values()).filter(it -> it.name().equals(status)).findFirst();
    }
}
