package com.agro.tech.system.agrotech.application.usecase.tiposensor;

import org.springframework.stereotype.Service;

import com.agro.tech.system.agrotech.api.dto.request.TipoSensorRequestDTO;
import com.agro.tech.system.agrotech.domain.enums.Status;
import com.agro.tech.system.agrotech.domain.model.TipoSensor;
import com.agro.tech.system.agrotech.domain.repository.TipoSensorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ManterTipoSensorUseCase {
  
  private final TipoSensorRepository tipoSensorRepository;

  public TipoSensor salvarTipoSensor(TipoSensorRequestDTO tipoSensorRequestDto) {
    String id = (tipoSensorRequestDto.id() == null || tipoSensorRequestDto.id().isBlank()) ? null : tipoSensorRequestDto.id();
    TipoSensor tipoSensor = new TipoSensor(
        id,
        tipoSensorRequestDto.nome(),
        tipoSensorRequestDto.unidadeMedida(),
        tipoSensorRequestDto.descricao(),
        Status.fromDescricao(tipoSensorRequestDto.status())
    );

    return tipoSensorRepository.salvar(tipoSensor);
  }
}
