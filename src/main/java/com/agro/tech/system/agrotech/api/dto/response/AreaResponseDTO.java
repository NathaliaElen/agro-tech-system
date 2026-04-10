package com.agro.tech.system.agrotech.api.dto.response;

import java.time.LocalDateTime;


public record AreaResponseDTO(
		String id,
		String nome,
		String codigo,
		Double latitude,
		Double longitude,
		String status,
		LocalDateTime criadoEm,
		LocalDateTime atualizadoEm		
		) {}
