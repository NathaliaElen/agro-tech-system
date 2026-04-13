package com.agro.tech.system.agrotech.application.usecase.login;

import com.agro.tech.system.agrotech.api.dto.request.LoginRequestDto;
import com.agro.tech.system.agrotech.api.dto.request.LoginResponseDTO;
import com.agro.tech.system.agrotech.api.dto.response.UsuarioResponseDTO;
import com.agro.tech.system.agrotech.domain.exception.usuario.UsuarioNaoEncontradoException;
import com.agro.tech.system.agrotech.domain.mapper.UsuarioDtoMapper;
import com.agro.tech.system.agrotech.domain.model.Perfil;
import com.agro.tech.system.agrotech.domain.repository.PerfilRepository;
import com.agro.tech.system.agrotech.domain.repository.UsuarioPerfilRepository;
import com.agro.tech.system.agrotech.domain.repository.UsuarioRepository;
import com.agro.tech.system.agrotech.infra.persistence.entity.LoginEntity;
import com.agro.tech.system.agrotech.infra.persistence.mapper.PerfilMapper;
import com.agro.tech.system.agrotech.infra.persistence.mapper.UsuarioMapper;
import com.agro.tech.system.agrotech.infra.persistence.repository.JpaUsuarioRepository;
import com.agro.tech.system.agrotech.infra.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthUseCase {
    private final AuthenticationManager authenticationManager;

    // Repositório JPA
    private final JpaUsuarioRepository repository;

    // Serviço de token JWT
    private final TokenService tokenService;
    private final UsuarioRepository usuarioRepository;
    private final PerfilRepository perfilRepository;
    private final UsuarioPerfilRepository usuarioPerfilRepository;

    public LoginResponseDTO executar(LoginRequestDto loginRequestDto) {
        var authToken = new UsernamePasswordAuthenticationToken(loginRequestDto.email(), loginRequestDto.senha());

        var authentication = authenticationManager.authenticate(authToken);

        UsuarioResponseDTO usuarioDto = usuarioRepository.buscarPorEmail(loginRequestDto.email())
                    .map(UsuarioDtoMapper::toResponseDto)
                    .orElseThrow(UsuarioNaoEncontradoException::new);

        var usuario =  usuarioRepository.buscarPorEmail(usuarioDto.email())
                .orElseThrow(UsuarioNaoEncontradoException::new);  //UsuarioDtoMapper.toModel(usuarioDto);


        var perfis = perfilRepository.ListarTodos();
        var usuarioPerfil = usuarioPerfilRepository.buscarPorUsuarioId(usuario.getId());
        var perfil = usuarioPerfil
                .flatMap(up -> perfis.stream()
                        .filter(p -> p.getId().equals(up.getPerfilId()))
                        .findFirst()
                        .map(Perfil::getNome))
                .orElse("");

        var usuarioEntity = UsuarioMapper.toEntity(usuario);

        var loginEntity = new LoginEntity(usuarioEntity.getNome(), loginRequestDto.email(), loginRequestDto.senha(), null, null);
        loginEntity.setPerfis(PerfilMapper.toEntityPerfis(perfis));
        loginEntity.setPerfil(perfil);

        var token = tokenService.gerarToken(loginEntity);

        return new LoginResponseDTO(
            token,
            "Bearer",
            loginRequestDto.email(),
            usuarioEntity.getNome()            
        );
    }
}
