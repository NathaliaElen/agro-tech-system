package com.agro.tech.system.agrotech.domain.exception.area;

public class LongitudeAreaNaoInformadoException extends RuntimeException{
	
	public LongitudeAreaNaoInformadoException() {
		super("Campo Longitude é obrigatorio.");
	}

}
