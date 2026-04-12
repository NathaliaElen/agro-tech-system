package com.agro.tech.system.agrotech.api.dto.request;

import java.time.LocalDateTime;

public record UsuarioPerfilCreateRequestDTO(String id, String perfilId, String usuarioId, LocalDateTime criadoEm, String criadoPor) {}
