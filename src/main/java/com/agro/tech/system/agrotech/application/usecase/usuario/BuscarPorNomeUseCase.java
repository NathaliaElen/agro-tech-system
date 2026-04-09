package com.agro.tech.system.agrotech.application.usecase.usuario;

import com.agro.tech.system.agrotech.api.dto.response.UsuarioResponseDTO;
import com.agro.tech.system.agrotech.domain.exception.usuario.UsuarioNaoEncontradoException;
import com.agro.tech.system.agrotech.domain.mapper.UsuarioDtoMapper;
import com.agro.tech.system.agrotech.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class BuscarPorNomeUseCase {
    private final UsuarioRepository usuarioRepository;

    public UsuarioResponseDTO buscarPorNome(String nome){
        return usuarioRepository.buscarPorNome(nome)
                .map(UsuarioDtoMapper::toResponseDto)
                .orElseThrow(UsuarioNaoEncontradoException::new);
    }
}
