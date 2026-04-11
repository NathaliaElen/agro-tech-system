package com.agro.tech.system.agrotech.infra.persistence.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.agro.tech.system.agrotech.domain.model.TipoSensor;
import com.agro.tech.system.agrotech.domain.repository.TipoSensorRepository;
import com.agro.tech.system.agrotech.infra.persistence.mapper.TipoSensorMapper;
import com.agro.tech.system.agrotech.infra.persistence.repository.JpaTipoSensorRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TipoSensorRepositoryAdapter implements TipoSensorRepository {
	private final JpaTipoSensorRepository jpa;
	
	@Override
	public TipoSensor salvar(TipoSensor tipoSensor) {
		return TipoSensorMapper.toDomain(jpa.save(TipoSensorMapper.toEntity(tipoSensor)));
	}

	@Override
	public Optional<TipoSensor> buscarPorId(String id) {
		return jpa.findById(id).map(TipoSensorMapper::toDomain);
	}

	@Override
	public Optional<TipoSensor> buscarPorNome(String nome) {
		return jpa.findByNome(nome).map(TipoSensorMapper::toDomain);
	}

	@Override
	public List<TipoSensor> buscarTodos() {
		return jpa.findAll().stream()
				.map(TipoSensorMapper::toDomain)
				.collect(Collectors.toList());
	}

	@Override
	public List<TipoSensor> buscarPorStatus(String status) {
		return jpa.findByStatus(status).stream()
				.map(TipoSensorMapper::toDomain)
				.collect(Collectors.toList());
	}

	@Override
	public void deletar(String id) {
		jpa.deleteById(id);
	}
}
