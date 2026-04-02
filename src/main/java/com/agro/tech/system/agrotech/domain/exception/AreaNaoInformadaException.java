package com.agro.tech.system.agrotech.domain.exception;

public class AreaNaoInformadaException extends RuntimeException {
	public AreaNaoInformadaException() {
		super("Área é obrigatória!");
	}
}
