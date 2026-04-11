package com.agro.tech.system.agrotech.api.dto.response;

public record TipoSensorResponseDTO(
    String id,
    String nome,
    String unidadeMedida,
    String descricao,
    String status
) {}
