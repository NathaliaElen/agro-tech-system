package com.agro.tech.system.agrotech.application.usecase.usuario;

import com.agro.tech.system.agrotech.api.dto.response.UsuarioResponseDTO;
import com.agro.tech.system.agrotech.domain.mapper.UsuarioDtoMapper;
import com.agro.tech.system.agrotech.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@RequiredArgsConstructor
public class ListarTodosUsuariosUseCase {
    private final UsuarioRepository usuarioRepository;

    public List<UsuarioResponseDTO> listarTodos(){
        return UsuarioDtoMapper.toListDto(usuarioRepository.ListarTodos());
    }
}
