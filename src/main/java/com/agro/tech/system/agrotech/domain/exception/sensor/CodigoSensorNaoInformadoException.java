package com.agro.tech.system.agrotech.domain.exception.sensor;

public class CodigoSensorNaoInformadoException extends RuntimeException {
	public CodigoSensorNaoInformadoException() {
		super("Código do Sensor é obrigatório!");
	}
}
