package com.agro.tech.system.agrotech.api.dto.request;

import com.agro.tech.system.agrotech.domain.enums.Status;

import java.time.LocalDateTime;

public record PerfilRequestDTO(
        String id,
        String nome,
        Status status,
        LocalDateTime criadoEm,
        String criadoPor,
        LocalDateTime atualizadoEm,
        String atualizadoPor
){}

