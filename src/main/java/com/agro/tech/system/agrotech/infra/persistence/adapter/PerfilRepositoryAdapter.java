package com.agro.tech.system.agrotech.infra.persistence.adapter;

import com.agro.tech.system.agrotech.domain.model.Perfil;
import com.agro.tech.system.agrotech.domain.repository.PerfilRepository;
import com.agro.tech.system.agrotech.infra.persistence.entity.PerfilEntity;
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
        return jpa.findById(id).map(this::toDomain);
    }

    @Override
    public Optional<Perfil> buscarPorNome(String nome) {
        return jpa.findByName(nome).map(this::toDomain);
    }

    @Override
    public List<Perfil> ListarTodos() {
        return jpa.findAll()
                .stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    public void salvar(Perfil perfil) {
        jpa.save(toEntity(perfil));
    }

    @Override
    public void deletar(String id) {
        jpa.deleteById(id);
    }

    private Perfil toDomain(PerfilEntity entity) {
        return new Perfil(
                entity.getId(),
                entity.getNome(),
                entity.getStatus(),
                entity.getCriadoEm(),
                entity.getCriadoPor(),
                entity.getAtualizadoPor(),
                entity.getAtualizadoEm()
        );
    }

    private PerfilEntity toEntity(Perfil perfil) {
        return new PerfilEntity(
                perfil.getId(),
                perfil.getNome(),
                perfil.getStatus(),
                perfil.getCriadoEm(),
                perfil.getCriadoPor(),
                perfil.getAtualizadoEm(),
                perfil.getAtualizadoPor()
        );
    }
}