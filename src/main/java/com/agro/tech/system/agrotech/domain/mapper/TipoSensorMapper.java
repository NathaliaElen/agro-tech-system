package com.agro.tech.system.agrotech.domain.mapper;

import com.agro.tech.system.agrotech.api.dto.request.TipoSensorRequestDTO;
import com.agro.tech.system.agrotech.api.dto.response.TipoSensorResponseDTO;
import com.agro.tech.system.agrotech.domain.enums.Status;
import com.agro.tech.system.agrotech.domain.model.TipoSensor;

public class TipoSensorMapper {

  /**
   *  Converte TipoSensorRequestDTO para TipoSensor (Model)
   * Usado para criar ou atualizar um TipoSensor a partir dos dados recebidos na API.
   */
  public static TipoSensor toModel(TipoSensorRequestDTO tipoSensorRequestDTO) {
    Status statusEnum = tipoSensorRequestDTO.status() != null
        ? Status.valueOf(tipoSensorRequestDTO.status().toUpperCase())
        : Status.ATIVO; // Status padrão

    String id = (tipoSensorRequestDTO.id() == null || tipoSensorRequestDTO.id().isBlank())
        ? null
        : tipoSensorRequestDTO.id();

    return new TipoSensor(
        id,
        tipoSensorRequestDTO.nome(),
        tipoSensorRequestDTO.unidadeMedida(),
        tipoSensorRequestDTO.descricao(),
        statusEnum);

  }

  /**
  * Converte TipoSensor para TipoSensorResponseDTO
  * Usado para retornar dados ao cliente em um formato adequado.
  */
  public static TipoSensorResponseDTO toResponseDto(TipoSensor tipoSensor) {
    return new TipoSensorResponseDTO(
        tipoSensor.getId(),
        tipoSensor.getNome(),
        tipoSensor.getUnidadeMedida(),
        tipoSensor.getDescricao(),
        tipoSensor.getStatus() != null ? tipoSensor.getStatus().name() : null);
  }

  /**
   * Converte TipoSensor para TipoSensorRequestDTO
   * Usado para preencher formulários de edição com os dados atuais do TipoSensor.
   */
  public static TipoSensorRequestDTO toRequestDto(TipoSensor tipoSensor) {
    return new TipoSensorRequestDTO(
        tipoSensor.getId(),
        tipoSensor.getNome(),
        tipoSensor.getUnidadeMedida(),
        tipoSensor.getDescricao(),
        tipoSensor.getStatus() != null ? tipoSensor.getStatus().name() : null);
  }

}
