package com.agro.tech.system.agrotech.api.dto.request;

public record TipoSensorRequestDTO(
    String id,
    String nome,
    String unidadeMedida,
    String descricao,
    String status
) {}
