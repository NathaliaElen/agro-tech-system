package com.agro.tech.system.agrotech.domain.mapper;

import java.time.LocalDateTime;

import com.agro.tech.system.agrotech.api.dto.request.LeituraSensorRequestDTO;
import com.agro.tech.system.agrotech.api.dto.response.LeituraSensorResponseDTO;
import com.agro.tech.system.agrotech.domain.model.LeituraSensor;

public class LeituraSensorMapper {
  /**
  * Converter LeituraSensorRequestDTO para LeituraSensor (Model)
  */
  public static LeituraSensor toModel(LeituraSensorRequestDTO leituraSensorRequestDTO) {
    return new LeituraSensor(
        leituraSensorRequestDTO.id(),
        leituraSensorRequestDTO.sensorId(),
        leituraSensorRequestDTO.areaId(),
        LocalDateTime.now(),
        leituraSensorRequestDTO.valor()
    );
  }
  
  /**
  * Converter LeituraSensor para LeituraSensorResponseDTO
  */
  public static LeituraSensorResponseDTO toResponseDto(LeituraSensor leituraSensor) {
    return new LeituraSensorResponseDTO(
        leituraSensor.getId(),
        leituraSensor.getSensorId(),
        leituraSensor.getAreaId(),
        leituraSensor.getDataHora(),
        leituraSensor.getValor());
  }

  /**
  * Converter LeituraSensor para LeituraSensorRequestDTO
  */
 public static LeituraSensorRequestDTO toRequestDto(LeituraSensor leituraSensor) {
    return new LeituraSensorRequestDTO(
        leituraSensor.getId(),
        leituraSensor.getSensorId(),
        leituraSensor.getAreaId(),
        leituraSensor.getValor()
    );
  }

}
