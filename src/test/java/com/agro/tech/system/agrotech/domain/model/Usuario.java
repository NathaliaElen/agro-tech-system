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
        Usuario usuario = new Usuario(
                "u2",
                "Ana",
                "ana@email.com",
                "senha",
                Status.ATIVO,
                List.of(),
                LocalDateTime.now(),
                "system",
                null,
                null,
                true,
                null
        );

        assertTrue(usuario.isAdmin());
    }

    @Test
    void deveRetornarFalseQuandoNaoPossuiPerfilAdmin() {

        Usuario usuario = new Usuario(
                "u2",
                "Ana",
                "ana@email.com",
                "senha",
                Status.ATIVO,
                List.of(),
                LocalDateTime.now(),
                "system",
                null,
                null,
                false,
                null
        );

        assertFalse(usuario.isAdmin());
    }

    @Test
    void deveRetornarFalseQuandoListaDePerfisForNula() {
        Usuario usuario = new Usuario(
                "u2",
                "Ana",
                "ana@email.com",
                "senha",
                Status.ATIVO,
                null,
                LocalDateTime.now(),
                "system",
                null,
                null,
                false,
                null
        );

        assertFalse(usuario.getPerfis().isEmpty());
    }
}