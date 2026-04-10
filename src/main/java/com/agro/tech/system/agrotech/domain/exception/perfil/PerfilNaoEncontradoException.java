package com.agro.tech.system.agrotech.domain.exception.perfil;

public class PerfilNaoEncontradoException extends RuntimeException {
    public PerfilNaoEncontradoException() {
        super("Perfil não encontrado!");
    }
}
