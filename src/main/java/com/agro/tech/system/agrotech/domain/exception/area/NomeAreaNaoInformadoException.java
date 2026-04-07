package com.agro.tech.system.agrotech.domain.exception.area;

public class NomeAreaNaoInformadoException extends RuntimeException{
	
	public NomeAreaNaoInformadoException() {
		super("Nome da área é obrigatório!");
	}

}
