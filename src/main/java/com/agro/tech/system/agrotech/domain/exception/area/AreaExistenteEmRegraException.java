package com.agro.tech.system.agrotech.domain.exception.area;

public class AreaExistenteEmRegraException extends RuntimeException{
	public AreaExistenteEmRegraException() {
		super("Esta área esta associada a uma regra. Exclusão não permitida!");
	}
}
