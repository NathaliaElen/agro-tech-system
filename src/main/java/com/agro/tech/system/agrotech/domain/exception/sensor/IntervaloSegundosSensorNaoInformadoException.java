package com.agro.tech.system.agrotech.domain.exception.sensor;

public class IntervaloSegundosSensorNaoInformadoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public IntervaloSegundosSensorNaoInformadoException() {
		super("Intervalo Segundos do Sensor é obrigatório!");
	}
}
