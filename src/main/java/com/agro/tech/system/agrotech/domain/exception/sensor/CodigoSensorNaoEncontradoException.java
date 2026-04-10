package com.agro.tech.system.agrotech.domain.exception.sensor;

public class CodigoSensorNaoEncontradoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public CodigoSensorNaoEncontradoException() {
		super("Código do Sensor não encontrado!");
	}

}
