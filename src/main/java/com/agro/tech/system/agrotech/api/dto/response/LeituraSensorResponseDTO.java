package com.agro.tech.system.agrotech.api.dto.response;

import java.time.LocalDateTime;

public record LeituraSensorResponseDTO(
  String id,
  String sensorId,
  String areaId,
  LocalDateTime dataHora,
  Double valor
) {

}
