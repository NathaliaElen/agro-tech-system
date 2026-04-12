package com.agro.tech.system.agrotech.infra.persistence.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "alerta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@EqualsAndHashCode(of = "id")
public class AlertaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @Column(nullable = false, name = "regra_id" )
    private String regraId;
    
    @Column(nullable = false, name = "leitura_sensor_id" )
    private String leituraSensorId;
    
    @Column(nullable = false, name = "prioridade" )
	private String prioridade;
    
    @Column(nullable = true, name = "titulo" )
	private String titulo;
    
    @Column(nullable = false, name = "mensagem" )
	private String mensagem;
    
    @Column(name = "criado_em", updatable = false)
    private LocalDateTime criadoEm;
    
	//this.geradoEm;
    @Column(nullable = true, name = "resolvido_em" )
    private LocalDateTime resolvidoEm;
    
    @Column(nullable = true, name = "resolvido_usuario_id" )
	private String resolvidoUsuarioId;
    
    @PrePersist
    private void prePersist() {
        criadoEm = LocalDateTime.now();
    }
    
}
