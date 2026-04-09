package com.agro.tech.system.agrotech.infra.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agro.tech.system.agrotech.domain.model.Regra;
import com.agro.tech.system.agrotech.infra.persistence.entity.RegraEntity;

public interface JpaRegraRepository extends JpaRepository<RegraEntity, String>{

	List<RegraEntity> findByTipoSensorId(String tipoSensorId);

    List<RegraEntity> findBySensorId(String sensorId);

    List<RegraEntity> findByPrioridade(String prioridade);

    List<RegraEntity> findByAreaId(String areaId);	
}
