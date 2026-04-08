package com.agro.tech.system.agrotech.infra.persistence.adapter;

import com.agro.tech.system.agrotech.domain.model.Usuario;
import com.agro.tech.system.agrotech.domain.repository.UsuarioRepository;
import com.agro.tech.system.agrotech.infra.persistence.entity.UsuarioEntity;
import com.agro.tech.system.agrotech.infra.persistence.mapper.UsuarioMapper;
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
        return jpa.findById(id).map(UsuarioMapper::toDomain);
    }

    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        return jpa.findByEmail(email).map(UsuarioMapper::toDomain);
    }

    @Override
    public Optional<Usuario> buscarPorNome(String nome) {
        return jpa.findByNome(nome).map(UsuarioMapper::toDomain);
    }

    @Override
    public List<Usuario> ListarTodos() {
        return jpa.findAll().stream().map(UsuarioMapper::toDomain).toList();
    }

    @Override
    public void salvar(Usuario usuario) {
        jpa.save(UsuarioMapper.toEntity(usuario));
    }

    @Override
    public void atualizar(Usuario usuario) {
        jpa.save(UsuarioMapper.toEntity(usuario));
    }

    @Override
    public void deletar(String id) {
        jpa.deleteById(id);
    }

    @Override
    public boolean existeLogin(String email) {
        return jpa.findByEmail(email).isPresent();
    }

}
