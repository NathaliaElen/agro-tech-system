package com.agro.tech.system.agrotech.domain.exception.sensor;

public class CodigoSensorNaoInformadoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public CodigoSensorNaoInformadoException() {
		super("Código do Sensor é obrigatório!");
	}
}
