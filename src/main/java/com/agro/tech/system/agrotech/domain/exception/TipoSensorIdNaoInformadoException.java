package com.agro.tech.system.agrotech.domain.exception;

public class TipoSensorIdNaoInformadoException extends RuntimeException {
	public TipoSensorIdNaoInformadoException() {
		super("Tipo Sensor é obrigatório!");
	}
}
