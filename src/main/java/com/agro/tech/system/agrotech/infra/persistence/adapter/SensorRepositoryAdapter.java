package com.agro.tech.system.agrotech.infra.persistence.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.agro.tech.system.agrotech.domain.enums.Status;
import com.agro.tech.system.agrotech.domain.model.Sensor;
import com.agro.tech.system.agrotech.domain.repository.SensorRepository;
import com.agro.tech.system.agrotech.infra.persistence.entity.SensorEntity;
import com.agro.tech.system.agrotech.infra.persistence.repository.JpaSensorRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SensorRepositoryAdapter implements SensorRepository {
	private final JpaSensorRepository jpa;

	@Override
	public Sensor salvar(Sensor sensor) {
		return toDomain(jpa.save(toEntity(sensor)));
	}

	@Override
	public Optional<Sensor> buscarPorId(String id) {
		return jpa.findById(id).map(this::toDomain);
	}

	@Override
	public Optional<Sensor> buscarPorCodigo(String codigo) {
		return jpa.findByCodigo(codigo).map(this::toDomain);
	}

	@Override
	public List<Sensor> buscarTodos() {
		return jpa.findAll().stream()
				.map(this::toDomain)
				.collect(Collectors.toList());
	}

	@Override
	public List<Sensor> buscarPorAreaId(String areaId) {
		return jpa.findByAreaId(areaId).stream()
				.map(this::toDomain)
				.collect(Collectors.toList());
	}

	@Override
	public List<Sensor> buscarPorStatus(Status status) {
		return jpa.findByStatus(status).stream()
				.map(this::toDomain)
				.collect(Collectors.toList());
	}

	@Override
	public void deletar(String id) {
		jpa.deleteById(id);
	}
	
	// "conversão" de entity em domain
	private Sensor toDomain(SensorEntity entity) {
		return new Sensor(
					entity.getId(),
					entity.getAreaId(),
					entity.getTipoSensorId(),
					entity.getCodigo(),
					entity.getIntervaloSegundos(),
					entity.getStatus(),
					entity.getInstaladoEm(),
					entity.getCriadoEm(),
					entity.getAtualizadoEm()
				);
	}
	
	// "conversão" de domain em entity
	private SensorEntity toEntity(Sensor sensor) {
		return new SensorEntity(
					sensor.getId(),
					sensor.getAreaId(),
					sensor.getTipoSensorId(),
					sensor.getCodigo(),
					sensor.getIntervaloSegundos(),
					sensor.getStatus(),
					sensor.getInstaladoEm(),
					sensor.getCriadoEm(),
					sensor.getAtualizadoEm()
				);
	}
}
