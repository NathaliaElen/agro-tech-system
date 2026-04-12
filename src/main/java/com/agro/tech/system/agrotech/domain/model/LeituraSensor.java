package com.agro.tech.system.agrotech.domain.model;

import java.time.LocalDateTime;

import com.agro.tech.system.agrotech.domain.exception.leiturasensor.ValordNaoInformadoException;
import com.agro.tech.system.agrotech.domain.exception.sensor.SensorIdNaoInformadoException;
import com.agro.tech.system.agrotech.domain.exception.area.AreaIdNaoInformadaException;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class LeituraSensor {
	private String id;
	private String sensorId;
	private String areaId;
	private LocalDateTime dataHora;
	private Double valor;
	
	public LeituraSensor(String id, String sensorId, String areaId, LocalDateTime dataHora, Double valor) {
		super();
		
		if ((sensorId == null) || sensorId.isBlank()) {
			
			throw new SensorIdNaoInformadoException();
		}

		if ((areaId == null) || areaId.isBlank()) {
			
			throw new AreaIdNaoInformadaException();
		}				
		
		if ((valor == null) ) {
			
			throw new ValordNaoInformadoException();
		}	
		
		this.id = id;
		this.sensorId = sensorId;
		this.areaId = areaId;
		this.dataHora = dataHora;
		this.valor = valor;
	}
}
