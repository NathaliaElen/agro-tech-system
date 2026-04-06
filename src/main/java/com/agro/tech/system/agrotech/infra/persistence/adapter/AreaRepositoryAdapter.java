package com.agro.tech.system.agrotech.infra.persistence.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.agro.tech.system.agrotech.domain.model.Area;
import com.agro.tech.system.agrotech.domain.repository.AreaRepository;
import com.agro.tech.system.agrotech.infra.persistence.mapper.AreaMapper;
import com.agro.tech.system.agrotech.infra.persistence.repository.JpaAreaRepository;

/**
 * Adaptador de saída (Output Adapter) — Hexagonal Architecture.
 * Implementa a porta AreaRepository usando JPA + DB2.
 */
@Repository
public class AreaRepositoryAdapter implements AreaRepository {

    private final JpaAreaRepository jpaAreaRepository;
    private final AreaMapper mapper;

    public AreaRepositoryAdapter(JpaAreaRepository jpaAreaRepository, AreaMapper mapper) {
        this.jpaAreaRepository = jpaAreaRepository;
        this.mapper = mapper;
    }

    @Override
    public Area salvar(Area area) {
        return mapper.toDomain(jpaAreaRepository.save(mapper.toEntity(area)));
    }

    @Override
    public Optional<Area> buscarPorId(String id) {
        return jpaAreaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Area> buscarTodos() {
        return jpaAreaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void deletar(String id) {
        jpaAreaRepository.deleteById(id);
    }
}
