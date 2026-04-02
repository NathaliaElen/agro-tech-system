package com.agro.tech.system.agrotech.domain.exception.usuario;

public class SenhaUsuarioNaoInformadaException extends RuntimeException {
    public SenhaUsuarioNaoInformadaException() { super("Senha do usuário não informada!"); }
}
