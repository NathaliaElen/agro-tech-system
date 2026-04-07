package com.agro.tech.system.agrotech.infra.persistence.mapper;

import com.agro.tech.system.agrotech.domain.model.Sensor;
import com.agro.tech.system.agrotech.infra.persistence.entity.SensorEntity;

public class SensorMapper {
	
	// "conversão" de entity em domain
	public static Sensor toDomain(SensorEntity entity) {
		if (entity == null) {
			return null;
		}
			
		return new Sensor(	
				entity.getId(),
				entity.getAreaId(),
				entity.getTipoSensorId(),
				entity.getCodigo(),
				entity.getIntervaloSegundos(),
				entity.getStatus(),
				entity.getInstaladoEm(),
				entity.getCriadoEm(),
				entity.getAtualizadoEm()
		);
	}
		
	// "conversão" de domain em entity
	public static SensorEntity toEntity(Sensor sensor) {
		return new SensorEntity(				
				sensor.getId(),
				sensor.getAreaId(),
				sensor.getTipoSensorId(),
				sensor.getCodigo(),
				sensor.getIntervaloSegundos(),
				sensor.getStatus(),
				sensor.getInstaladoEm(),
				sensor.getCriadoEm(),
				sensor.getAtualizadoEm()
		);
	}
}
