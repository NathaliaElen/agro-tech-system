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
@Table(name = "sensor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class SensorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(updatable = false, nullable = false, length = 50, name = "id")
	private String id;
	
	@Column(nullable = false, length = 50, name = "area_id")
	private String areaId;
	
	@Column(nullable = false, length = 50, name = "tipo_sensor_id")
	private String tipoSensorId;
	
	@Column(nullable = false, length = 60, name = "codigo")
	private String codigo;
	
	@Column(nullable = true, name = "intervalo_segundos")
	private Integer intervaloSegundos;
	
	@Column(nullable = false, name = "status")
	private String status;
	
	@Column(nullable = true, name = "instalado_em")
	private LocalDateTime instaladoEm;
	
	@Column(nullable = false, name = "criado_em")
	private LocalDateTime criadoEm;
	
	@Column(nullable = false, name = "atualizado_em")
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
