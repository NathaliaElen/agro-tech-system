package com.agro.tech.system.agrotech.domain.repository;

import java.util.List;
import java.util.Optional;

import com.agro.tech.system.agrotech.domain.model.TipoSensor;

public interface TipoSensorRepository {
	TipoSensor salvar(TipoSensor tipoSensor);

    Optional<TipoSensor> buscarPorId(String id);

    Optional<TipoSensor> buscarPorNome(String nome);

    List<TipoSensor> buscarTodos();

    List<TipoSensor> buscarPorStatus(String status);

    void deletar(String id);
}
