package com.agro.tech.system.agrotech.domain.repository;

import java.util.List;
import java.util.Optional;

import com.agro.tech.system.agrotech.domain.model.Usuario;
import com.agro.tech.system.agrotech.infra.persistence.entity.UsuarioEntity;

public interface UsuarioRepository {
    Optional<Usuario> buscarPorId(String id);
    Optional<Usuario> buscarPorEmail(String email);
    Optional<Usuario> buscarPorNome(String nome);
    List<Usuario> ListarTodos();
    void salvar(Usuario usuario);
    void atualizar(Usuario usuario);
    void deletar(String id);
    boolean existeLogin(String email);
}
