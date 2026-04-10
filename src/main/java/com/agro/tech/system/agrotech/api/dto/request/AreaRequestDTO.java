package com.agro.tech.system.agrotech.api.dto.request;


public record AreaRequestDTO(
		String id,
		String nome,
		String codigo,
		Double latitude,
		Double longitude,
		String status	
		) {}
