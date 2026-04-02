package com.agro.tech.system.agrotech.domain.repository;

import com.agro.tech.system.agrotech.domain.model.Usuario;
import com.agro.tech.system.agrotech.domain.model.UsuarioPerfil;

import java.util.List;
import java.util.Optional;

public interface UsuarioPerfilRepository {
    Optional<UsuarioPerfil> buscarPorUsuario(String idUsuario);
    Optional<UsuarioPerfil> buscarPorNome(String nome);
    List<UsuarioPerfil> listar();
}
