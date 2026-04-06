package com.agro.tech.system.agrotech.domain.model;

import java.time.LocalDateTime;

import com.agro.tech.system.agrotech.domain.enums.Status;
import com.agro.tech.system.agrotech.domain.exception.area.CodigoAreaNaoInformadoException;
import com.agro.tech.system.agrotech.domain.exception.area.NomeAreaNaoInformadoException;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Area {
	private String id;
	private String nome;
	private String codigo;
	private Double latitude;
	private Double longitude;
	private Status status;
	private LocalDateTime criadoEm;
	private LocalDateTime atualizadoEm;
	
	public Area(String id, String nome, String codigo, Double latitude, Double longitude, Status status,
			LocalDateTime criadoEm, LocalDateTime atualizadoEm) {
		super();

		
		// Validar se o nome é nulo ou vazio
		if (nome == null || nome.isBlank()) {
			throw new NomeAreaNaoInformadoException();
		}
		
		// Validar se o código é nulo ou vazio
		if(codigo == null || codigo.isBlank()) {
			throw new CodigoAreaNaoInformadoException();	
		}
		
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
		this.latitude = latitude;
		this.longitude = longitude;
		this.status = status;
		this.criadoEm = criadoEm;
		this.atualizadoEm = atualizadoEm;		
	}
}
