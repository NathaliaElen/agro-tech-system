package com.agro.tech.system.agrotech.infra.security;

import java.io.IOException;
import java.util.List;

import com.agro.tech.system.agrotech.infra.persistence.entity.LoginEntity;
import com.agro.tech.system.agrotech.infra.persistence.repository.JpaPerfilRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.agro.tech.system.agrotech.infra.persistence.repository.JpaUsuarioRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {
    private final TokenService tokenService;
    private final JpaUsuarioRepository jpaUsuarioRepository;
    private final JpaPerfilRepository jpaPerfilRepository;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        String token = recuperarToken(request);
        if (token != null) {
            try {
                String username = tokenService.getSubject(token);

                var usuario = jpaUsuarioRepository.findByNome(username);
                var perfis = jpaPerfilRepository.findAll();

                if (usuario.isPresent()) {
                    var authorities = new LoginEntity(
                            null,
                            null,
                            null,
                             perfis,
                             tokenService.getRole(token)
                    ).getAuthorities();
                    var authentication = new UsernamePasswordAuthenticationToken(
                            usuario.get(),
                            null,
                            authorities
                    );
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            } catch (Exception e) {
                SecurityContextHolder.clearContext();
            }
        }

        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            return null;
        }

        String token = header.substring(7).trim();
        return token.isEmpty() ? null : token;
    }
}