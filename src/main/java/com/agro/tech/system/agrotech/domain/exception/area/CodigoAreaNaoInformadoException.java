package com.agro.tech.system.agrotech.domain.exception.area;

public class CodigoAreaNaoInformadoException extends RuntimeException{

	public CodigoAreaNaoInformadoException() {
		super("Código da área é obrigatório!");
	}
}
