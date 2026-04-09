package com.agro.tech.system.agrotech.application.usecase.usuario;

import com.agro.tech.system.agrotech.domain.exception.usuario.UsuarioNaoEncontradoException;
import com.agro.tech.system.agrotech.domain.model.Usuario;
import com.agro.tech.system.agrotech.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class AlterarUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;

    public void alterar(Usuario usuario){

        usuarioRepository.buscarPorId(usuario.getId())
                                .orElseThrow(UsuarioNaoEncontradoException::new);

        usuarioRepository.atualizar(usuario);
    }
}
