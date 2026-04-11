package com.agro.tech.system.agrotech.application.usecase.sensor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.agro.tech.system.agrotech.api.dto.response.SensorResponseDTO;
import com.agro.tech.system.agrotech.domain.exception.sensor.SensorIdNaoEncontradoException;
import com.agro.tech.system.agrotech.domain.exception.sensor.CodigoSensorNaoEncontradoException;
import com.agro.tech.system.agrotech.domain.mapper.SensorMapper;
import com.agro.tech.system.agrotech.domain.repository.SensorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListarSensorUseCase {
  private final SensorRepository sensorRepository;

  public List<SensorResponseDTO> buscarTodos() {
    return sensorRepository.buscarTodos().stream()
        .map(SensorMapper::toResponseDto)
        .collect(Collectors.toList());
  }

  public SensorResponseDTO buscarPorId(String id) {
    var sensor = sensorRepository.buscarPorId(id)
        .orElseThrow(() -> new SensorIdNaoEncontradoException());

    return SensorMapper.toResponseDto(sensor);
  }

  public SensorResponseDTO buscarPorCodigo(String codigo) {
    var sensor = sensorRepository.buscarPorCodigo(codigo)
        .orElseThrow(() -> new CodigoSensorNaoEncontradoException());

    return SensorMapper.toResponseDto(sensor);
  }

  public List<SensorResponseDTO> buscarPorAreaId(String areaId) {
    return sensorRepository.buscarPorAreaId(areaId).stream()
        .map(SensorMapper::toResponseDto)
        .collect(Collectors.toList());
  }

  public List<SensorResponseDTO> buscarPorStatus(String status) {
    return sensorRepository.buscarPorStatus(status).stream()
        .map(SensorMapper::toResponseDto)
        .collect(Collectors.toList());
  }
}
