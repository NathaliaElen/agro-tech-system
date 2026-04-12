package com.agro.tech.system.agrotech.domain.exception.leiturasensor;

public class LeituraSensorExistenteNoAlertaException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public LeituraSensorExistenteNoAlertaException() {
		super("Leitura de Sensor existente em um alerta.");
	}

}
