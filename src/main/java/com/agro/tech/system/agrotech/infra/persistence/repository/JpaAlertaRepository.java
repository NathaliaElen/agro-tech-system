package com.agro.tech.system.agrotech.infra.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agro.tech.system.agrotech.infra.persistence.entity.AlertaEntity;

public interface JpaAlertaRepository extends JpaRepository<AlertaEntity,String>{

}
