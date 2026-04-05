package com.agro.tech.system.agrotech.domain.exception.usuarioperfil;

public class PerfilIdNaoInformadoException extends RuntimeException {
    public PerfilIdNaoInformadoException() {
        super("Id do perfil não informado!");
    }
}
