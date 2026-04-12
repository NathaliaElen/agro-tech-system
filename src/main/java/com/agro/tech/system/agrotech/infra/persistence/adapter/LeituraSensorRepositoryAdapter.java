package com.agro.tech.system.agrotech.infra.persistence.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import com.agro.tech.system.agrotech.domain.model.LeituraSensor;
import com.agro.tech.system.agrotech.domain.repository.LeituraSensorRepository;
import com.agro.tech.system.agrotech.infra.persistence.mapper.LeituraSensorMapper;
import com.agro.tech.system.agrotech.infra.persistence.repository.JpaLeituraSensorRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LeituraSensorRepositoryAdapter implements LeituraSensorRepository{

	private final JpaLeituraSensorRepository jpaLeituraSensorRepository;
	
	@Override
	public LeituraSensor salvar(LeituraSensor leituraSensor) {
				
		return LeituraSensorMapper.toDomain(jpaLeituraSensorRepository.save(LeituraSensorMapper.toEntity(leituraSensor)));
	}

	@Override
	public Optional<LeituraSensor> buscarPorId(String id) {

		return jpaLeituraSensorRepository.findById(id)
				.map(LeituraSensorMapper::toDomain);
	}

	@Override
	public List<LeituraSensor> buscarTodos() {

        return jpaLeituraSensorRepository.findAll().stream()
                .map(LeituraSensorMapper::toDomain)
                .collect(Collectors.toList());
	}

	@Override
	public List<LeituraSensor> buscarPorSensorId(String sensorId) {

	       return jpaLeituraSensorRepository.findBySensorId(sensorId).stream()
	                .map(LeituraSensorMapper::toDomain)
	                .collect(Collectors.toList());
	}

	@Override
	public List<LeituraSensor> buscarPorAreaId(String areaId) {

       return jpaLeituraSensorRepository.findByAreaId(areaId).stream()
                .map(LeituraSensorMapper::toDomain)
                .collect(Collectors.toList());

	}

	@Override
	public void deletar(String id) {
		
		jpaLeituraSensorRepository.deleteById(id);
		
	}

}
