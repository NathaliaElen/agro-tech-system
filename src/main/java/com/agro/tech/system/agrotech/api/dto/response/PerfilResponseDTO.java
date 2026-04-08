package com.agro.tech.system.agrotech.api.dto.response;

import com.agro.tech.system.agrotech.domain.enums.Status;

import java.time.LocalDateTime;

public record PerfilResponseDTO (
    String id,
    String nome,
    Status status,
    LocalDateTime criadoEm,
    String criadoPor,
    LocalDateTime atualizadoEm,
    String atualizadoPor){}
