package com.agro.tech.system.agrotech.api.dto.response;

import java.time.LocalDateTime;

public record SensorResponseDTO(
		String id,
		String areaId,
		String tipoSensorId,
		String codigo,
		Integer intervaloSegundos,
		String status,
		LocalDateTime instaladoEm,
		LocalDateTime criadoEm,
		LocalDateTime atualizadoEm
		) {}
