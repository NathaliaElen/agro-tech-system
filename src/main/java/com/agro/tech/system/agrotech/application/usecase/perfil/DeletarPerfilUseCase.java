package com.agro.tech.system.agrotech.application.usecase.perfil;

import com.agro.tech.system.agrotech.domain.exception.perfil.PerfilNaoEncontradoException;
import com.agro.tech.system.agrotech.domain.exception.usuario.UsuarioNaoEncontradoException;
import com.agro.tech.system.agrotech.domain.repository.PerfilRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class DeletarPerfilUseCase {
    private final PerfilRepository perfilRepository;
    public void deletarPerfil(@Valid String id){
        perfilRepository.buscarPorId(id)
                .orElseThrow(PerfilNaoEncontradoException::new);

        perfilRepository.deletar(id);
    }
}

