package com.agro.tech.system.agrotech.domain.exception.area;

public class AreaExistenteEmSensorException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public AreaExistenteEmSensorException() {
		super("Esta área esta associada a um sensor. Exclusão não permitida!");
	}
}
