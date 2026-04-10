package com.agro.tech.system.agrotech.application.usecase.alerta;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.agro.tech.system.agrotech.domain.exception.alerta.AlertaIdNaoinformadoException;
import com.agro.tech.system.agrotech.domain.repository.AlertaRepository;


@Service
@Validated
@RequiredArgsConstructor
public class DeletarAlertaUseCase {

	private final AlertaRepository alertaRepository;
	
	public void deletar(@Valid String id) {
		alertaRepository.buscarPorId(id)
			.orElseThrow(AlertaIdNaoinformadoException::new);
				
		//VALIDAR SE EXISTE ALUMA REGRA ASSOCIADA A UM ALERTA
		alertaRepository.deletar(id);
	}

}
