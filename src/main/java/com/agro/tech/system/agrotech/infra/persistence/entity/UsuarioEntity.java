package com.agro.tech.system.agrotech.infra.persistence.entity;

import com.agro.tech.system.agrotech.domain.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UsuarioEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String nome;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_perfil",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "perfil_id")
    )
    private List<PerfilEntity> perfis;

    @Column(nullable = false)
    private LocalDateTime criadoEm;

    @Column(nullable = false)
    private String criadoPor;

    private LocalDateTime atualizadoEm;

    private String atualizadoPor;

    @ManyToOne
    @JoinColumn(name = "usuario_perfil_id")
    private UsuarioPerfilEntity usuarioPerfil;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (perfis == null) return Collections.emptyList();

        PerfilEntity perfilEntity = perfis.stream()
                .filter(p -> p.getId().equals(usuarioPerfil.getPerfilId()))
                .findFirst()
                .orElse(new PerfilEntity());

        boolean isAdmin = perfilEntity.getNome().equalsIgnoreCase("ADMIN");
        var listaPerfil = new ArrayList<SimpleGrantedAuthority>();

        if (isAdmin) {
            for (PerfilEntity p : perfis) {
            	listaPerfil.add(new SimpleGrantedAuthority("ROLE_" + p.getNome().toUpperCase()));

            }
        } else {
            listaPerfil.add(new SimpleGrantedAuthority("ROLE_" + perfilEntity.getNome().toUpperCase()));
        }

        return listaPerfil;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return nome;
    }
}
