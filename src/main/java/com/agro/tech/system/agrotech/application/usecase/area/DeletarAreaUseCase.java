package com.agro.tech.system.agrotech.application.usecase.area;

import java.util.List;

import org.springframework.stereotype.Service;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import lombok.RequiredArgsConstructor;


import com.agro.tech.system.agrotech.api.dto.response.RegraResponseDTO;
import com.agro.tech.system.agrotech.application.usecase.regra.ListarRegraUseCase;
import com.agro.tech.system.agrotech.domain.exception.area.AreaExistenteEmRegraException;
import com.agro.tech.system.agrotech.domain.exception.area.AreaIdNaoInformadaException;
import com.agro.tech.system.agrotech.domain.repository.AreaRepository;


@Service
@Validated
@RequiredArgsConstructor
public class DeletarAreaUseCase {
	
	private final AreaRepository areaRepository;
	//TODO:implementar validação do sensor
	//private final ListarSensorUseCase listarSensorUseCase;
	private final ListarRegraUseCase listarRegraUseCase;
	
	public void deletar(@Valid String id) {
		
		//VALIDAR SE EXITE AREA PARA EXCLUIR
		areaRepository.buscarPorId(id)
		.orElseThrow(AreaIdNaoInformadaException::new);
		/*
		//VALIDAR SE EXISTE ALGUMA AREA ASSOCIADA A UM ALERTA.
		List<SensorResponseDTO> listaSensor = listarSensorUseCase.buscarPorAreaId(id);		
		if (listaSensora.size() > 0) {
			throw new AreaExistenteEmSensorException();
		}
		*/
		//VALIDAR SE A AREA ESTA ASSOCIADA A UMA REGRA
		List<RegraResponseDTO> listaRegra = listarRegraUseCase.buscarPorAreaId(id);
		if (listaRegra.size() < 1) {
			throw new AreaExistenteEmRegraException();
		}	
		areaRepository.deletar(id);
		
	}
	
}
