package com.agro.tech.system.agrotech.domain.model;
import com.agro.tech.system.agrotech.domain.enums.Status;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UsuarioTest {

    @Test
    void deveRetornarTrueQuandoPossuiPerfilIsAdmin() {
        UsuarioPerfil admin = new UsuarioPerfil(
                "u1",
                "p1",
                LocalDateTime.now(),
                "",
                null,
                null,
                true

        );

        Usuario usuario = new Usuario(
                "u1",
                "Dan",
                "dan@email.com",
                "senha",
                Status.ATIVO,
                LocalDateTime.now(),
                "system",
                null,
                null,
                List.of(admin)
        );

        assertTrue(usuario.isAdmin());
    }

    @Test
    void deveRetornarFalseQuandoNaoPossuiPerfilAdmin() {
        UsuarioPerfil user = new UsuarioPerfil(
                "u2",
                "p1",
                LocalDateTime.now(),
                "system",
                null,
                null,
                false
        );

        Usuario usuario = new Usuario(
                "u2",
                "Ana",
                "ana@email.com",
                "senha",
                Status.ATIVO,
                LocalDateTime.now(),
                "system",
                null,
                null,
                List.of(user)
        );

        assertFalse(usuario.isAdmin());
    }

    @Test
    void deveRetornarFalseQuandoListaDePerfisForNula() {
        Usuario usuario = new Usuario(
                "u3",
                "Bob",
                "bob@email.com",
                "senha",
                Status.ATIVO,
                LocalDateTime.now(),
                "system",
                null,
                null,
                null
        );

        assertFalse(usuario.isAdmin());
    }
}