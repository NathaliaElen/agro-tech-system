package com.agro.tech.system.agrotech.infra.persistence.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.agro.tech.system.agrotech.domain.model.Alerta;
import com.agro.tech.system.agrotech.domain.repository.AlertaRepository;
import com.agro.tech.system.agrotech.infra.persistence.mapper.AlertaMapper;
import com.agro.tech.system.agrotech.infra.persistence.repository.JpaAlertaRepository;


import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AlertaRepositoryAdapter implements AlertaRepository{

    private final JpaAlertaRepository jpaAlertaRepository;

    
	@Override
	public Alerta salvar(Alerta alerta) {
		return AlertaMapper.toDomain(jpaAlertaRepository.save(AlertaMapper.toEntity(alerta)));		
	}
	
	@Override
	public Optional<Alerta> buscarPorId(String id) {

		return jpaAlertaRepository.findById(id).map(AlertaMapper::toDomain);
	}
	
	@Override
	public List<Alerta> buscarTodos() {
        return jpaAlertaRepository.findAll().stream()
                .map(AlertaMapper::toDomain)
                .toList();	}
	
	@Override
	public void deletar(String id) {
		jpaAlertaRepository.deleteById(id);
		
	}

	@Override
	public List<Alerta> buscarPorTipoSensorId(String tipoSensorId) {
	    return jpaAlertaRepository.findByTipoSensorId(tipoSensorId)
	            .stream()
	            .map(AlertaMapper::toDomain)
	            .toList();
	}

	@Override
	public List<Alerta> buscarPorSensorId(String sensorId) {
	    return jpaAlertaRepository.findBySensorId(sensorId)
	            .stream()
	            .map(AlertaMapper::toDomain)
	            .toList();	}

	@Override
	public List<Alerta> buscarPorPrioridade(String prioridade) {
	    return jpaAlertaRepository.findByPrioridade(prioridade)
	            .stream()
	            .map(AlertaMapper::toDomain)
	            .toList();	
	}

	@Override
	public List<Alerta> buscarPorAreaId(String areaId) {
	    return jpaAlertaRepository.findByAreaId(areaId)
	            .stream()
	            .map(AlertaMapper::toDomain)
	            .toList();	
	}
    
}
