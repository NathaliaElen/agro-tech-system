package com.agro.tech.system.agrotech.domain.exception.sensor;

public class IntervaloSegundosSensorNaoInformadoException extends RuntimeException {
	public IntervaloSegundosSensorNaoInformadoException() {
		super("Intervalo Segundos do Sensor é obrigatório!");
	}
}
