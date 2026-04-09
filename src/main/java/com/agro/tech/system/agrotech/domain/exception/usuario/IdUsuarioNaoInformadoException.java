package com.agro.tech.system.agrotech.domain.exception.usuario;

public class IdUsuarioNaoInformadoException extends RuntimeException {
    public IdUsuarioNaoInformadoException() {
        super("Id do usuário nao informado!");
    }
}
