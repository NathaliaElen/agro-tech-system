package com.agro.tech.system.agrotech.application.usecase.tiposensor;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agro.tech.system.agrotech.api.dto.response.RegraResponseDTO;
import com.agro.tech.system.agrotech.application.usecase.regra.ListarRegraUseCase;
import com.agro.tech.system.agrotech.domain.exception.tiposensor.TipoSensorExistenteNaRegraException;
import com.agro.tech.system.agrotech.domain.exception.tiposensor.TipoSensorIdNaoEcontradoException;
import com.agro.tech.system.agrotech.domain.repository.TipoSensorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeletarTipoSensorUseCase {

  private final TipoSensorRepository tipoSensorRepository;
  private final ListarRegraUseCase listarRegraUseCase;

  public void deletarTipoSensor(String id) {
    tipoSensorRepository.buscarPorId(id)
        .orElseThrow(TipoSensorIdNaoEcontradoException::new);

    //VALIDAR SE EXISTE ALGUMA REGRA ASSOCIADA A UM TIPO DE SENSOR.
    List<RegraResponseDTO> listaRegra = listarRegraUseCase.buscarPorTipoSensorId(id);

    if(listaRegra.size() > 0) {
      throw new TipoSensorExistenteNaRegraException();
    }

    tipoSensorRepository.deletar(id);
  }
}
