package com.agro.tech.system.agrotech.application.usecase.usuario;

import com.agro.tech.system.agrotech.api.dto.request.UsuarioRequestDTO;
import com.agro.tech.system.agrotech.domain.exception.usuario.UsuarioExistenteException;
import com.agro.tech.system.agrotech.domain.mapper.UsuarioDtoMapper;
import com.agro.tech.system.agrotech.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Service
@Validated
@RequiredArgsConstructor
public class CadastrarUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public void executar(UsuarioRequestDTO usuarioDto) {
        var existeLogin = usuarioRepository.existeLogin(usuarioDto.email());

        if (existeLogin) {
            throw new UsuarioExistenteException();
        }

        var usuario = UsuarioDtoMapper.toModel(usuarioDto);

        usuario.setCriadoPor("Nelson");
        usuario.setCriadoEm(LocalDateTime.now());

        // Criptografa a senha antes de persistir
        if (usuario.getSenhaHash() != null && !usuario.getSenhaHash().isBlank()) {
            usuario.setSenhaHash(passwordEncoder.encode(usuario.getSenhaHash()));
        }

        usuarioRepository.salvar(usuario);
    }
}
