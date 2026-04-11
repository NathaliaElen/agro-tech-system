package com.agro.tech.system.agrotech.domain.mapper;

import com.agro.tech.system.agrotech.api.dto.request.UsuarioPerfilRequestDTO;
import com.agro.tech.system.agrotech.api.dto.response.UsuarioPerfilResponseDTO;
import com.agro.tech.system.agrotech.api.dto.response.UsuarioResponseDTO;
import com.agro.tech.system.agrotech.domain.model.Usuario;
import com.agro.tech.system.agrotech.domain.model.UsuarioPerfil;
import com.agro.tech.system.agrotech.infra.persistence.entity.UsuarioPerfilEntity;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UsuarioPerfilDtoMapper {
    public static UsuarioPerfilResponseDTO toResponseDto(UsuarioPerfilEntity usuarioPerfilEntity) {
        return new UsuarioPerfilResponseDTO(
                usuarioPerfilEntity.getId(),
                usuarioPerfilEntity.getUsuarioId(),
                usuarioPerfilEntity.getPerfilId()
        );
    }

    public static UsuarioPerfilEntity toEntity(UsuarioPerfilRequestDTO usuarioPerfilRequestDto) {
        return new UsuarioPerfilEntity(
                usuarioPerfilRequestDto.id(),
                usuarioPerfilRequestDto.usuarioId(),
                usuarioPerfilRequestDto.perfilId(),
                null,
                null,
                null,
                null
        );
    }

    public static UsuarioPerfilRequestDTO toRequestDto(UsuarioPerfil usuarioPerfil) {
        return new UsuarioPerfilRequestDTO(
                usuarioPerfil.getId(),
                usuarioPerfil.getUsuarioId(),
                usuarioPerfil.getPerfilId()
        );
    }

    public static UsuarioPerfil toModel(UsuarioPerfilRequestDTO usuarioPerfilRequestDTO) {
        return new UsuarioPerfil(
                usuarioPerfilRequestDTO.id(),
                usuarioPerfilRequestDTO.usuarioId(),
                usuarioPerfilRequestDTO.perfilId(),
                null,
                null,
                null,
                null
        );
    }

    public static UsuarioPerfilResponseDTO toResponseDto(UsuarioPerfil usuarioPerfil) {
        return new UsuarioPerfilResponseDTO(
                usuarioPerfil.getId(),
                usuarioPerfil.getUsuarioId(),
                usuarioPerfil.getPerfilId()
        );
    }

    public static List<UsuarioPerfilResponseDTO> toListDto(List<UsuarioPerfil> usuariosPerfil) {
        if (usuariosPerfil == null) {
            return List.of();
        }

        return usuariosPerfil.stream()
                .filter(Objects::nonNull)
                .map(UsuarioPerfilDtoMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
