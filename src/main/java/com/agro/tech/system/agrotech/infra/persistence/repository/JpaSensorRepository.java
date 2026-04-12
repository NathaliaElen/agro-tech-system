package com.agro.tech.system.agrotech.infra.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agro.tech.system.agrotech.infra.persistence.entity.SensorEntity;

public interface JpaSensorRepository extends JpaRepository<SensorEntity, String> {
	Optional<SensorEntity> findByCodigo(String codigo);

    List<SensorEntity> findByAreaId(String areaId);

    List<SensorEntity> findByStatus(String status);

    List<SensorEntity> findByTipoSensorId(String tipoSensorId);	
}
