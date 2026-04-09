package com.agro.tech.system.agrotech.domain.repository;

import java.util.List;
import java.util.Optional;

import com.agro.tech.system.agrotech.domain.model.Regra;

public interface RegraRepository {
	
	Regra salvar(Regra regra);
    Optional<Regra> buscarPorId(String id);
    List<Regra> buscarTodos();
	List<Regra> buscarPorTipoSensorId(String tipoSensorId);
    List<Regra> buscarPorSensorId(String sensorId);
    List<Regra> buscarPorPrioridade(String prioridade);
    List<Regra> buscarPorAreaId(String areaId);    
    void deletar(String id);	

}
