package com.agro.tech.system.agrotech.domain.exception.regra;

public class ItensDaRegraNaoInformadaException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ItensDaRegraNaoInformadaException() {
		super("Para compor a regra é necessario selecionar pelo menos um dos itens: Tipo de sensor, Sensor, Area !");
	}

}
