package com.agro.tech.system.agrotech.api.dto.response;

import com.agro.tech.system.agrotech.domain.enums.Status;

import java.time.LocalDateTime;

public record UsuarioResponseDTO (
            String id,
            String nome,
            String email,
            Status status
        ){ }
