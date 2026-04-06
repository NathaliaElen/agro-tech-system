package com.agro.tech.system.agrotech.infra.persistence.adapter;

import com.agro.tech.system.agrotech.domain.model.UsuarioPerfil;
import com.agro.tech.system.agrotech.domain.repository.UsuarioPerfilRepository;
import com.agro.tech.system.agrotech.infra.persistence.entity.UsuarioPerfilEntity;
import com.agro.tech.system.agrotech.infra.persistence.repository.JpaUsuarioPerfilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UsuarioPerfilRepositoryAdapter implements UsuarioPerfilRepository {
    private final JpaUsuarioPerfilRepository jpa;

    @Override
    public Optional<UsuarioPerfil> buscarPorPerfil(String perfilId) {
        return jpa.findByPerfil(perfilId).map(this::toDomain);
    }

    @Override
    public Optional<UsuarioPerfil> buscarPorUsuario(String usuarioId) {
        return jpa.findByUser(usuarioId).map(this::toDomain);
    }

    @Override
    public List<UsuarioPerfil> listarTodos() {
        return jpa.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void salvar(UsuarioPerfil perfil) {
        jpa.save(toEntity(perfil));
    }

    @Override
    public void deletar(String id) {
        jpa.deleteById(id);
    }

    @Override
    public void deletarPorUsuario(String idUsuario) {
        jpa.findByUser(idUsuario).ifPresent(entity -> jpa.deleteById(entity.getUsuarioId()));
    }

    private UsuarioPerfil toDomain(UsuarioPerfilEntity entity) {
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

    private UsuarioPerfilEntity toEntity(UsuarioPerfil perfil) {
        return new UsuarioPerfilEntity(
                perfil.getUsuarioId(),
                perfil.getPerfilId(),
                perfil.getCriadoEm(),
                perfil.getCriadoPor(),
                perfil.getAtualizadoEm(),
                perfil.getAtualizadoPor(),
                perfil.isAdmin()
        );
    }
}
