package com.agro.tech.system.agrotech.domain.exception.usuario;

public class UsuarioNaoEncontradoException extends RuntimeException {
    public UsuarioNaoEncontradoException(){
        super("Usuario nao encontrado!");
    }
}
