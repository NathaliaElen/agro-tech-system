package com.agro.tech.system.agrotech.infra.persistence.entity;

import java.time.LocalDateTime;

import com.agro.tech.system.agrotech.domain.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "area")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@EqualsAndHashCode(of = "id")
public class AreaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, name = "nome" )
    private String nome;

    @Column(nullable = false, name = "codigo")
    private String codigo;

    @Column(nullable = false, name = "localizacao_lat")
    private Double latitude;

    @Column(nullable = false, name = "localizacao_lon" )
    private Double longitude;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false, name = "status")
    private Status status;

    @Column(name = "criado_em", updatable = false)
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;

    @PrePersist
    private void prePersist() {
        this.criadoEm = LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate() {
        this.atualizadoEm = LocalDateTime.now();
    }
}
