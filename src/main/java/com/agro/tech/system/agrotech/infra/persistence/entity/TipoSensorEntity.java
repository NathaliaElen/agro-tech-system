package com.agro.tech.system.agrotech.infra.persistence.entity;

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
@Table(name = "tipo_sensor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class TipoSensorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(updatable = false, nullable = false, length = 50, name = "id")
	private String id;
	
	@Column(nullable = false, length = 80, name = "nome")
	private String nome;
	
	@Column(nullable = false, length = 30, name = "unidade_medida")
	private String unidadeMedida;
	
	@Column(nullable = true, length = 255, name = "descricao")
	private String descricao;
	
	//@Enumerated(EnumType.STRING)
	@Column(nullable = false, name = "status")
	private String status;
}
