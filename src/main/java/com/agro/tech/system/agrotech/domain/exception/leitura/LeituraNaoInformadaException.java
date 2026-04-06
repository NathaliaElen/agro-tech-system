package com.agro.tech.system.agrotech.domain.exception.leitura;

public class LeituraNaoInformadaException extends RuntimeException {
	public LeituraNaoInformadaException() {
		super("Leitura é obrigatória!");
	}
}
