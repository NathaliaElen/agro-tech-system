package com.agro.tech.system.agrotech.infra.persistence.mapper;

import com.agro.tech.system.agrotech.domain.mapper.UsuarioDtoMapper;
import com.agro.tech.system.agrotech.domain.model.Usuario;
import com.agro.tech.system.agrotech.domain.model.UsuarioPerfil;
import com.agro.tech.system.agrotech.infra.persistence.entity.UsuarioEntity;
import com.agro.tech.system.agrotech.infra.persistence.entity.UsuarioPerfilEntity;

import java.util.List;

public class UsuarioMapper {
    public static Usuario toDomain(UsuarioEntity entity) {
        if (entity == null) {
            return null;
        }

        return new Usuario(
                entity.getId(),
                entity.getNome(),
                entity.getEmail(),
                entity.getSenha(),
                entity.getStatus(),
                entity.getCriadoEm(),
                entity.getCriadoPor(),
                entity.getAtualizadoEm(),
                entity.getAtualizadoPor()
        );
    }

    public static UsuarioEntity toEntity(Usuario usuario) {
        return new UsuarioEntity(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenhaHash(), // ajustar se no domínio for getSenhaHash()
                usuario.getStatus(),
                usuario.getCriadoEm(),
                usuario.getCriadoPor(),
                usuario.getAtualizadoEm(),
                usuario.getAtualizadoPor()
        );
    }

    private List<UsuarioPerfilEntity> toEntity(List<UsuarioPerfil> perfis) {
        if (perfis == null) {
            return List.of();
        }
        return perfis.stream().map(UsuarioPerfilMapper::toEntity).toList();
    }

    private static UsuarioPerfilEntity toEntity(UsuarioPerfil usuarioPerfil) {
        if (usuarioPerfil == null) {
            return null;
        }
        return new UsuarioPerfilEntity(
                usuarioPerfil.getId(),
                usuarioPerfil.getUsuarioId(),
                usuarioPerfil.getPerfilId(),
                usuarioPerfil.getCriadoEm(),
                usuarioPerfil.getCriadoPor(),
                usuarioPerfil.getAtualizadoEm(),
                usuarioPerfil.getAtualizadoPor()
        );
    }

    private List<Usuario> toDomain(List<UsuarioEntity> perfis) {
        if (perfis == null) {
            return List.of();
        }
        return perfis.stream().map(UsuarioMapper::toDomain).toList();
    }
}
