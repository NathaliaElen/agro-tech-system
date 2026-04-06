package com.agro.tech.system.agrotech.infra.security;

import com.agro.tech.system.agrotech.infra.persistence.entity.UsuarioEntity;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
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
    private String secret = "1cc1807d-64ed-4c91-b8f8-4fe26db8c6b4";

    public String gerarToken(UsuarioEntity usuario){
        Algorithm algoritimo = Algorithm.HMAC256(secret);

        return JWT.create()
                .withIssuer("grupo-2-java-avanade")
                .withSubject(usuario.getEmail())
                .withAudience("")
                //.withClaim("perfil", usuario.getPerfis().stream().findFirst(p))
                .withExpiresAt(Date.from(Instant.now().plusSeconds(3600)))
                .sign(algoritimo);
    }

    public String getSubject(String token){
        Algorithm algoritimo = Algorithm.HMAC256(secret);

        return JWT.require(algoritimo)
                .withIssuer("grupo-2-java-avanade")
                .withAudience("")
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
