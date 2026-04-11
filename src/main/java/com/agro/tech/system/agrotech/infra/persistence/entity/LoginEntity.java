package com.agro.tech.system.agrotech.infra.persistence.entity;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginEntity implements UserDetails {

    @Column(nullable = false)
    private String nome;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Column(name= "senha_hash",nullable = false)
    private String senha;

    private List<PerfilEntity> perfis;

    String perfil;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (perfis == null) return Collections.emptyList();

        boolean isAdmin = this.perfil.equalsIgnoreCase("ADMIN");

        var listaPerfil = new ArrayList<SimpleGrantedAuthority>();

        if (isAdmin) {
            for (PerfilEntity p : perfis) {
                listaPerfil.add(new SimpleGrantedAuthority("ROLE_" + p.getNome().toUpperCase()));
            }
        } else {
            perfis.forEach(p -> listaPerfil.add(new SimpleGrantedAuthority("ROLE_" + p.getNome().toUpperCase())));
        }

        return listaPerfil;
    }


    @Override
    public @Nullable String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }
}
