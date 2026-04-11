package com.agro.tech.system.agrotech.application.usecase.usuarioperfil;

import com.agro.tech.system.agrotech.api.dto.response.UsuarioPerfilResponseDTO;
import com.agro.tech.system.agrotech.domain.mapper.UsuarioPerfilDtoMapper;
import com.agro.tech.system.agrotech.domain.repository.UsuarioPerfilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@RequiredArgsConstructor
public class ListarTodosUsuariosPerfilUseCase {
    private final UsuarioPerfilRepository usuarioPerfilRepository;

    public List<UsuarioPerfilResponseDTO> executar(){
        return UsuarioPerfilDtoMapper.toListDto(usuarioPerfilRepository.listarTodos());
    }
}
