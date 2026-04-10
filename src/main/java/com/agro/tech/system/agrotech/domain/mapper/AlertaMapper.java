package com.agro.tech.system.agrotech.domain.mapper;

import com.agro.tech.system.agrotech.api.dto.response.AlertaResponseDTO;
import com.agro.tech.system.agrotech.domain.model.Alerta;

public class AlertaMapper {

	public static AlertaResponseDTO mapToResponse(Alerta alerta) {
		
		return new AlertaResponseDTO(
				alerta.getId(),
				alerta.getRegraId(),
				alerta.getLeituraSensorId(),
				alerta.getPrioridade().getDescricao(),
				alerta.getTitulo(),
				alerta.getMensagem(),
				alerta.getCriadoEm(),
				alerta.getResolvidoEm(),
				alerta.getResolvidoUsuarioId()
				);
	}
		
}
