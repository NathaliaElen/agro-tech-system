package com.agro.tech.system.agrotech.application.usecase.regra;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;


import com.agro.tech.system.agrotech.api.dto.request.RegraRequestDTO;
import com.agro.tech.system.agrotech.domain.enums.Prioridade;
import com.agro.tech.system.agrotech.domain.enums.Status;
import com.agro.tech.system.agrotech.domain.model.Regra;
import com.agro.tech.system.agrotech.domain.repository.RegraRepository;


@Service
@RequiredArgsConstructor
public class ManterRegraUseCase {
	
	private final RegraRepository regraRepository;
	
	public Regra salvarRegra(RegraRequestDTO regraRequestDTO) {
		
		Regra regra = new Regra(
				regraRequestDTO.id(),
				regraRequestDTO.nome(),
				regraRequestDTO.descricao(),
				regraRequestDTO.tipoSensorId(),
				regraRequestDTO.limiteMin(),
				regraRequestDTO.limiteMax(),
				Prioridade.fromDescricao(regraRequestDTO.prioridade()),
				regraRequestDTO.areaId(),
				regraRequestDTO.sensorId(),
				Status.fromDescricao(regraRequestDTO.status()),
				regraRequestDTO.criadoEm(),
				regraRequestDTO.atualizadoEm()
				);
		
		return regraRepository.salvar(regra);
	}
	
}
