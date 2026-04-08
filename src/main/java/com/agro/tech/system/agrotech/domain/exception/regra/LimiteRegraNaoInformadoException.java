package com.agro.tech.system.agrotech.domain.exception.regra;

public class LimiteRegraNaoInformadoException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public LimiteRegraNaoInformadoException() {
		super("Pelo menos um limite da regra deve ser informado !");
	}
}
