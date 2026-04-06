package com.agro.tech.system.agrotech.domain.exception.area;

public class AreaIdNaoInformadaException extends RuntimeException {
	public AreaIdNaoInformadaException() {
		super("Área Id do Sensor é obrigatória!");
	}
}
