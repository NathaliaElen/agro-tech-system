package com.agro.tech.system.agrotech.application.usecase.perfil;

import com.agro.tech.system.agrotech.api.dto.response.PerfilResponseDTO;
import com.agro.tech.system.agrotech.domain.mapper.PerfilDtoMapper;
import com.agro.tech.system.agrotech.domain.repository.PerfilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@RequiredArgsConstructor
public class ListarTodosPerfilUseCase {
    private final PerfilRepository perfilRepository;

    public List<PerfilResponseDTO> listarTodos(){
        return PerfilDtoMapper.toListDto(perfilRepository.ListarTodos());
    }
}


