package com.agro.tech.system.agrotech.api.dto.response;

import java.time.LocalDateTime;


public record AlertaResponseDTO(
	String id,
	String regraId,
	String leituraSensorId,
	String prioridade,
	String titulo,
	String mensagem,
	LocalDateTime criadoEm,
	LocalDateTime resolvidoEm,
	String resolvidoUsuarioId	
){}
