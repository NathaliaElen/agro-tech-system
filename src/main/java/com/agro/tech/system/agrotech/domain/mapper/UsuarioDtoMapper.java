package com.agro.tech.system.agrotech.domain.mapper;

import com.agro.tech.system.agrotech.api.dto.request.UsuarioRequestDTO;
import com.agro.tech.system.agrotech.api.dto.response.UsuarioResponseDTO;
import com.agro.tech.system.agrotech.domain.model.Usuario;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UsuarioDtoMapper {
    public static Usuario toModel(UsuarioResponseDTO usuarioResponseDTO) {
        return new Usuario(
                null,
                usuarioResponseDTO.nome(),
                usuarioResponseDTO.email(),
                usuarioResponseDTO.senha(),
                usuarioResponseDTO.status(),
                null,
                null,
                null,
                null
        );
    }

    // Novo: mapeia direto do request DTO para o modelo de domínio
    public static Usuario toModel(UsuarioRequestDTO usuarioDto) {
        return new Usuario(
                usuarioDto.id(),
                usuarioDto.nome(),
                usuarioDto.email(),
                usuarioDto.senhaHash(),
                usuarioDto.status(),
                null,
                null,
                null,
                null
        );
    }

    public static UsuarioResponseDTO toResponseDto(UsuarioRequestDTO usuarioDto) {
        return new UsuarioResponseDTO(
                usuarioDto.id(),
                usuarioDto.nome(),
                usuarioDto.email(),
                usuarioDto.senhaHash(),
                usuarioDto.status()
        );
    }

    public static UsuarioResponseDTO toResponseDto(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenhaHash(),
                usuario.getStatus()
        );
    }

    public static List<UsuarioResponseDTO> toListDto(List<Usuario> usuarios) {
        if (usuarios == null) {
            return List.of();
        }

        return usuarios.stream()
                .filter(Objects::nonNull)
                .map(UsuarioDtoMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
