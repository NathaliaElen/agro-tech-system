package com.agro.tech.system.agrotech.domain.exception.area;

public class LatitudeAreaNaoInformadoException extends RuntimeException{
	
	public LatitudeAreaNaoInformadoException() {
			super("Campo Latitude é obrigatorio."); 
		}
	}

