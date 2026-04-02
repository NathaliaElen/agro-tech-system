package com.agro.tech.system.agrotech.domain.repository;

import com.agro.tech.system.agrotech.domain.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository {
    Optional<Usuario> buscarUsuarioPorId(String id);
    Optional<Usuario> buscarUsuarioPorEmail(String nome);
    void salvar(Usuario usuario);
    void atualizar(Usuario usuario);
    void deletar(Usuario usuario);
    boolean existeLogin(String email);
}
