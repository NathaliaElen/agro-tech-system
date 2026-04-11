package com.agro.tech.system.agrotech.application.usecase.usuarioperfil;

import com.agro.tech.system.agrotech.domain.exception.usuario.UsuarioNaoEncontradoException;
import com.agro.tech.system.agrotech.domain.repository.UsuarioPerfilRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class DeletarUsuarioPerfilPorUsuarioId {
    private final UsuarioPerfilRepository usuarioPerfilRepository;

    public void executar(@Valid String id){
        usuarioPerfilRepository.buscarPorUsuarioId(id)
                .orElseThrow(UsuarioNaoEncontradoException::new);

        usuarioPerfilRepository.deletarPorUsuarioId(id);
    }
}
