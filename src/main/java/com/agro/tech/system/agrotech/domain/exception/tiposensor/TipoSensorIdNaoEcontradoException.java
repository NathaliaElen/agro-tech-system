package com.agro.tech.system.agrotech.domain.exception.tiposensor;

public class TipoSensorIdNaoEcontradoException extends RuntimeException {
  
  private static final long serialVersionUID = 1L;

  public TipoSensorIdNaoEcontradoException() {
    super("Tipo de Sensor ID informado não encontrado.");
  }
  
}
