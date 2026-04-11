package com.agro.tech.system.agrotech.application.usecase.usuarioperfil;

import com.agro.tech.system.agrotech.api.dto.response.UsuarioPerfilResponseDTO;
import com.agro.tech.system.agrotech.domain.exception.usuario.UsuarioNaoEncontradoException;
import com.agro.tech.system.agrotech.domain.mapper.UsuarioPerfilDtoMapper;
import com.agro.tech.system.agrotech.domain.repository.UsuarioPerfilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class BuscarUsuarioPerfilPorUsuarioIdUseCase {
    private final UsuarioPerfilRepository usuarioPerfilRepository;

    public UsuarioPerfilResponseDTO executar(String id){
        return usuarioPerfilRepository.buscarPorUsuarioId(id)
                .map(UsuarioPerfilDtoMapper::toResponseDto)
                .orElseThrow(UsuarioNaoEncontradoException::new);
    }
}
