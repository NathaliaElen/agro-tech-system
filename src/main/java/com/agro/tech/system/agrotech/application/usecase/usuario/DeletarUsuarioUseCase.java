package com.agro.tech.system.agrotech.application.usecase.usuario;

import com.agro.tech.system.agrotech.domain.exception.usuario.IdUsuarioNaoInformadoException;
import com.agro.tech.system.agrotech.domain.exception.usuario.UsuarioNaoEncontradoException;
import com.agro.tech.system.agrotech.domain.repository.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class DeletarUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;

    public void executar(@Valid String id){
        usuarioRepository.buscarPorId(id)
                            .orElseThrow(UsuarioNaoEncontradoException::new);

        usuarioRepository.deletar(id);
    }
}
