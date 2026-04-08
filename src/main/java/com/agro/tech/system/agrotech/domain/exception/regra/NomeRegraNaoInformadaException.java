package com.agro.tech.system.agrotech.domain.exception.regra;

public class NomeRegraNaoInformadaException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public NomeRegraNaoInformadaException() {
		super("Nome da regra é obrigatório!");
	}
		
}
