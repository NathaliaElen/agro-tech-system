package com.agro.tech.system.agrotech.domain.exception.perfil;

public class PerfilIdNaoInformadoException extends RuntimeException {
    public PerfilIdNaoInformadoException() {
        super("Id do Perfil não informado!");
    }
}
