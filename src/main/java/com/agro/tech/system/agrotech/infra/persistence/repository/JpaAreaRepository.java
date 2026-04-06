package com.agro.tech.system.agrotech.infra.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agro.tech.system.agrotech.infra.persistence.entity.AreaEntity;

public interface JpaAreaRepository extends JpaRepository<AreaEntity,String>{

}
