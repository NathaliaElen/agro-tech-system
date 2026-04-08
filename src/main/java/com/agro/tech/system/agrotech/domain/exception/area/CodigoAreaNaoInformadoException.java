package com.agro.tech.system.agrotech.domain.exception.area;

public class CodigoAreaNaoInformadoException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public CodigoAreaNaoInformadoException() {
		super("Código da área é obrigatório!");
	}
}
