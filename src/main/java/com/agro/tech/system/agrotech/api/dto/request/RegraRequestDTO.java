package com.agro.tech.system.agrotech.api.dto.request;

import java.time.LocalDateTime;

import com.agro.tech.system.agrotech.domain.enums.Prioridade;
import com.agro.tech.system.agrotech.domain.enums.Status;

public record RegraRequestDTO(
		String id,
		String nome,
		String descricao,
		String tipoSensorId,
		Double limiteMin,
		Double limiteMax,
		Prioridade prioridade,
		String areaId,
		String sensorId,
		Status status,
		LocalDateTime criadoEm,
		LocalDateTime atualizadoEm		
		) {}
