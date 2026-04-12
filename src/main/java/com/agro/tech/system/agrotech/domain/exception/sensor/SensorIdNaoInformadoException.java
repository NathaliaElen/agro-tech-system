package com.agro.tech.system.agrotech.domain.exception.sensor;

public class SensorIdNaoInformadoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public SensorIdNaoInformadoException() {
		
		super("Sensor Id não informado!");
	}
}
