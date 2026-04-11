package com.agro.tech.system.agrotech.application.usecase.usuario;

import com.agro.tech.system.agrotech.api.dto.request.UsuarioRequestDTO;
import com.agro.tech.system.agrotech.domain.exception.usuario.UsuarioExistenteException;
import com.agro.tech.system.agrotech.domain.mapper.UsuarioDtoMapper;
import com.agro.tech.system.agrotech.domain.repository.UsuarioRepository;
import com.agro.tech.system.agrotech.infra.persistence.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

@Service
@Validated
@RequiredArgsConstructor
public class CadastrarUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;

    public void executar(UsuarioRequestDTO usuarioDto) {
        var existeLogin = usuarioRepository.existeLogin(usuarioDto.email());

        if (existeLogin) {
            throw new UsuarioExistenteException();
        }

        var usuarioResponseDto = UsuarioDtoMapper.toResponseDto(usuarioDto);
        var usuario = UsuarioDtoMapper.toModel(usuarioResponseDto);

        usuario.setCriadoPor("Nelson");
        usuario.setCriadoEm(LocalDateTime.now());

        usuarioRepository.salvar(usuario);
    }
}
