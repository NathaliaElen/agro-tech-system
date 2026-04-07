package com.agro.tech.system.agrotech.infra.persistence.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.agro.tech.system.agrotech.domain.enums.Status;
import com.agro.tech.system.agrotech.domain.model.Sensor;
import com.agro.tech.system.agrotech.domain.repository.SensorRepository;
import com.agro.tech.system.agrotech.infra.persistence.mapper.SensorMapper;
import com.agro.tech.system.agrotech.infra.persistence.repository.JpaSensorRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SensorRepositoryAdapter implements SensorRepository {
	private final JpaSensorRepository jpa;

	@Override
	public Sensor salvar(Sensor sensor) {
		return SensorMapper.toDomain(jpa.save(SensorMapper.toEntity(sensor)));
	}

	@Override
	public Optional<Sensor> buscarPorId(String id) {
		return jpa.findById(id).map(SensorMapper::toDomain);
	}

	@Override
	public Optional<Sensor> buscarPorCodigo(String codigo) {
		return jpa.findByCodigo(codigo).map(SensorMapper::toDomain);
	}

	@Override
	public List<Sensor> buscarTodos() {
		return jpa.findAll().stream()
				.map(SensorMapper::toDomain)
				.collect(Collectors.toList());
	}

	@Override
	public List<Sensor> buscarPorAreaId(String areaId) {
		return jpa.findByAreaId(areaId).stream()
				.map(SensorMapper::toDomain)
				.collect(Collectors.toList());
	}

	@Override
	public List<Sensor> buscarPorStatus(Status status) {
		return jpa.findByStatus(status).stream()
				.map(SensorMapper::toDomain)
				.collect(Collectors.toList());
	}

	@Override
	public void deletar(String id) {
		jpa.deleteById(id);
	}
}
