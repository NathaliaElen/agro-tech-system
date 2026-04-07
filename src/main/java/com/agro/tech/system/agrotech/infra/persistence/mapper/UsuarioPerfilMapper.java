package com.agro.tech.system.agrotech.infra.persistence.mapper;

import com.agro.tech.system.agrotech.domain.model.UsuarioPerfil;
import com.agro.tech.system.agrotech.infra.persistence.entity.UsuarioPerfilEntity;

public class UsuarioPerfilMapper {

    public static UsuarioPerfilEntity toEntity(UsuarioPerfil perfil) {
        return new UsuarioPerfilEntity(
                perfil.getId(),
                perfil.getUsuarioId(),
                perfil.getPerfilId(),
                perfil.getCriadoEm(),
                perfil.getCriadoPor(),
                perfil.getAtualizadoEm(),
                perfil.getAtualizadoPor()
        );
    }

    public static UsuarioPerfil toDomain(UsuarioPerfilEntity entity) {
        if (entity == null) {
            return null;
        }
        return new UsuarioPerfil(
                entity.getId(),
                entity.getUsuarioId(),
                entity.getPerfilId(),
                entity.getCriadoEm(),
                entity.getCriadoPor(),
                entity.getAtualizadoEm(),
                entity.getAtualizadoPor()
        );
    }
}
