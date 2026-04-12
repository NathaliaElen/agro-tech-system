package com.agro.tech.system.agrotech.infra.persistence.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "leitura_sensor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@EqualsAndHashCode(of = "id")
public class LeituraSensorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @Column(nullable = false, name = "sensor_id" )
    private String sensorId;    

    @Column(nullable = false, name = "area_id" )
    private String areaId;
    
    @Column( updatable = false, name = "data_hora")
    private LocalDateTime dataHora;
    
    @Column(nullable = true, name = "valor" )
	private Double valor;    
}
