package com.agro.tech.system.agrotech.api.dto.request;

import com.agro.tech.system.agrotech.domain.enums.Status;

import java.time.LocalDateTime;

public record UsuarioRequestDTO (
            String id,
            String nome,
            String email,
            String senhaHash,
            Status status,
            LocalDateTime criadoEm,
            String criadoPor,
            LocalDateTime atualizadoEm,
            String atualizadoPor
){}

