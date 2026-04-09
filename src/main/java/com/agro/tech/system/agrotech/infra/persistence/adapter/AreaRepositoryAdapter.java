package com.agro.tech.system.agrotech.infra.persistence.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import com.agro.tech.system.agrotech.domain.model.Area;
import com.agro.tech.system.agrotech.domain.repository.AreaRepository;
import com.agro.tech.system.agrotech.infra.persistence.mapper.AreaMapper;
import com.agro.tech.system.agrotech.infra.persistence.repository.JpaAreaRepository;


import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AreaRepositoryAdapter implements AreaRepository {

    private final JpaAreaRepository jpaAreaRepository;
    

    @Override
    public Area salvar(Area area) {
        return AreaMapper.toDomain(jpaAreaRepository.save(AreaMapper.toEntity(area)));
    }

    @Override
    public Optional<Area> buscarPorId(String id) {
        return jpaAreaRepository.findById(id).map(AreaMapper::toDomain);
    }

    @Override
    public List<Area> buscarTodos() {
        return jpaAreaRepository.findAll().stream()
                .map(AreaMapper::toDomain)
                .toList();
    }

    @Override
    public void deletar(String id) {
        jpaAreaRepository.deleteById(id);
    }
}
