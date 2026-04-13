package com.agro.tech.system.agrotech.api.dto.request;

import com.agro.tech.system.agrotech.domain.model.Perfil;
import com.agro.tech.system.agrotech.domain.model.UsuarioPerfil;

import java.util.List;

public record LoginResponseDTO(
        String token,
        String tipo,
        String email,
        String nome        
) {}
