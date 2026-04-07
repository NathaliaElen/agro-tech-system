package com.agro.tech.system.agrotech.infra.security;

import com.agro.tech.system.agrotech.infra.persistence.entity.PerfilEntity;
import com.agro.tech.system.agrotech.infra.persistence.entity.UsuarioEntity;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {
    //chave secreta do jwt(posteriormente vamos definir sua origem no arquivo "application.properties")
    @Value("${api.security.secret}")
    private String secret;

    public String gerarToken(UsuarioEntity usuario){
        Algorithm algoritimo = Algorithm.HMAC256(secret);

        return JWT.create()
                .withIssuer("grupo-2-java-avanade")
                .withSubject(usuario.getEmail())
                .withClaim("role", usuario.getPerfis().stream()
                        .filter(perfil -> perfil.getId().equals(usuario.getUsuarioPerfil().getPerfilId()))
                        .map(PerfilEntity::getNome)
                        .map(String::toUpperCase)
                        .findFirst()
                        .orElse("USER"))
                .withExpiresAt(Date.from(Instant.now().plusSeconds(3600)))
                .sign(algoritimo);
    }

    public String getSubject(String token){
        Algorithm algoritimo = Algorithm.HMAC256(secret);

        return JWT.require(algoritimo)
                .withIssuer("grupo-2-java-avanade")
                .build()
                .verify(token)
                .getSubject();
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now()
                .plusHours(2).
                toInstant(ZoneOffset.of("-03:00"));
    }
}
