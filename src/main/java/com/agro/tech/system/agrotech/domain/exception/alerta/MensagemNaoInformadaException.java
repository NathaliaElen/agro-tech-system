package com.agro.tech.system.agrotech.domain.exception.alerta;

public class MensagemNaoInformadaException extends RuntimeException{
	public MensagemNaoInformadaException() {
		super("mensagem é obrigatória!");
	}	

}
