package com.agro.tech.system.agrotech.domain.repository;

import java.util.List;
import java.util.Optional;

import com.agro.tech.system.agrotech.domain.model.Alerta;

public interface AlertaRepository {

    Alerta salvar(Alerta area);
    Optional<Alerta> buscarPorId(String id);
    List<Alerta> buscarTodos();
    List<Alerta> buscarPorTipoSensorId(String tipoSensorId);
    List<Alerta> buscarPorSensorId(String sensorId);
    List<Alerta> buscarPorPrioridade(String prioridade);
    List<Alerta> buscarPorAreaId(String areaId);
    List<Alerta> buscarPorLeituraSensorId(String leituraSensorId);
    void deletar(String id);
    
}
