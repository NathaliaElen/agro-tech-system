package com.agro.tech.system.agrotech.application.usecase.usuarioperfil;

import com.agro.tech.system.agrotech.api.dto.request.UsuarioPerfilCreateRequestDTO;
import com.agro.tech.system.agrotech.domain.mapper.UsuarioPerfilDtoMapper;
import com.agro.tech.system.agrotech.domain.repository.UsuarioPerfilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class CadastrarUsuarioPerfilUseCase {
    private final UsuarioPerfilRepository usuarioPerfilRepository;

    public void executar(UsuarioPerfilCreateRequestDTO usuarioPerfilDTO) {
        usuarioPerfilRepository.salvar(UsuarioPerfilDtoMapper.toModel(usuarioPerfilDTO));
    }
}
