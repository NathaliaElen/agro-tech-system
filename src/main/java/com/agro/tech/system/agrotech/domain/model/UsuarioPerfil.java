package com.agro.tech.system.agrotech.domain.model;

import com.agro.tech.system.agrotech.domain.exception.perfil.NomeDoPerfilNaoInformadoException;
import com.agro.tech.system.agrotech.domain.exception.usuarioperfil.PerfilIdNaoInformadoException;
import com.agro.tech.system.agrotech.domain.exception.usuarioperfil.UsuarioIdNaoInformadoException;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class UsuarioPerfil {
    private String id;
    private String usuarioId;
    private String perfilId;
    private LocalDateTime criadoEm;
    private String criadoPor;
    private LocalDateTime atualizadoEm;
    private String atualizadoPor;

    public UsuarioPerfil(
            String id,
            String usuarioId,
            String perfilId,
            LocalDateTime criadoEm,
            String criadoPor,
            LocalDateTime atualizadoEm,
            String atualizadoPor) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.perfilId = perfilId;
        this.criadoEm = criadoEm;
        this.criadoPor = criadoPor;
        this.atualizadoEm = atualizadoEm;
        this.atualizadoPor = atualizadoPor;

        if (usuarioId == null || usuarioId.isBlank()) {
            throw new UsuarioIdNaoInformadoException();
        }

        if (perfilId == null || perfilId.isBlank()) {
            throw new PerfilIdNaoInformadoException();
        }
    }
}
