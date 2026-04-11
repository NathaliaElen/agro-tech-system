package com.agro.tech.system.agrotech.domain.exception.tiposensor;

public class NomeTipoSensorNaoEncontradoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public NomeTipoSensorNaoEncontradoException() {
		super("Nome do Tipo de Sensor não encontrado!");
	}

}
