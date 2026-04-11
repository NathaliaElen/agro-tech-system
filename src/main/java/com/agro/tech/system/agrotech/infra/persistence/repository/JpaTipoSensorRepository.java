package com.agro.tech.system.agrotech.infra.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agro.tech.system.agrotech.infra.persistence.entity.TipoSensorEntity;

public interface JpaTipoSensorRepository extends JpaRepository<TipoSensorEntity, String> {
	Optional<TipoSensorEntity> findByNome(String nome);
	
	List<TipoSensorEntity> findByStatus(String status);
}
