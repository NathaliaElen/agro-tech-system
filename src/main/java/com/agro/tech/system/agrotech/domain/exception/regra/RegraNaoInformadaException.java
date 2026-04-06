package com.agro.tech.system.agrotech.domain.exception.regra;

public class RegraNaoInformadaException extends RuntimeException{
	public RegraNaoInformadaException() {
		super("regra é obrigatória!");
	}
}
