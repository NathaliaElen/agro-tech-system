package com.agro.tech.system.agrotech.domain.exception.area;

public class NomeAreaNaoInformadoException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public NomeAreaNaoInformadoException() {
		super("Nome da área é obrigatório!");
	}

}
