package com.agro.tech.system.agrotech.infra.persistence.adapter;

import com.agro.tech.system.agrotech.domain.model.UsuarioPerfil;
import com.agro.tech.system.agrotech.domain.repository.UsuarioPerfilRepository;
import com.agro.tech.system.agrotech.infra.persistence.mapper.UsuarioPerfilMapper;
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
        return jpa.findByPerfil(perfilId).map(UsuarioPerfilMapper::toDomain);
    }

    @Override
    public Optional<UsuarioPerfil> buscarPorUsuario(String usuarioId) {
        return jpa.findByUser(usuarioId).map(UsuarioPerfilMapper::toDomain);
    }

    @Override
    public List<UsuarioPerfil> listarTodos() {
        return jpa.findAll().stream().map(UsuarioPerfilMapper::toDomain).toList();
    }

    @Override
    public void salvar(UsuarioPerfil usuarioPerfil) {
        jpa.save(UsuarioPerfilMapper.toEntity(usuarioPerfil));
    }

    @Override
    public void deletar(Long id) {
        jpa.deleteById(id);
    }

    @Override
    public void deletarPorUsuario(String idUsuario) {
        jpa.findByUser(idUsuario).ifPresent(entity -> jpa.deleteById(entity.getId()));
    }

}
