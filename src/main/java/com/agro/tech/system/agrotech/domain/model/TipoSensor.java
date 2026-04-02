package com.agro.tech.system.agrotech.domain.model;

import com.agro.tech.system.agrotech.domain.enums.Status;
import com.agro.tech.system.agrotech.domain.exception.tiposensor.NomeTipoSensorNaoInformadoException;
import com.agro.tech.system.agrotech.domain.exception.tiposensor.UnidadeMedidaTipoSensorNaoInformadoException;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TipoSensor {
	private String id;
	private String nome;
	private String unidadeMedida;
	private String descricao;
	private Status status;
	
	public TipoSensor(String id, String nome, String unidadeMedida, String descricao, Status status) {
		super();
		this.id = id;
		this.nome = nome;
		this.unidadeMedida = unidadeMedida;
		this.descricao = descricao;
		this.status = status;
		
		if(nome == null || nome.isBlank()) {
			throw new NomeTipoSensorNaoInformadoException();
		}
		
		if(unidadeMedida == null || unidadeMedida.isBlank()) {
			throw new UnidadeMedidaTipoSensorNaoInformadoException();
		}
	}
}
