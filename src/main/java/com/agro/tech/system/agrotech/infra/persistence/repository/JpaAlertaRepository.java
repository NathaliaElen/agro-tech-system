package com.agro.tech.system.agrotech.infra.persistence.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.agro.tech.system.agrotech.infra.persistence.entity.AlertaEntity;

public interface JpaAlertaRepository extends JpaRepository<AlertaEntity,String>{

	List<AlertaEntity> findByTipoSensorId(String tipoSensorId);

    List<AlertaEntity> findBySensorId(String sensorId);

    List<AlertaEntity> findByPrioridade(String prioridade);

    List<AlertaEntity> findByAreaId(String areaId);
}
