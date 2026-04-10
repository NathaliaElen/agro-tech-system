package com.agro.tech.system.agrotech.domain.exception.area;

public class AreaExistenteEmSensorException extends RuntimeException{

	public AreaExistenteEmSensorException() {
		super("Esta área esta associada a um sensor. Exclusão não permitida!");
	}
}
