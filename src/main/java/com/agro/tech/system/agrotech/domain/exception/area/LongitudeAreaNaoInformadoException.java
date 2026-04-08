package com.agro.tech.system.agrotech.domain.exception.area;

public class LongitudeAreaNaoInformadoException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public LongitudeAreaNaoInformadoException() {
		super("Campo Longitude é obrigatorio.");
	}

}
