package com.agro.tech.system.agrotech.application.usecase.regra;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.agro.tech.system.agrotech.api.dto.response.SensorResponseDTO;
import com.agro.tech.system.agrotech.application.usecase.sensor.ListarSensorUseCase;
import com.agro.tech.system.agrotech.domain.exception.area.AreaExistenteEmRegraException;
import com.agro.tech.system.agrotech.domain.exception.area.AreaExistenteEmSensorException;
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
	private final ListarSensorUseCase listarSensorUseCase;
	
	public void deletar (@Valid String id) {
		
		regraRepository.buscarPorId(id)
		.orElseThrow(RegraIdNaoInformadaException::new);
				

	 	//VALIDAR SE EXISTE ALGUMA AREA ASSOCIADA A UM ALERTA.
		List<SensorResponseDTO> listaSensor = listarSensorUseCase.buscarPorAreaId(id);		
		if (listaSensor.size() > 0) {
			throw new AreaExistenteEmRegraException();
		}
		
		/* 
		//VALIDAR SE EXISTE ALGUMA AREA ASSOCIADA A UM ALERTA.
		List<LeituraResponseDTO> listaLeitura = listarLeiturarUseCase.buscarPorLeituraId(id);		
		if (listaLeitura.size() < 1) {
			throw new RegraExistenteNaLeituraException();
		}
		 */
		
		regraRepository.deletar(id);
	}
	
}
