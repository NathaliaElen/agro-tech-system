package com.agro.tech.system.agrotech.infra.persistence.mapper;

import com.agro.tech.system.agrotech.domain.enums.Prioridade;
import com.agro.tech.system.agrotech.domain.model.Alerta;
import com.agro.tech.system.agrotech.infra.persistence.entity.AlertaEntity;

public class AlertaMapper {
	// "conversão" de entity em domain
	public static Alerta toDomain(AlertaEntity entity) {
		
		if (entity == null) {
			return null;
		}

		return new Alerta(			
				entity.getId(),
				entity.getRegraId(),
				entity.getLeituraSensorId(),
				Prioridade.fromDescricao(entity.getPrioridade()),
				entity.getTitulo(),
				entity.getMensagem(),
				entity.getCriadoEm(),
				entity.getResolvidoEm(),
				entity.getResolvidoUsuarioId()
		);
	}
		
	// "conversão" de domain em entity
	public static AlertaEntity toEntity(Alerta alerta) {
		/*
		 * The constructor AlertaEntity(String, String, String, Prioridade, String, String, LocalDateTime, String) is undefined
		 * */
		return new AlertaEntity(
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
