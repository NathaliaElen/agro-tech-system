package com.agro.tech.system.agrotech.api.dto.request;

public record SensorRequestDTO(
		String id,
		String areaId,
		String tipoSensorId,
		String codigo,
		Integer intervaloSegundos,
		String status
		) {}
