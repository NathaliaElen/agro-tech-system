package com.agro.tech.system.agrotech.domain.exception.tiposensor;

public class TipoSensorExistenteNaRegraException extends RuntimeException {
  
  private static final long serialVersionUID = 1L;

  public TipoSensorExistenteNaRegraException() {
    super("Não é possível deletar o Tipo de Sensor, pois existe uma ou mais Regras associadas a ele.");
  }

}
