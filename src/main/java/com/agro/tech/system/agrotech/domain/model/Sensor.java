package com.agro.tech.system.agrotech.domain.model;

import java.time.LocalDateTime;

import com.agro.tech.system.agrotech.domain.enums.Status;
import com.agro.tech.system.agrotech.domain.exception.AreaNaoInformadaException;
import com.agro.tech.system.agrotech.domain.exception.TipoSensorIdNaoInformadoException;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Sensor {
	private Long id;
	private Long areaId;
	private Long tipoSensorId;
	private String codigo;
	private Integer intervaloSegundos;
	private Status status;
	private LocalDateTime instaladoEm;
	private LocalDateTime criadoEm;
	private LocalDateTime atualizadoEm;
	
	public Sensor(
			Long id, 
			Long areaId, 
			Long tipoSensorId, 
			String codigo, 
			Integer intervaloSegundos, 
			Status status,
			LocalDateTime instaladoEm, 
			LocalDateTime criadoEm, 
			LocalDateTime atualizadoEm
			) {
		super();
		this.id = id;
		this.areaId = areaId;
		this.tipoSensorId = tipoSensorId;
		this.codigo = codigo;
		this.intervaloSegundos = intervaloSegundos;
		this.status = status;
		this.instaladoEm = instaladoEm;
		this.criadoEm = criadoEm;
		this.atualizadoEm = atualizadoEm;
		
		// Validar se a área id é nulo
		if(areaId == null) {
			throw new AreaNaoInformadaException();
		}
		// Validar se o tipo do sensor é nulo
		if(tipoSensorId == null) {
			throw new TipoSensorIdNaoInformadoException();
		}
		// Validar se o código é nulo ou vazio
		if(codigo == null || codigo.isBlank()) {
			
		}
		// Validar se o intervalo é diferente denulo ou menor que 0, não pode ser negativo
		if(intervaloSegundos <= 0) {
			
		}
	}
	
	//comportamentos do domínio
	public void ativarStatus() {
		this.status = Status.ATIVO;
	}
		
	public void desativarStatus() {
		this.status = Status.INATIVO;
	}
		
	public Status isStatus() {
		return status;
	}
	
}
