package com.agro.tech.system.agrotech.infra.persistence.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.agro.tech.system.agrotech.infra.persistence.entity.AlertaEntity;

public interface JpaAlertaRepository extends JpaRepository<AlertaEntity,String>{

	List<AlertaEntity> findByPrioridade(String prioridade);

    List<AlertaEntity> findByLeituraSensorIdIn(List<String> leituraSensorIds);

    List<AlertaEntity> findByLeituraSensorId(String leituraSensorId);
}
