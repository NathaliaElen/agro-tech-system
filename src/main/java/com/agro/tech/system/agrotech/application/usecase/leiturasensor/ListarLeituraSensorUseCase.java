package com.agro.tech.system.agrotech.application.usecase.leiturasensor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.agro.tech.system.agrotech.api.dto.response.LeituraSensorResponseDTO;
import com.agro.tech.system.agrotech.domain.exception.leiturasensor.LeituraSensorIdNaoEncontradoException;
import com.agro.tech.system.agrotech.domain.mapper.LeituraSensorMapper;
import com.agro.tech.system.agrotech.domain.repository.LeituraSensorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListarLeituraSensorUseCase {

  private final LeituraSensorRepository leituraSensorRepository;

  public List<LeituraSensorResponseDTO> buscarTodos() {
    return leituraSensorRepository.buscarTodos().stream()
        .map(LeituraSensorMapper::toResponseDto)
        .collect(Collectors.toList());
  }

  public LeituraSensorResponseDTO buscarPorId(String id) {
    return leituraSensorRepository.buscarPorId(id)
        .map(LeituraSensorMapper::toResponseDto)
        .orElseThrow(LeituraSensorIdNaoEncontradoException::new);
  }

  public List<LeituraSensorResponseDTO> buscarPorSensorId(String sensorId) {
    return leituraSensorRepository.buscarPorSensorId(sensorId).stream()
        .map(LeituraSensorMapper::toResponseDto)
        .collect(Collectors.toList());
  }

  public List<LeituraSensorResponseDTO> buscarPorAreaId(String areaId) {
    return leituraSensorRepository.buscarPorAreaId(areaId).stream()
        .map(LeituraSensorMapper::toResponseDto)
        .collect(Collectors.toList());
  }

}
