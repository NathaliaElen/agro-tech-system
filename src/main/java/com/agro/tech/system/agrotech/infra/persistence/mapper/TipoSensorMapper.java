package com.agro.tech.system.agrotech.infra.persistence.mapper;

import com.agro.tech.system.agrotech.domain.enums.Status;
import com.agro.tech.system.agrotech.domain.model.TipoSensor;
import com.agro.tech.system.agrotech.infra.persistence.entity.TipoSensorEntity;

public class TipoSensorMapper {
	// "conversão" de entity em domain
	public static TipoSensor toDomain(TipoSensorEntity entity) {
		if (entity == null) {
			return null;
		}
		
		return new TipoSensor(			
				entity.getId(),
				entity.getNome(),
				entity.getUnidadeMedida(),
				entity.getDescricao(),
				Status.fromDescricao(entity.getStatus())
		);
	}
		
	// "conversão" de domain em entity
	public static TipoSensorEntity toEntity(TipoSensor tipoSensor) {
		return new TipoSensorEntity(
						tipoSensor.getId(),
						tipoSensor.getNome(),
						tipoSensor.getUnidadeMedida(),
						tipoSensor.getDescricao(),
						tipoSensor.getStatus().getDescricao()
		);
	}
}
