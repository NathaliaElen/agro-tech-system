package com.agro.tech.system.agrotech.domain.exception;

public class UnidadeMedidaTipoSensorNaoInformadoException extends RuntimeException {
	public UnidadeMedidaTipoSensorNaoInformadoException() {
		super("Unidade de media do Tipo de Sensor é obrigatório!");
	}
}
