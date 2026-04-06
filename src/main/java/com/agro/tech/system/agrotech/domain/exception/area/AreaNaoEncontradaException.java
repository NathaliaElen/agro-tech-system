package com.agro.tech.system.agrotech.domain.exception.area;

public class AreaNaoEncontradaException extends RuntimeException {

    public AreaNaoEncontradaException(String id) {
        super("Área com ID '" + id + "' não encontrada.");
    }
}
