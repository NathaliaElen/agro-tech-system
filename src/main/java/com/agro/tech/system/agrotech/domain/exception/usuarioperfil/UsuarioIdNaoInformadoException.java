package com.agro.tech.system.agrotech.domain.exception.usuarioperfil;

public class UsuarioIdNaoInformadoException extends RuntimeException {
    public UsuarioIdNaoInformadoException() {
        super("Id do usuário não informado!");
    }
}
