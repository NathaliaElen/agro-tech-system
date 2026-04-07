package com.agro.tech.system.agrotech.domain.exception.tiposensor;

public class NomeTipoSensorNaoInformadoException extends RuntimeException {
	public NomeTipoSensorNaoInformadoException() {
		super("Nome do Tipo de Sensor é obrigatório!");
	}
}
