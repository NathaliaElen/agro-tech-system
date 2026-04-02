package com.agro.tech.system.agrotech.domain.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class LeituraSensor {
	private Long id;
	private Sensor sensorId;
	private Area areaId;
	private LocalDateTime dataHora;
	private Double valor;
	
	public LeituraSensor(Long id, Sensor sensorId, Area areaId, LocalDateTime dataHora, Double valor) {
		super();
		this.id = id;
		this.sensorId = sensorId;
		this.areaId = areaId;
		this.dataHora = dataHora;
		this.valor = valor;
	}
}
