package com.agro.tech.system.agrotech.infra.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuario_perfil")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioPerfilEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "usuario_id")
    private String usuarioId;

    @Column(name = "perfil_id")
    private String perfilId;

    @Column(name = "criado_em", nullable = false)
    private LocalDateTime criadoEm;

    @Column(name = "criado_por",nullable = false)
    private String criadoPor;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;

    @Column(name = "atualizado_por")
    private String atualizadoPor;
}
