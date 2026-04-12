package com.agro.tech.system.agrotech.application.usecase.alerta;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.agro.tech.system.agrotech.api.dto.request.AlertaRequestDTO;
import com.agro.tech.system.agrotech.domain.enums.Prioridade;
import com.agro.tech.system.agrotech.domain.model.Alerta;
import com.agro.tech.system.agrotech.domain.repository.AlertaRepository;


import lombok.RequiredArgsConstructor;

@Service
@Validated
@RequiredArgsConstructor
public class ManterAlertaUseCase {

	private final AlertaRepository alertaRepository;
	
	public Alerta salvarAlerta(AlertaRequestDTO alertaRequestDTO) {
		
		String id = (alertaRequestDTO.id() == null || alertaRequestDTO.id().isBlank()) ? null : alertaRequestDTO.id();
		Alerta alerta = new Alerta(
				id,
				alertaRequestDTO.regraId(),
				alertaRequestDTO.leituraSensorId(),
				Prioridade.fromDescricao(alertaRequestDTO.prioridade()),
				alertaRequestDTO.titulo(),
				alertaRequestDTO.mensagem(),
				alertaRequestDTO.criadoEm(),
				alertaRequestDTO.resolvidoEm(),
				alertaRequestDTO.resolvidoUsuarioId()
				);
		
		return alertaRepository.salvar(alerta);
	}

	
}
