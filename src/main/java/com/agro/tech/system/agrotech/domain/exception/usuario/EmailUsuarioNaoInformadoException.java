package com.agro.tech.system.agrotech.domain.exception.usuario;

public class EmailUsuarioNaoInformadoException extends RuntimeException {
    public EmailUsuarioNaoInformadoException() {
        super("Email do usuário não informado!");
    }
}
