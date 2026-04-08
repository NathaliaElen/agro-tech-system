package com.agro.tech.system.agrotech.domain.exception.regra;

public class RegraIdNaoInformadaException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public RegraIdNaoInformadaException() {
		super("Regra é obrigatória!");
	}
}
