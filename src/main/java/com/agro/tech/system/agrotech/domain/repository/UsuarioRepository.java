package com.agro.tech.system.agrotech.domain.repository;

import com.agro.tech.system.agrotech.domain.model.Usuario;
import java.util.Optional;

public interface UsuarioRepository {
    Optional<Usuario> buscarPorId(String id);
    Optional<Usuario> buscarPorEmail(String email);
    Optional<Usuario> buscarPorNome(String nome);
    void salvar(Usuario usuario);
    void atualizar(Usuario usuario);
    void deletar(String id);
    boolean existeLogin(String email);
}
