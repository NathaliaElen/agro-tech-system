package com.agro.tech.system.agrotech.application.usecase.leiturasensor;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agro.tech.system.agrotech.api.dto.response.AlertaResponseDTO;
import com.agro.tech.system.agrotech.application.usecase.alerta.ListarAlertaUseCase;
import com.agro.tech.system.agrotech.domain.exception.leiturasensor.LeituraSensorExistenteNoAlertaException;
import com.agro.tech.system.agrotech.domain.exception.leiturasensor.LeituraSensorIdNaoEncontradoException;
import com.agro.tech.system.agrotech.domain.repository.LeituraSensorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeletarLeituraSensorUseCase {

  private final LeituraSensorRepository leituraSensorRepository;
  private final ListarAlertaUseCase listarAlertaUseCase;

  public void deletarLeituraSensor(String id) {
    leituraSensorRepository.buscarPorId(id)
        .orElseThrow(LeituraSensorIdNaoEncontradoException::new);

    // VALIDAR SE EXISTE ALGUMA ALERTA ASSOCIADO A UMA LEITURA DE SENSOR.
    List<AlertaResponseDTO> listaAlerta = listarAlertaUseCase.buscarPorLeituraSensorId(id);
      
    if (listaAlerta.size() > 0) {
      throw new LeituraSensorExistenteNoAlertaException();
    }

    leituraSensorRepository.deletar(id);
  }

}
