package com.agro.tech.system.agrotech.domain.model;

import java.time.LocalDateTime;

import com.agro.tech.system.agrotech.domain.enums.Prioridade;
import com.agro.tech.system.agrotech.domain.enums.Status;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Regra {
	private Long id;
	private String nome;
	private String descricao;
	private Long tipoSensorId;
	private Double limiteMin;
	private Double limiteMax;
	private Prioridade prioridade;
	private Long areaId;
	private Long sensorId;
	private Status status;
	private LocalDateTime criadoEm;
	private LocalDateTime atualizadoEm;
	
	public Regra(Long id, String nome, String descricao, Long tipoSensorId, Double limiteMin, Double limiteMax,
			Prioridade prioridade, Long areaId, Long sensorId, Status status, LocalDateTime criadoEm,
			LocalDateTime atualizadoEm) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.tipoSensorId = tipoSensorId;
		this.limiteMin = limiteMin;
		this.limiteMax = limiteMax;
		this.prioridade = prioridade;
		this.areaId = areaId;
		this.sensorId = sensorId;
		this.status = status;
		this.criadoEm = criadoEm;
		this.atualizadoEm = atualizadoEm;
	}
}
