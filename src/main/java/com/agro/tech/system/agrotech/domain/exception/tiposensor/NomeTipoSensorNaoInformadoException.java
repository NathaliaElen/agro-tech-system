package com.agro.tech.system.agrotech.domain.exception.tiposensor;

public class NomeTipoSensorNaoInformadoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public NomeTipoSensorNaoInformadoException() {
		super("Nome do Tipo de Sensor é obrigatório!");
	}
}
