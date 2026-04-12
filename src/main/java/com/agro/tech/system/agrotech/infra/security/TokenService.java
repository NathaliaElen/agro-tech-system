package com.agro.tech.system.agrotech.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.agro.tech.system.agrotech.infra.persistence.entity.LoginEntity;
import com.agro.tech.system.agrotech.infra.persistence.entity.PerfilEntity;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Service
public class TokenService {
    //chave secreta do jwt(posteriormente vamos definir sua origem no arquivo "application.yml")
    @Value("${api.security.secret}")
    private String secret;

    public String gerarToken(LoginEntity loginEntity){
        Algorithm algoritimo = Algorithm.HMAC256(secret);

        return JWT.create()
                .withIssuer("grupo-2-java-avanade")
                .withSubject(loginEntity.getUsername())
                .withClaim("role", loginEntity.getPerfis().stream()
                        .filter(perfil -> "ADMIN".equalsIgnoreCase(perfil.getNome()))
                        .findFirst()
                        .or(() -> loginEntity.getPerfis().stream().findFirst())
                        .map(PerfilEntity::getNome)
                        .map(String::toUpperCase)
                        .orElse("ADMIN"))
                .withExpiresAt(dataExpiracao())
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

    public String getRole(String token){
        Algorithm algoritimo = Algorithm.HMAC256(secret);

        return JWT.require(algoritimo)
                .withIssuer("grupo-2-java-avanade")
                .build()
                .verify(token)
                .getClaim("role")
                .asString();
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now()
                .plusHours(2)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}
