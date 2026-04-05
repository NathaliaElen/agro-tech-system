package com.agro.tech.system.agrotech.infra.persistence.adapter;

import com.agro.tech.system.agrotech.domain.model.Usuario;
import com.agro.tech.system.agrotech.domain.model.UsuarioPerfil;
import com.agro.tech.system.agrotech.domain.repository.UsuarioRepository;
import com.agro.tech.system.agrotech.infra.persistence.entity.UsuarioEntity;
import com.agro.tech.system.agrotech.infra.persistence.entity.UsuarioPerfilEntity;
import com.agro.tech.system.agrotech.infra.persistence.repository.JpaUsuarioRepository;
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
        return jpa.findByName(nome).map(this::toDomain);
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
        return new Usuario(
                entity.getId(),
                entity.getNome(),
                entity.getEmail(),
                entity.getPassword(), // em UsuarioEntity: getPassword() retorna senha
                entity.getStatus(),
                entity.getCriadoEm(),
                entity.getCriadoPor(),
                entity.getAtualizadoEm(),
                entity.getAtualizadoPor(),
                toDomain(entity.getUsuarioPerfil())
        );
    }

    private List<UsuarioPerfil> toDomain(List<UsuarioPerfilEntity> entities) {
        if (entities == null) {
            return List.of();
        }
        return entities.stream().map(this::toDomain).toList();
    }

    private UsuarioPerfil toDomain(UsuarioPerfilEntity entity) {
        if (entity == null) {
            return null;
        }
        return new UsuarioPerfil(
                entity.getUsuarioId(),
                entity.getPerfilId(),
                entity.getCriadoEm(),
                entity.getCriadoPor(),
                entity.getAtualizadoEm(),
                entity.getAtualizadoPor(),
                entity.isAdmin()
        );
    }

    private UsuarioEntity toEntity(Usuario usuario) {
        return new UsuarioEntity(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenhaHash(), // ajustar se no domínio for getSenhaHash()
                usuario.getStatus(),
                usuario.getCriadoEm(),
                usuario.getCriadoPor(),
                usuario.getAtualizadoEm(),
                usuario.getAtualizadoPor(),
                toEntity(usuario.getUsuariosPerfil())
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
                usuarioPerfil.getUsuarioId(),
                usuarioPerfil.getPerfilId(),
                usuarioPerfil.getCriadoEm(),
                usuarioPerfil.getCriadoPor(),
                usuarioPerfil.getAtualizadoEm(),
                usuarioPerfil.getAtualizadoPor(),
                usuarioPerfil.isAdmin()
        );
    }
}