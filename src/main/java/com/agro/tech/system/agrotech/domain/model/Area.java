package com.agro.tech.system.agrotech.domain.model;

import java.time.LocalDateTime;

import com.agro.tech.system.agrotech.domain.enums.Status;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Area {
	private Long id;
	private String nome;
	private String codigo;
	private Double localizacaoLat;
	private Double localizacaoLon;
	private Status status;
	private LocalDateTime criadoEm;
	private LocalDateTime atualizadoEm;
	
	public Area(Long id, String nome, String codigo, Double localizacaoLat, Double localizacaoLon, Status status,
			LocalDateTime criadoEm, LocalDateTime atualizadoEm) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
		this.localizacaoLat = localizacaoLat;
		this.localizacaoLon = localizacaoLon;
		this.status = status;
		this.criadoEm = criadoEm;
		this.atualizadoEm = atualizadoEm;
		
		// Validar se o nome é nulo ou vazio
		if (this.nome == null || this.nome.isBlank()) {
			//throw new 
		}
		
		// Validar se o código é nulo ou vazio
		if(codigo == null || codigo.isBlank()) {
			//throw new		
		}
	}
}
