package com.agro.tech.system.agrotech.domain.exception.area;

public class LatitudeAreaNaoInformadoException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public LatitudeAreaNaoInformadoException() {
			super("Campo Latitude é obrigatorio."); 
		}
	}

