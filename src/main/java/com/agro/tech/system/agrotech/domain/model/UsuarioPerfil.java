package com.agro.tech.system.agrotech.domain.model;

import com.agro.tech.system.agrotech.domain.enums.Status;
import com.agro.tech.system.agrotech.domain.exception.usuarioperfil.PerfilIdNaoInformadoException;
import com.agro.tech.system.agrotech.domain.exception.usuarioperfil.UsuarioIdNaoInformadoException;
import com.agro.tech.system.agrotech.infra.persistence.entity.UsuarioPerfilEntity;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class UsuarioPerfil {
    private Long id;
    private String usuarioId;
    private String perfilId;
    private LocalDateTime criadoEm;
    private String criadoPor;
    private LocalDateTime atualizadoEm;
    private String atualizadoPor;

    public UsuarioPerfil(
             Long id,
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

        if (usuarioId == null) {
            throw new UsuarioIdNaoInformadoException();
        }

        if (perfilId == null) {
            throw new PerfilIdNaoInformadoException();
        }
    }


}
