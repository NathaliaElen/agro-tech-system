package com.agro.tech.system.agrotech.domain.mapper;

import com.agro.tech.system.agrotech.api.dto.request.UsuarioRequestDTO;
import com.agro.tech.system.agrotech.api.dto.response.UsuarioResponseDTO;
import com.agro.tech.system.agrotech.domain.model.Usuario;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UsuarioDtoMapper {
    public static Usuario toModel(UsuarioRequestDTO usuarioRequestDTO) {
        return new Usuario(
                usuarioRequestDTO.id(),
                usuarioRequestDTO.nome(),
                usuarioRequestDTO.email(),
                usuarioRequestDTO.senhaHash(),
                usuarioRequestDTO.status(),
                null,
                usuarioRequestDTO.criadoEm(),
                usuarioRequestDTO.criadoPor(),
                null,
                null,
                null
        );
    }

    public static UsuarioRequestDTO toRequestDto(Usuario usuario) {
        return new UsuarioRequestDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenhaHash(),
                usuario.getStatus(),
                usuario.getCriadoEm(),
                usuario.getCriadoPor(),
                null,
                null
        );
    }

    public static UsuarioResponseDTO toResponseDto(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getStatus(),
                usuario.getCriadoEm(),
                usuario.getCriadoPor()
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
