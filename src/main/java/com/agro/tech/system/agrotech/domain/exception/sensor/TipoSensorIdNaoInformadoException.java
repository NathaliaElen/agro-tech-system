package com.agro.tech.system.agrotech.domain.exception.sensor;

public class TipoSensorIdNaoInformadoException extends RuntimeException {
	public TipoSensorIdNaoInformadoException() {
		super("Tipo Sensor Id é obrigatório!");
	}
}
