package com.agro.tech.system.agrotech.infra.persistence.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "regra")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@EqualsAndHashCode(of = "id")
public class RegraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @Column(nullable = false, name = "nome" )
	private String nome;
    
    @Column(nullable = true, name = "descricao" )
    private String descricao;

    @Column(nullable = true, name = "tipoSensorId" )
	private String tipoSensorId;

    @Column(nullable = true, name = "limiteMin" )
	private Double limiteMin;

    @Column(nullable = true, name = "limiteMax" )
	private Double limiteMax;

    @Column(nullable = false, name = "prioridade" )
	private String prioridade;

    @Column(nullable = true, name = "areaId" )
	private String areaId;

    @Column(nullable = true, name = "sensorId" )
	private String sensorId;
	
    @Column(nullable = false, name = "status" )
	private String status;
    
    @Column(nullable = false, name = "criadoEm" )
	private LocalDateTime criadoEm;

    @Column(nullable = false, name = "atualizadoEm" )
	private LocalDateTime atualizadoEm;

    @PrePersist
    private void prePersist() {
        criadoEm = LocalDateTime.now();
    }
    
    @PreUpdate
    private void preUpdate() {
        this.atualizadoEm = LocalDateTime.now();
    }    
}
