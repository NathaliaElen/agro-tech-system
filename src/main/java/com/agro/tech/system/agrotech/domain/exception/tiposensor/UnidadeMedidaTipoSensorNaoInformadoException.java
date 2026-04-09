package com.agro.tech.system.agrotech.domain.exception.tiposensor;

public class UnidadeMedidaTipoSensorNaoInformadoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public UnidadeMedidaTipoSensorNaoInformadoException() {
		super("Unidade de medida do Tipo de Sensor é obrigatório!");
	}
}
