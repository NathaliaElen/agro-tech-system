package com.agro.tech.system.agrotech.api.dto.response;

import java.time.LocalDateTime;



public record RegraResponseDTO(
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
