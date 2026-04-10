package com.agro.tech.system.agrotech.domain.model;
import com.agro.tech.system.agrotech.domain.enums.Status;
import com.agro.tech.system.agrotech.domain.exception.perfil.ListaDePerfisNullException;
import com.agro.tech.system.agrotech.domain.exception.usuario.EmailUsuarioInvalidoException;
import com.agro.tech.system.agrotech.domain.exception.usuario.NomeUsuarioNaoInformadoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsuarioTest {

    @Test
    @DisplayName("Deve Retornar True Quando é Admin")
    void deveRetornarTrueQuandoPossuiPerfilIsAdmin() {
        Usuario usuario = new Usuario(
                "u2",
                "Ana",
                "ana@email.com",
                "senha",
                Status.ATIVO,
                List.of(new Perfil(
                        "1",
                        "ADMIN",
                        Status.ATIVO,
                        LocalDateTime.now(),
                        "Nelson",
                        null,
                        null

                )),
                LocalDateTime.now(),
                "system",
                null,
                null

        );

        assertTrue(usuario.isAdmin());
    }

    @Test
    @DisplayName("Deve Retornar False Quando não é Admin")
    void deveRetornarFalseQuandoNaoPossuiPerfilAdmin() {

        Usuario usuario = new Usuario(
                "u2",
                "Ana",
                "ana@email.com",
                "senha",
                Status.ATIVO,
                List.of(new Perfil(
                        "1",
                        "USER",
                        Status.ATIVO,
                        LocalDateTime.now(),
                        "Nelson",
                        null,
                        null

                )),
                LocalDateTime.now(),
                "system",
                null,
                null

        );

        assertFalse(usuario.isAdmin());
    }

    @Test
    @DisplayName("Deve lançar exception quando a lista de perfis for nula")
    void deveLancarExceptionQuandoListaDePerfisForNula() {
        assertThrows(ListaDePerfisNullException.class, () -> new Usuario(
                "u2",
                "Ana",
                "ana@email.com",
                "senha",
                Status.ATIVO,
                null,
                LocalDateTime.now(),
                "system",
                null,
                null
        ));
    }

    @Test
    @DisplayName("Deve lançar exception quando o nome do usuário for nulo")
    void deveLancarExceptionQuandoNomeDoUsuarioForNulo() {
        assertThrows(NomeUsuarioNaoInformadoException.class, () -> new Usuario(
                "u2",
                null,
                "ana@email.com",
                "senha",
                Status.ATIVO,
                List.of(),
                LocalDateTime.now(),
                "system",
                null,
                null
        ));
    }

    @Test
    @DisplayName("Deve lançar exception quando o email for inválido")
    void deveLancarExceptionQuandoEmailInvalido() {
        assertThrows(EmailUsuarioInvalidoException.class, () -> new Usuario(
                "u2",
                "teste",
                "ana@email",
                "senha",
                Status.ATIVO,
                List.of(),
                LocalDateTime.now(),
                "system",
                null,
                null
        ));
    }
}