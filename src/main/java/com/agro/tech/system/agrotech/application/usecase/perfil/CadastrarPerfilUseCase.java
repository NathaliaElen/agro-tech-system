package com.agro.tech.system.agrotech.application.usecase.perfil;

import com.agro.tech.system.agrotech.domain.repository.PerfilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class CadastrarPerfilUseCase {
    private final PerfilRepository perfilRepository;

    public Perfil
}
