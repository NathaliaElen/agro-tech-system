package com.agro.tech.system.agrotech.domain.exception.sensor;

public class SensorIdNaoEncontradoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public SensorIdNaoEncontradoException() {
		super("Sensor Id não encontrado!");
	}
}
