package com.agro.tech.system.agrotech.application.usecase.perfil;

import com.agro.tech.system.agrotech.api.dto.request.PerfilRequestDTO;
import com.agro.tech.system.agrotech.domain.mapper.PerfilDtoMapper;
import com.agro.tech.system.agrotech.domain.repository.PerfilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class CadastrarPerfilUseCase {
    private final PerfilRepository perfilRepository;

    public void executar(PerfilRequestDTO perfilDto) {

        perfilRepository.salvar(PerfilDtoMapper.toModel(perfilDto));
    }

}
