package com.agro.tech.system.agrotech.infra.persistence.mapper;

import com.agro.tech.system.agrotech.domain.model.Perfil;
import com.agro.tech.system.agrotech.domain.model.Usuario;
import com.agro.tech.system.agrotech.domain.model.UsuarioPerfil;
import com.agro.tech.system.agrotech.infra.persistence.entity.PerfilEntity;
import com.agro.tech.system.agrotech.infra.persistence.entity.UsuarioPerfilEntity;

import java.util.List;

public class PerfilMapper {
    public static List<Perfil> toDomainPerfis(List<PerfilEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return List.of();
        }

        return entities.stream()
                .filter(java.util.Objects::nonNull)
                .map(PerfilMapper::toDomain)
                .toList();
    }

    public static Perfil toDomain(PerfilEntity entity) {
        if (entity == null) {
            return null;
        }

        return new Perfil(
                entity.getId(),
                entity.getNome(),
                entity.getStatus(),
                entity.getCriadoEm(),
                entity.getCriadoPor(),
                entity.getAtualizadoEm(),
                entity.getAtualizadoPor()
        );
    }

    public static PerfilEntity toEntity(Perfil perfil) {
        if (perfil == null) {
            return null;
        }

        return new PerfilEntity(
                perfil.getId(),
                perfil.getNome(),
                perfil.getStatus(),
                perfil.getCriadoEm(),
                perfil.getCriadoPor(),
                perfil.getAtualizadoEm(),
                perfil.getAtualizadoPor()
        );
    }

    public static List<PerfilEntity> toEntityPerfis(List<Perfil> perfis) {
        if (perfis == null || perfis.isEmpty()) {
            return List.of();
        }

        return perfis.stream()
                .filter(java.util.Objects::nonNull)
                .map(PerfilMapper::toEntity)
                .toList();
    }

}
