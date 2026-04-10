package com.agro.tech.system.agrotech.domain.mapper;

import com.agro.tech.system.agrotech.api.dto.request.PerfilRequestDTO;
import com.agro.tech.system.agrotech.api.dto.response.PerfilResponseDTO;
import com.agro.tech.system.agrotech.api.dto.response.UsuarioResponseDTO;
import com.agro.tech.system.agrotech.domain.model.Perfil;
import com.agro.tech.system.agrotech.domain.model.Usuario;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public static List<PerfilResponseDTO> toListDto(List<Perfil> perfis) {
        if (perfis == null) {
            return List.of();
        }

        return perfis.stream()
                .filter(Objects::nonNull)
                .map(PerfilDtoMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}


