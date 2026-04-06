package com.agro.tech.system.agrotech.infra.persistence.adapter;

import com.agro.tech.system.agrotech.domain.model.Perfil;
import com.agro.tech.system.agrotech.domain.model.Usuario;
import com.agro.tech.system.agrotech.domain.model.UsuarioPerfil;
import com.agro.tech.system.agrotech.domain.repository.UsuarioRepository;
import com.agro.tech.system.agrotech.infra.persistence.entity.PerfilEntity;
import com.agro.tech.system.agrotech.infra.persistence.entity.UsuarioEntity;
import com.agro.tech.system.agrotech.infra.persistence.entity.UsuarioPerfilEntity;
import com.agro.tech.system.agrotech.infra.persistence.repository.JpaUsuarioRepository;
import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UsuarioRepositoryAdapter implements UsuarioRepository {
    private final JpaUsuarioRepository jpa;

    @Override
    public Optional<Usuario> buscarPorId(String id) {
        return jpa.findById(id).map(this::toDomain);
    }

    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        return jpa.findByEmail(email).map(this::toDomain);
    }

    @Override
    public Optional<Usuario> buscarPorNome(String nome) {
        return jpa.findByNome(nome).map(this::toDomain);
    }

    @Override
    public void salvar(Usuario usuario) {
        jpa.save(toEntity(usuario));
    }

    @Override
    public void atualizar(Usuario usuario) {
        jpa.save(toEntity(usuario));
    }

    @Override
    public void deletar(String id) {
        jpa.deleteById(id);
    }

    @Override
    public boolean existeLogin(String email) {
        return jpa.findByEmail(email).isPresent();
    }

    private Usuario toDomain(UsuarioEntity entity) {
        if (entity == null) {
            return null;
        }

        return new Usuario(
                entity.getId(),
                entity.getNome(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getStatus(),
                toDomainPerfis(entity.getPerfis()),
                entity.getCriadoEm(),
                entity.getCriadoPor(),
                entity.getAtualizadoEm(),
                entity.getAtualizadoPor(),
                entity.isAdmin(),
                toDomain(entity.getUsuarioPerfil())
        );
    }


    private UsuarioPerfil toDomain(UsuarioPerfilEntity entity) {
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

    private UsuarioEntity toEntity(Usuario usuario) {
        return new UsuarioEntity(
                        usuario.getId(),
                        usuario.getNome(),
                        usuario.getEmail(),
                        usuario.getSenhaHash(), // ajustar se no domínio for getSenhaHash()
                        usuario.getStatus(),
                        toEntityPerfis(usuario.getPerfis()),
                        usuario.getCriadoEm(),
                        usuario.getCriadoPor(),
                        usuario.getAtualizadoEm(),
                        usuario.getAtualizadoPor(),
                        usuario.isAdmin(),
                        toEntity(usuario.getUsuarioPerfil())
                );
    }

    private List<Perfil> toDomainPerfis(List<PerfilEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return List.of();
        }

        return entities.stream()
                .filter(java.util.Objects::nonNull)
                .map(this::toDomain)
                .toList();
    }

    private Perfil toDomain(PerfilEntity entity) {
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

    private List<PerfilEntity> toEntityPerfis(List<Perfil> perfis) {
        if (perfis == null || perfis.isEmpty()) {
            return List.of();
        }

        return perfis.stream()
                .filter(java.util.Objects::nonNull)
                .map(this::toEntity)
                .toList();
    }

    private PerfilEntity toEntity(Perfil perfil) {
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

    private List<UsuarioPerfilEntity> toEntity(List<UsuarioPerfil> perfis) {
        if (perfis == null) {
            return List.of();
        }
        return perfis.stream().map(this::toEntity).toList();
    }

    private UsuarioPerfilEntity toEntity(UsuarioPerfil usuarioPerfil) {
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
}
