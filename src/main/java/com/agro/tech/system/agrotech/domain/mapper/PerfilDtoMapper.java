package com.agro.tech.system.agrotech.domain.mapper;

import com.agro.tech.system.agrotech.api.dto.request.PerfilRequestDTO;
import com.agro.tech.system.agrotech.api.dto.response.PerfilResponseDTO;
import com.agro.tech.system.agrotech.domain.model.Perfil;

public class PerfilDtoMapper {
    public static PerfilRequestDTO toRequestDto(Perfil perfil) {
       return new PerfilRequestDTO(
               perfil.getId(),
               perfil.getNome(),
               perfil.getStatus(),
               perfil.getCriadoEm(),
               perfil.getCriadoPor(),
               perfil.getAtualizadoEm(),
               perfil.getAtualizadoPor()
       );
    }

    public static PerfilRequestDTO toRequestDto(PerfilResponseDTO perfil) {
        return new PerfilRequestDTO(
                perfil.id(),
                perfil.nome(),
                perfil.status(),
                perfil.criadoEm(),
                perfil.criadoPor(),
                perfil.atualizadoEm(),
                perfil.atualizadoPor()
        );
    }

    public static PerfilResponseDTO toResponseDto(Perfil perfil) {
        return new PerfilResponseDTO(
                perfil.getId(),
                perfil.getNome(),
                perfil.getStatus(),
                perfil.getCriadoEm(),
                perfil.getCriadoPor(),
                perfil.getAtualizadoEm(),
                perfil.getAtualizadoPor()
        );
    }

    public static Perfil toModel(PerfilRequestDTO perfil){
        return new Perfil(
                perfil.id(),
                perfil.nome(),
                perfil.status(),
                perfil.criadoEm(),
                perfil.criadoPor(),
                perfil.atualizadoEm(),
                perfil.atualizadoPor()
        );
    }


}


