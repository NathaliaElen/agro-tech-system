package com.agro.tech.system.agrotech.api.dto.request;

import java.time.LocalDateTime;

public record AlertaRequestDTO(
		String id,
		String regraId,
		String leituraSensorId,
		String prioridade,
		String titulo,
		String mensagem,
		LocalDateTime criadoEm,
		LocalDateTime resolvidoEm,
		String resolvidoUsuarioId		
		) {}
