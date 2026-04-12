package com.agro.tech.system.agrotech.domain.exception.leiturasensor;

public class LeituraSensorIdNaoEncontradoException extends RuntimeException {

  private static final long serialVersionUID = 1L;

	public LeituraSensorIdNaoEncontradoException() {
		super("Leitura de Sensor Id não encontrado!");
	}

}
