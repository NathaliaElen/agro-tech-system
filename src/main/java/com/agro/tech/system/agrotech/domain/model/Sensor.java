package com.agro.tech.system.agrotech.domain.model;

import java.time.LocalDateTime;

import com.agro.tech.system.agrotech.domain.enums.Status;
import com.agro.tech.system.agrotech.domain.exception.sensor.AreaIdSensorNaoInformadaException;
import com.agro.tech.system.agrotech.domain.exception.sensor.CodigoSensorNaoInformadoException;
import com.agro.tech.system.agrotech.domain.exception.sensor.IntervaloSegundosSensorNaoInformadoException;
import com.agro.tech.system.agrotech.domain.exception.sensor.TipoSensorIdNaoInformadoException;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Sensor {
	private String id;
	private String areaId;
	private String tipoSensorId;
	private String codigo;
	private Integer intervaloSegundos;
	private Status status;
	private LocalDateTime instaladoEm;
	private LocalDateTime criadoEm;
	private LocalDateTime atualizadoEm;
	
	public Sensor(
			String id, 
			String areaId, 
			String tipoSensorId, 
			String codigo, 
			Integer intervaloSegundos, 
			Status status,
			LocalDateTime instaladoEm, 
			LocalDateTime criadoEm, 
			LocalDateTime atualizadoEm
			) {
		
		if(areaId == null || areaId.isBlank()) {
			throw new AreaIdSensorNaoInformadaException();
		}

		if(tipoSensorId == null || tipoSensorId.isBlank()) {
			throw new TipoSensorIdNaoInformadoException();
		}
		
		if(codigo == null || codigo.isBlank()) {
			throw new CodigoSensorNaoInformadoException();
		}
		
		if(intervaloSegundos == null || intervaloSegundos <= 0) {
			throw new IntervaloSegundosSensorNaoInformadoException();
		}
		
		this.id = id;
		this.areaId = areaId;
		this.tipoSensorId = tipoSensorId;
		this.codigo = codigo;
		this.intervaloSegundos = intervaloSegundos;
		this.status = status;
		this.instaladoEm = instaladoEm;
		this.criadoEm = criadoEm;
		this.atualizadoEm = atualizadoEm;
	}
	
	// comportamentos do domínio
	public void ativar() {
		this.status = Status.ATIVO;
		this.atualizadoEm = LocalDateTime.now();
	}
		
	public void desativar() {
		this.status = Status.INATIVO;
		this.atualizadoEm = LocalDateTime.now();
	}
		
	public boolean isAtivo() {
		return this.status == Status.ATIVO;
	}
}
