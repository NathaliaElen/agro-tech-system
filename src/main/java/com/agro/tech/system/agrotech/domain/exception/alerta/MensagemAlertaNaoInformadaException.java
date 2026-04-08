package com.agro.tech.system.agrotech.domain.exception.alerta;

public class MensagemAlertaNaoInformadaException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public MensagemAlertaNaoInformadaException() {
		super("Mensagem do alerta é obrigatória!");
	}
}
