package com.agro.tech.system.agrotech.application.usecase.area;

import org.springframework.stereotype.Service;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import lombok.RequiredArgsConstructor;

import com.agro.tech.system.agrotech.domain.exception.area.AreaIdNaoInformadaException;
import com.agro.tech.system.agrotech.domain.repository.AreaRepository;


@Service
@Validated
@RequiredArgsConstructor
public class DeletarAreaUseCase {
	private final AreaRepository areaRepository;
	
	public void deletar(@Valid String id) {
		
		areaRepository.buscarPorId(id)
			.orElseThrow(AreaIdNaoInformadaException::new);
	
		areaRepository.deletar(id);
		
	}
	
}
