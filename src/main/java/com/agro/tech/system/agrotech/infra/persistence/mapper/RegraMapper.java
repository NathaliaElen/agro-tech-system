package com.agro.tech.system.agrotech.infra.persistence.mapper;

import java.time.LocalDateTime;

import com.agro.tech.system.agrotech.domain.enums.Prioridade;
import com.agro.tech.system.agrotech.domain.enums.Status;
import com.agro.tech.system.agrotech.domain.model.Regra;
import com.agro.tech.system.agrotech.infra.persistence.entity.RegraEntity;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class RegraMapper {


	// "conversão" de entity em domain
	public static Regra toDomain(RegraEntity entity) {
	
		if (entity == null) {
			return null;
		}
		/*
		 * 	public Regra(String id, String nome, String descricao, String tipoSensorId, Double limiteMin, Double limiteMax,
			Prioridade prioridade, String areaId, String sensorId, Status status, LocalDateTime criadoEm,
			LocalDateTime atualizadoEm)
		 * */
		return new Regra(			
				entity.getId(),
				entity.getNome(),
				entity.getDescricao(),
				entity.getTipoSensorId(),
				entity.getLimiteMin(),
				entity.getLimiteMax(),				
				Prioridade.fromDescricao(entity.getPrioridade()),
				entity.getAreaId(),
				entity.getSensorId(),
				Status.fromDescricao(entity.getStatus()),
				entity.getCriadoEm(),
				entity.getAtualizadoEm()
		);
	}
	
	// "conversão" de domain em entity
	public static RegraEntity toEntity(Regra regra) {
		return new RegraEntity(
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
