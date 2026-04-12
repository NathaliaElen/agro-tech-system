package com.agro.tech.system.agrotech.domain.exception.leiturasensor;

public class ValordNaoInformadoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ValordNaoInformadoException() {
		
		super("Valor da leitura sensor é obrigatório");
	}
}
