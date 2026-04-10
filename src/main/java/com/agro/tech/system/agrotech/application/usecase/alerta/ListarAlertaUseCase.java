package com.agro.tech.system.agrotech.application.usecase.alerta;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.agro.tech.system.agrotech.api.dto.response.AlertaResponseDTO;
import com.agro.tech.system.agrotech.domain.exception.alerta.AlertaIdNaoinformadoException;
import com.agro.tech.system.agrotech.domain.mapper.AlertaMapper;
import com.agro.tech.system.agrotech.domain.repository.AlertaRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ListarAlertaUseCase {
	
	private final AlertaRepository alertaRepository;
	
	public List<AlertaResponseDTO> buscarTodos(){
		
		return alertaRepository.buscarTodos().stream()
				.map(AlertaMapper::mapToResponse)
				.collect(Collectors.toList());
	}
	
	public AlertaResponseDTO buscarPorId(String id) {
		
		var alerta = alertaRepository.buscarPorId(id)
				.orElseThrow(() -> new AlertaIdNaoinformadoException());
		
		return AlertaMapper.mapToResponse(alerta);
				
	}
	
	public List<AlertaResponseDTO> buscarPorTipoSensorId(String tipoSensorId){
		
		return alertaRepository.buscarPorTipoSensorId(tipoSensorId).stream()
				.map(AlertaMapper::mapToResponse)
				.collect(Collectors.toList());
	}
	
	public List<AlertaResponseDTO> buscarPorSensorId(String sensorId){
		
		return alertaRepository.buscarPorSensorId(sensorId).stream()
				.map(AlertaMapper::mapToResponse)
				.collect(Collectors.toList());
	}

	public List<AlertaResponseDTO> buscarPorPrioridade(String prioridade){
		
		return alertaRepository.buscarPorPrioridade(prioridade).stream()
				.map(AlertaMapper::mapToResponse)
				.collect(Collectors.toList());
	}

	public List<AlertaResponseDTO> buscarPorAreaId(String areaId){
		
		return alertaRepository.buscarPorAreaId(areaId).stream()
				.map(AlertaMapper::mapToResponse)
				.collect(Collectors.toList());
	}
	

}
