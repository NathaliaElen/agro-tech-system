package com.agro.tech.system.agrotech.domain.exception.usuario;

public class UsuarioExistenteException extends RuntimeException {
    public UsuarioExistenteException() {
        super("Email já cadastrado no banco de dados!");
    }
}
