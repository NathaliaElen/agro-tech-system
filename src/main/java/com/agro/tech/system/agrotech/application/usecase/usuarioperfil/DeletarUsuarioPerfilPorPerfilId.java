package com.agro.tech.system.agrotech.application.usecase.usuarioperfil;

import com.agro.tech.system.agrotech.domain.exception.perfil.PerfilNaoEncontradoException;
import com.agro.tech.system.agrotech.domain.exception.usuario.UsuarioNaoEncontradoException;
import com.agro.tech.system.agrotech.domain.repository.UsuarioPerfilRepository;
import com.agro.tech.system.agrotech.domain.repository.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class DeletarUsuarioPerfilPorPerfilId {
    private final UsuarioPerfilRepository usuarioPerfilRepository;

    public void executar(@Valid String id){
        usuarioPerfilRepository.buscarPorPerfilId(id)
                .orElseThrow(PerfilNaoEncontradoException::new);

        usuarioPerfilRepository.deletarPorPerfilId(id);
    }
}
