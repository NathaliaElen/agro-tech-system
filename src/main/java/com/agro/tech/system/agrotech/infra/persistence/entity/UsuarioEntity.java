package com.agro.tech.system.agrotech.infra.persistence.entity;

import com.agro.tech.system.agrotech.domain.enums.Status;
import com.agro.tech.system.agrotech.domain.model.Perfil;
import com.agro.tech.system.agrotech.domain.model.UsuarioPerfil;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.data.repository.query.parser.Part;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

    private List<PerfilEntity> perfis;

    @Column(nullable = false)
    private LocalDateTime criadoEm;

    @Column(nullable = false)
    private String criadoPor;

    private LocalDateTime atualizadoEm;

    private String atualizadoPor;
    private boolean isAdmin;


    @ManyToOne
    @JoinColumn(name = "usuario_perfil_id")
    private UsuarioPerfilEntity usuarioPerfil;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //como obter a lista de perfis?

        if (perfis == null) return Collections.emptyList();

        Optional<PerfilEntity> perfilEntity = perfis.stream()
                .filter(perfil -> perfil != null
                        && perfil.getId() != null
                        && perfil.getId().equals(usuarioPerfil.getUsuarioId()))
                .findFirst();

        var listaPerfil = new ArrayList<SimpleGrantedAuthority>();



        if (this.isAdmin) {
            perfis.stream().forEach(perfil -> {
                listaPerfil.add(new SimpleGrantedAuthority("ROLE_" + perfil.getNome().toUpperCase()));
            });
        } else {
            listaPerfil.add(new SimpleGrantedAuthority("ROLE_" + perfilEntity.get().getNome().toUpperCase()));
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
