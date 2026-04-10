package com.agro.tech.system.agrotech.domain.exception.alerta;

public class AlertaIdNaoinformadoException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	public AlertaIdNaoinformadoException() {
		super("Alerta é obrigatório!");
		
	}

}
