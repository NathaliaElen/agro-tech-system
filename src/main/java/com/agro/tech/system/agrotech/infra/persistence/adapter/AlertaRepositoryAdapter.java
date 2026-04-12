package com.agro.tech.system.agrotech.infra.persistence.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.agro.tech.system.agrotech.domain.model.Alerta;
import com.agro.tech.system.agrotech.domain.repository.AlertaRepository;
import com.agro.tech.system.agrotech.infra.persistence.entity.LeituraSensorEntity;
import com.agro.tech.system.agrotech.infra.persistence.entity.SensorEntity;
import com.agro.tech.system.agrotech.infra.persistence.mapper.AlertaMapper;
import com.agro.tech.system.agrotech.infra.persistence.repository.JpaAlertaRepository;
import com.agro.tech.system.agrotech.infra.persistence.repository.JpaLeituraSensorRepository;
import com.agro.tech.system.agrotech.infra.persistence.repository.JpaSensorRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AlertaRepositoryAdapter implements AlertaRepository{

    private final JpaAlertaRepository jpaAlertaRepository;
    private final JpaLeituraSensorRepository jpaLeituraSensorRepositoy;
    private final JpaSensorRepository jpaSensorRepository;
    
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
                .collect(Collectors.toList());	
    }
	
	@Override
	public void deletar(String id) {
		jpaAlertaRepository.deleteById(id);
		
	}

	@Override
	public List<Alerta> buscarPorTipoSensorId(String tipoSensorId) {
		return jpaSensorRepository.findByTipoSensorId(tipoSensorId)
				.stream()
				.map(SensorEntity::getId)
				.collect(Collectors.collectingAndThen(
						Collectors.toList(),
						sensorIds -> jpaLeituraSensorRepositoy.findBySensorIdIn(sensorIds)
								.stream()
								.map(LeituraSensorEntity::getId)
								.collect(Collectors.collectingAndThen(
										Collectors.toList(),
										leituraIds -> jpaAlertaRepository.findByLeituraSensorIdIn(leituraIds)
												.stream()
												.map(AlertaMapper::toDomain)
												.collect(Collectors.toList())
								))
				));
	}

	@Override
	public List<Alerta> buscarPorSensorId(String sensorId) {
		return jpaLeituraSensorRepositoy.findBySensorId(sensorId)
				.stream()
				.map(LeituraSensorEntity::getId)
				.collect(Collectors.collectingAndThen(
						Collectors.toList(),
						leituraIds -> jpaAlertaRepository.findByLeituraSensorIdIn(leituraIds)
								.stream()
								.map(AlertaMapper::toDomain)
								.collect(Collectors.toList())
				));
	}

	@Override
	public List<Alerta> buscarPorPrioridade(String prioridade) {
	    return jpaAlertaRepository.findByPrioridade(prioridade)
	            .stream()
	            .map(AlertaMapper::toDomain)
	            .collect(Collectors.toList());	
	}

	@Override
	public List<Alerta> buscarPorAreaId(String areaId) {
		return jpaLeituraSensorRepositoy.findByAreaId(areaId)
				.stream()
				.map(LeituraSensorEntity::getId)
				.collect(Collectors.collectingAndThen(
						Collectors.toList(),
						leituraIds -> jpaAlertaRepository.findByLeituraSensorIdIn(leituraIds)
								.stream()
								.map(AlertaMapper::toDomain)
								.collect(Collectors.toList())
				));
	}

	@Override
	public List<Alerta> buscarPorLeituraSensorId(String leituraSensorId) {
		return jpaAlertaRepository.findByLeituraSensorId(leituraSensorId)
				.stream()
				.map(AlertaMapper::toDomain)
				.collect(Collectors.toList());
	}
    
}
