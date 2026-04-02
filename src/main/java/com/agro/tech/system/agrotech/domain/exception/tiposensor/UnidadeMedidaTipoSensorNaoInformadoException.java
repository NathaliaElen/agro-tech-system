package com.agro.tech.system.agrotech.domain.exception.tiposensor;

public class UnidadeMedidaTipoSensorNaoInformadoException extends RuntimeException {
	public UnidadeMedidaTipoSensorNaoInformadoException() {
		super("Unidade de medida do Tipo de Sensor é obrigatório!");
	}
}
