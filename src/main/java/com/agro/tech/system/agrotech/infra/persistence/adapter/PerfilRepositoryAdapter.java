package com.agro.tech.system.agrotech.infra.persistence.adapter;

import com.agro.tech.system.agrotech.domain.model.Perfil;
import com.agro.tech.system.agrotech.domain.repository.PerfilRepository;
import com.agro.tech.system.agrotech.infra.persistence.mapper.PerfilMapper;
import com.agro.tech.system.agrotech.infra.persistence.repository.JpaPerfilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PerfilRepositoryAdapter implements PerfilRepository {
    private final JpaPerfilRepository jpa;

    @Override
    public Optional<Perfil> buscarPorId(String id) {
        return jpa.findById(id).map(PerfilMapper::toDomain);
    }

    @Override
    public Optional<Perfil> buscarPorNome(String nome) {
        return jpa.findByName(nome).map(PerfilMapper::toDomain);
    }

    @Override
    public List<Perfil> ListarTodos() {
        return jpa.findAll()
                .stream()
                .map(PerfilMapper::toDomain)
                .toList();
    }

    @Override
    public void salvar(Perfil perfil) {
        jpa.save(PerfilMapper.toEntity(perfil));
    }

    @Override
    public void deletar(String id) {
        jpa.deleteById(id);
    }

}