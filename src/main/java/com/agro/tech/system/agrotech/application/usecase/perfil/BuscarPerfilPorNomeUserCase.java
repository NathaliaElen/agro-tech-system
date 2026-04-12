package com.agro.tech.system.agrotech.application.usecase.perfil;

import com.agro.tech.system.agrotech.api.dto.response.PerfilResponseDTO;
import com.agro.tech.system.agrotech.api.dto.response.UsuarioResponseDTO;
import com.agro.tech.system.agrotech.domain.exception.perfil.PerfilNaoEncontradoException;
import com.agro.tech.system.agrotech.domain.exception.usuario.UsuarioNaoEncontradoException;
import com.agro.tech.system.agrotech.domain.mapper.PerfilDtoMapper;
import com.agro.tech.system.agrotech.domain.mapper.UsuarioDtoMapper;
import com.agro.tech.system.agrotech.domain.repository.PerfilRepository;
import com.agro.tech.system.agrotech.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class BuscarPerfilPorNomeUserCase {
    private final PerfilRepository perfilRepository;

    public PerfilResponseDTO executar(String nome){
        return perfilRepository.buscarPorNome(nome)
                .map(PerfilDtoMapper::toResponseDto)
                .orElseThrow(PerfilNaoEncontradoException::new);
    }
}
