package com.agro.tech.system.agrotech.application.usecase.perfil;

import com.agro.tech.system.agrotech.api.dto.response.PerfilResponseDTO;
import com.agro.tech.system.agrotech.domain.exception.perfil.PerfilNaoEncontradoException;
import com.agro.tech.system.agrotech.domain.mapper.PerfilDtoMapper;
import com.agro.tech.system.agrotech.domain.repository.PerfilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class BuscarPerfilPorIdUseCase {
    private final PerfilRepository perfilRepository;

    public PerfilResponseDTO buscarPorEmail(String id){
        return perfilRepository.buscarPorNome(id)
                .map(PerfilDtoMapper::toResponseDto)
                .orElseThrow(PerfilNaoEncontradoException::new);
    }
}
