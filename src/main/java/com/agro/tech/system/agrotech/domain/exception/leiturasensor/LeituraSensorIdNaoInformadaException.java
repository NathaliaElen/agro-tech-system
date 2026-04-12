package com.agro.tech.system.agrotech.domain.exception.leiturasensor;

public class LeituraSensorIdNaoInformadaException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public LeituraSensorIdNaoInformadaException() {
		super("Leitura é obrigatório!");
	}	
}
