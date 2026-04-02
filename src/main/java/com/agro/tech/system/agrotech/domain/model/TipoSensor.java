package com.agro.tech.system.agrotech.domain.model;

import com.agro.tech.system.agrotech.domain.enums.Status;
import com.agro.tech.system.agrotech.domain.exception.NomeTipoSensorNaoInformadoException;
import com.agro.tech.system.agrotech.domain.exception.UnidadeMedidaTipoSensorNaoInformadoException;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TipoSensor {
	private Long id;
	private String nome;
	private String unidadeMedida;
	private String descricao;
	private Status status;
	
	public TipoSensor(Long id, String nome, String unidadeMedida, String descricao, Status status) {
		super();
		this.id = id;
		this.nome = nome;
		this.unidadeMedida = unidadeMedida;
		this.descricao = descricao;
		this.status = status;
		
		// Validar se o nome é nulo ou vazio
		if(nome == null || nome.isBlank()) {
			throw new NomeTipoSensorNaoInformadoException();
		}
		// Validar se a unidade de medidia é nulo ou vazio
		if(unidadeMedida == null || unidadeMedida.isBlank()) {
			throw new UnidadeMedidaTipoSensorNaoInformadoException();
		}
	}
}
