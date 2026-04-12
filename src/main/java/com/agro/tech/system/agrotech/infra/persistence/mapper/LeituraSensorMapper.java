package com.agro.tech.system.agrotech.infra.persistence.mapper;

import com.agro.tech.system.agrotech.domain.model.LeituraSensor;
import com.agro.tech.system.agrotech.infra.persistence.entity.LeituraSensorEntity;

public class LeituraSensorMapper {
	
	
	public static LeituraSensor toDomain(LeituraSensorEntity entity) {
		
		if (entity == null) {
			return null;
		}

		return new LeituraSensor(			
				entity.getId(),
				entity.getSensorId(),
				entity.getAreaId(),
				entity.getDataHora(),
				entity.getValor()
		);
	}	

	public static LeituraSensorEntity toEntity(LeituraSensor leituraSensor) {

		return new LeituraSensorEntity(
				leituraSensor.getId(),
				leituraSensor.getSensorId(),
				leituraSensor.getAreaId(),
				leituraSensor.getDataHora(),
				leituraSensor.getValor()							
		);
	}	
}
