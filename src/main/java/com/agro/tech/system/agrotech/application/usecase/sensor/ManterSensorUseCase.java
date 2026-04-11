package com.agro.tech.system.agrotech.application.usecase.sensor;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.agro.tech.system.agrotech.api.dto.request.SensorRequestDTO;
import com.agro.tech.system.agrotech.domain.enums.Status;
import com.agro.tech.system.agrotech.domain.model.Sensor;
import com.agro.tech.system.agrotech.domain.repository.SensorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ManterSensorUseCase {
	private final SensorRepository sensorRepository;
	
	public Sensor salvarSensor(SensorRequestDTO sensorRequestDto) {
		
		Sensor sensor = new Sensor(
				sensorRequestDto.id(),
				sensorRequestDto.areaId(),
				sensorRequestDto.tipoSensorId(),
				sensorRequestDto.codigo(),
				sensorRequestDto.intervaloSegundos(),
				Status.fromDescricao(sensorRequestDto.status()),
				LocalDateTime.now(),
				LocalDateTime.now(),
				LocalDateTime.now()
		);
				
		return sensorRepository.salvar(sensor);	
	}
}