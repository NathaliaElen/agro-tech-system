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
	@Column(updatable = false, nullable = false, name = "id")
	private String id;
	
	@Column(nullable = false, name = "area_id")
	private String areaId;
	
	@Column(nullable = false, name = "tipo_sensor_id")
	private String tipoSensorId;
	
	@Column(nullable = false, length = 60, name = "codigo")
	private String codigo;
	
	@Column(nullable = true, name = "intervalo_segundos")
	private Integer intervaloSegundos;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, name = "status")
	private Status status;
	
	@Column(nullable = true, name = "instalado_em")
	private LocalDateTime instaladoEm;
	
	@Column(nullable = false, name = "criado_em")
	private LocalDateTime criadoEm;
	
	@Column(nullable = false, name = "atualizado_em")
	private LocalDateTime atualizadoEm;
}
