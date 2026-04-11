package com.agro.tech.system.agrotech.application.usecase.sensor;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agro.tech.system.agrotech.api.dto.response.RegraResponseDTO;
import com.agro.tech.system.agrotech.application.usecase.regra.ListarRegraUseCase;
import com.agro.tech.system.agrotech.domain.exception.sensor.SensorExistenteNaRegraException;
import com.agro.tech.system.agrotech.domain.exception.sensor.SensorIdNaoEncontradoException;
import com.agro.tech.system.agrotech.domain.repository.SensorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeletarSensorUseCase {

  private final SensorRepository sensorRepository;
  private final ListarRegraUseCase listarRegraUseCase;

  public void deletarSensor(String id) {
    sensorRepository.buscarPorId(id)
        .orElseThrow(SensorIdNaoEncontradoException::new);  

    //VALIDAR SE EXISTE ALGUMA REGRA ASSOCIADA A UM SENSOR.
    List<RegraResponseDTO> listaRegra = listarRegraUseCase.buscarPorSensorId(id); 

    if (listaRegra.size() > 0) {
      throw new SensorExistenteNaRegraException();
    }

    sensorRepository.deletar(id);
  }
}
