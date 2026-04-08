package com.agro.tech.system.agrotech.domain.exception.area;

public class AreaNaoEncontradaException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
    
	public AreaNaoEncontradaException(String id) {
        super("Área com ID '" + id + "' não encontrada.");
    }
}
