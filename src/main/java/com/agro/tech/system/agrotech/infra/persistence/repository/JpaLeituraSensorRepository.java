package com.agro.tech.system.agrotech.infra.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.agro.tech.system.agrotech.infra.persistence.entity.LeituraSensorEntity;

public interface JpaLeituraSensorRepository extends JpaRepository<LeituraSensorEntity,String>{
	
	List<LeituraSensorEntity> findByAreaId(String areaId);
	
	List<LeituraSensorEntity> findBySensorId(String sensorId);

	List<LeituraSensorEntity> findBySensorIdIn(List<String> sensorIds);
		
}