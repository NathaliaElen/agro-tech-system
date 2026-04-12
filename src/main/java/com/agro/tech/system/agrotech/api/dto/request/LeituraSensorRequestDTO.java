package com.agro.tech.system.agrotech.api.dto.request;

public record LeituraSensorRequestDTO(
  String id,
  String sensorId,
  String areaId,
  Double valor
) {

}
