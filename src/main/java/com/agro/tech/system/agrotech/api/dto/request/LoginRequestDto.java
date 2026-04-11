package com.agro.tech.system.agrotech.api.dto.request;

import com.agro.tech.system.agrotech.domain.model.UsuarioPerfil;

public record LoginRequestDto(
        String email,
        String senha
) {}
