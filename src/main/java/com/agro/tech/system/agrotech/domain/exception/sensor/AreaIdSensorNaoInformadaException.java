package com.agro.tech.system.agrotech.domain.exception.sensor;

public class AreaIdSensorNaoInformadaException extends RuntimeException {
	public AreaIdSensorNaoInformadaException() {
		super("Área Id do Sensor é obrigatória!");
	}
}
