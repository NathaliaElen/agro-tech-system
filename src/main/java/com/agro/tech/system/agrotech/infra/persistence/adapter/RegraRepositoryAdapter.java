package com.agro.tech.system.agrotech.infra.persistence.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.agro.tech.system.agrotech.domain.model.Regra;
import com.agro.tech.system.agrotech.domain.repository.RegraRepository;
import com.agro.tech.system.agrotech.infra.persistence.mapper.RegraMapper;
import com.agro.tech.system.agrotech.infra.persistence.repository.JpaRegraRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RegraRepositoryAdapter implements RegraRepository{

	private final JpaRegraRepository jpaRegraRepository;
	
	@Override
	public Regra salvar(Regra regra) {
		
		return RegraMapper.toDomain(jpaRegraRepository.save(RegraMapper.toEntity(regra)));
	}

	@Override
	public Optional<Regra> buscarPorId(String id) {

		return jpaRegraRepository.findById(id).map(RegraMapper::toDomain);
	}

	@Override
	public List<Regra> buscarTodos() {

		return jpaRegraRepository.findAll().stream()
				.map(RegraMapper::toDomain)
				.collect(Collectors.toList());
	}

	@Override
	public List<Regra> buscarPorTipoSensorId(String tipoSensorId) {

		return jpaRegraRepository.findByTipoSensorId(tipoSensorId).stream()
				.map(RegraMapper::toDomain)
				.collect(Collectors.toList());
	}

	@Override
	public List<Regra> buscarPorSensorId(String sensorId) {
		return jpaRegraRepository.findBySensorId(sensorId).stream()
				.map(RegraMapper::toDomain)
				.collect(Collectors.toList());
	}

	@Override
	public List<Regra> buscarPorPrioridade(String prioridade) {
		return jpaRegraRepository.findByPrioridade(prioridade).stream()
				.map(RegraMapper::toDomain)
				.toList();
	}

	@Override
	public List<Regra> buscarPorAreaId(String areaId) {
		return jpaRegraRepository.findByAreaId(areaId).stream()
				.map(RegraMapper::toDomain)
				.toList();	}

	@Override
	public void deletar(String id) {
		jpaRegraRepository.deleteById(id);
		
	}

}
