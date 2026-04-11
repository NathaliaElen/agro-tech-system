package com.agro.tech.system.agrotech.domain.exception.sensor;

public class SensorExistenteNaRegraException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public SensorExistenteNaRegraException() {
		super("Não é possível deletar o sensor, pois ele está associado a uma regra.");
	}

}
