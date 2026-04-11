package com.agro.tech.system.agrotech.domain.mapper;

import com.agro.tech.system.agrotech.api.dto.request.SensorRequestDTO;
import com.agro.tech.system.agrotech.api.dto.response.SensorResponseDTO;
import com.agro.tech.system.agrotech.domain.enums.Status;
import com.agro.tech.system.agrotech.domain.model.Sensor;

public class SensorMapper {
	
	/**
	 * Converte SensorRequestDTO para Sensor (Model)
	 * Usado para criar ou atualizar um sensor
	 */
	public static Sensor toModel(SensorRequestDTO sensorRequestDTO) {
		Status statusEnum = sensorRequestDTO.status() != null 
				? Status.valueOf(sensorRequestDTO.status().toUpperCase()) 
				: Status.ATIVO; // Status padrão
		
		return new Sensor(
				sensorRequestDTO.id(),
				sensorRequestDTO.areaId(),
				sensorRequestDTO.tipoSensorId(),
				sensorRequestDTO.codigo(),
				sensorRequestDTO.intervaloSegundos(),
				statusEnum,
				null, // instaladoEm - definido pela lógica de negócio
				null, // criadoEm - definido pela camada de persistência
				null  // atualizadoEm - definido pela camada de persistência
		);
	}
	
	/**
	 * Converte Sensor para SensorResponseDTO
	 * Usado para retornar dados ao cliente
	 */
	public static SensorResponseDTO toResponseDto(Sensor sensor) {
		return new SensorResponseDTO(
				sensor.getId(),
				sensor.getAreaId(),
				sensor.getTipoSensorId(),
				sensor.getCodigo(),
				sensor.getIntervaloSegundos(),
				sensor.getStatus() != null ? sensor.getStatus().name() : null,
				sensor.getInstaladoEm(),
				sensor.getCriadoEm(),
				sensor.getAtualizadoEm()
		);
	}
	
	/**
	 * Converte Sensor para SensorRequestDTO
	 * Usado para preencher formulários de edição
	 */
	public static SensorRequestDTO toRequestDto(Sensor sensor) {
		return new SensorRequestDTO(
				sensor.getId(),
				sensor.getAreaId(),
				sensor.getTipoSensorId(),
				sensor.getCodigo(),
				sensor.getIntervaloSegundos(),
				sensor.getStatus() != null ? sensor.getStatus().name() : null
		);
	}
}
