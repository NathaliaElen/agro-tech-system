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
	
	//private final ListarLeituraUseCase listarLeituraUseCase;
	private final RegraRepository  regraRepository;
	
	public void deletar (@Valid String id) {
		
		regraRepository.buscarPorId(id)
		.orElseThrow(RegraIdNaoInformadaException::new);
				
		/*
		//VALIDAR SE EXISTE ALGUMA AREA ASSOCIADA A UM ALERTA.
		/// TODO: Pendente Elizeu
		List<LeituraResponseDTO> listaLeitura = listarLeiturarUseCase.buscarPorAreaId(id);		
		if (listaLeitura.size() < 1) {
			throw new RegraExistenteNaLeituraException();
		}
		 */
		
		regraRepository.deletar(id);
	}
	
}
