package com.agro.tech.system.agrotech.domain.repository;

import java.util.List;
import java.util.Optional;

import com.agro.tech.system.agrotech.domain.model.LeituraSensor;

public interface LeituraSensorRepository {

	 LeituraSensor salvar(LeituraSensor leituraSensor);
	 
	 Optional<LeituraSensor> buscarPorId(String id);
	 
	 List<LeituraSensor> buscarTodos();	   
	 
	 List<LeituraSensor> buscarPorSensorId(String sensorId);
	 
	 List<LeituraSensor> buscarPorAreaId(String areaId);
	    
	 void deletar(String id);	
}
