package com.agro.tech.system.agrotech.domain.repository;

import java.util.List;
import java.util.Optional;

import com.agro.tech.system.agrotech.domain.enums.Status;
import com.agro.tech.system.agrotech.domain.model.Sensor;

public interface SensorRepository {
	Sensor salvar(Sensor sensor);
	
	Optional<Sensor> buscarPorId(String id);

    Optional<Sensor> buscarPorCodigo(String codigo);

    List<Sensor> buscarTodos();

    List<Sensor> buscarPorAreaId(String areaId);
    
    List<Sensor> buscarPorStatus(Status status);

    void deletar(String id);
}
