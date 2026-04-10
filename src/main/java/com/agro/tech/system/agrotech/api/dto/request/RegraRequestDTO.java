package com.agro.tech.system.agrotech.api.dto.request;

import java.time.LocalDateTime;

public record RegraRequestDTO(
		String id,
		String nome,
		String descricao,
		String tipoSensorId,
		Double limiteMin,
		Double limiteMax,
		String prioridade,
		String areaId,
		String sensorId,
		String status,
		LocalDateTime criadoEm,
		LocalDateTime atualizadoEm		
		) {}
