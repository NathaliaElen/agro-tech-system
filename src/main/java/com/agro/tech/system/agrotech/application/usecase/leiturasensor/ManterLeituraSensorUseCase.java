package com.agro.tech.system.agrotech.application.usecase.leiturasensor;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.agro.tech.system.agrotech.api.dto.request.LeituraSensorRequestDTO;
import com.agro.tech.system.agrotech.domain.model.LeituraSensor;
import com.agro.tech.system.agrotech.domain.repository.LeituraSensorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ManterLeituraSensorUseCase {
  private final LeituraSensorRepository leituraSensorRepository;

  public LeituraSensor salvarLeituraSensor(LeituraSensorRequestDTO leituraSensorRequestDTO) {
    LeituraSensor leituraSensor = new LeituraSensor(
        leituraSensorRequestDTO.id(),
        leituraSensorRequestDTO.sensorId(),
        leituraSensorRequestDTO.areaId(),
        LocalDateTime.now(),
        leituraSensorRequestDTO.valor()
    );

    return leituraSensorRepository.salvar(leituraSensor);
  }

}
