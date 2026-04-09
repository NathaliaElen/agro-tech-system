package com.agro.tech.system.agrotech.domain.exception.sensor;

public class CodigoSensorAcimaDoLimiteException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public CodigoSensorAcimaDoLimiteException() {
		super("Limite máximo de carateres (60) atingido");
	}
}
