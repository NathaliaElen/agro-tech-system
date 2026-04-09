package com.agro.tech.system.agrotech.domain.exception.sensor;

public class TipoSensorIdNaoInformadoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public TipoSensorIdNaoInformadoException() {
		super("Tipo Sensor Id é obrigatório!");
	}
}
