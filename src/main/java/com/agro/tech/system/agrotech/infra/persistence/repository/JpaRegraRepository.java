package com.agro.tech.system.agrotech.infra.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agro.tech.system.agrotech.domain.model.Regra;

public interface JpaRegraRepository extends JpaRepository<Regra, String>{

}
