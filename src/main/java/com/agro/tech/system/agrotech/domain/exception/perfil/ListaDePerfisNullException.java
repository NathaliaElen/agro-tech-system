package com.agro.tech.system.agrotech.domain.exception.perfil;

public class ListaDePerfisNullException extends RuntimeException {
    public ListaDePerfisNullException() {
        super("Lista de perfis não pode ser nula!");
    }
}
