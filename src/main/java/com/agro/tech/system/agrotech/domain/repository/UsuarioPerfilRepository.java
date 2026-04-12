package com.agro.tech.system.agrotech.domain.repository;

import com.agro.tech.system.agrotech.domain.model.UsuarioPerfil;
import com.agro.tech.system.agrotech.infra.persistence.entity.UsuarioPerfilEntity;

import java.util.List;
import java.util.Optional;

public interface UsuarioPerfilRepository {
    Optional<UsuarioPerfil> buscarPorPerfilId(String perfilId);
    Optional<UsuarioPerfil> buscarPorUsuarioId(String usuarioId);
    List<UsuarioPerfil> listarTodos();
    void salvar(UsuarioPerfil perfil);
    void deletarPorPerfilId(String perfilId);
    void deletarPorUsuarioId(String usuarioId);

}
