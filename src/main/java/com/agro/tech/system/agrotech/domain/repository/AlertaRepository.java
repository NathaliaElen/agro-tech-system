package com.agro.tech.system.agrotech.domain.repository;

import java.util.List;
import java.util.Optional;

import com.agro.tech.system.agrotech.domain.model.Alerta;

public interface AlertaRepository {

    Alerta salvar(Alerta area);
    Optional<Alerta> buscarPorId(String id);
    List<Alerta> buscarTodos();
    List<Alerta> buscarPorTipoSensorId(String tipoSensorId);
    List<Alerta> buscarPorsensorId(String sensorId);
    List<Alerta> buscarPorPrioridade(String prioridade);
    List<Alerta> buscarPorArea(String areaId);
    
    void deletar(String id);	
}
