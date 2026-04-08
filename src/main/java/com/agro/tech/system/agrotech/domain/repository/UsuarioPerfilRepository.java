package com.agro.tech.system.agrotech.domain.repository;

import com.agro.tech.system.agrotech.domain.model.UsuarioPerfil;
import com.agro.tech.system.agrotech.infra.persistence.entity.UsuarioPerfilEntity;

import java.util.List;
import java.util.Optional;

public interface UsuarioPerfilRepository {
    Optional<UsuarioPerfil> buscarPorPerfil(String perfilId);
    Optional<UsuarioPerfil> buscarPorUsuario(String usuarioId);
    List<UsuarioPerfil> listarTodos();
    void salvar(UsuarioPerfil perfil);
    void deletar(Long id);
    void deletarPorUsuario(String idUsuario);
}
