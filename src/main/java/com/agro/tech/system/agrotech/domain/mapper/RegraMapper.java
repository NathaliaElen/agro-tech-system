package com.agro.tech.system.agrotech.domain.mapper;

import com.agro.tech.system.agrotech.api.dto.response.RegraResponseDTO;
import com.agro.tech.system.agrotech.domain.model.Regra;

public class RegraMapper {

	public static RegraResponseDTO mapToResponse(Regra regra) {
		
		return new RegraResponseDTO(
				regra.getId(),
				regra.getNome(),
				regra.getDescricao(),
				regra.getTipoSensorId(),
				regra.getLimiteMin(),
				regra.getLimiteMax(),				
				regra.getPrioridade().getDescricao(),
				regra.getAreaId(),
				regra.getSensorId(),
				regra.getStatus().getDescricao(),
				regra.getCriadoEm(),
				regra.getAtualizadoEm()
				);
		
	}		
}
