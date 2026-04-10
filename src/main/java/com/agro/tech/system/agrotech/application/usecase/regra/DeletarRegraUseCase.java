package com.agro.tech.system.agrotech.application.usecase.regra;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


import com.agro.tech.system.agrotech.domain.exception.regra.RegraIdNaoInformadaException;
import com.agro.tech.system.agrotech.domain.repository.RegraRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@Validated
@RequiredArgsConstructor
public class DeletarRegraUseCase {
	
	private final RegraRepository  regraRepository;
	
	public void deletar (@Valid String id) {
		
		regraRepository.buscarPorId(id)
		.orElseThrow(RegraIdNaoInformadaException::new);
	}
	
}
