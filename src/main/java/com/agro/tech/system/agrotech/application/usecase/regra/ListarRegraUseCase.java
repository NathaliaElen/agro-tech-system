package com.agro.tech.system.agrotech.application.usecase.regra;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;


import com.agro.tech.system.agrotech.api.dto.response.RegraResponseDTO;
import com.agro.tech.system.agrotech.domain.exception.regra.RegraIdNaoInformadaException;
import com.agro.tech.system.agrotech.domain.model.Regra;
import com.agro.tech.system.agrotech.domain.repository.RegraRepository;


@Service
@RequiredArgsConstructor
public class ListarRegraUseCase {
	
	private final RegraRepository regraRepository;
	

	public List<RegraResponseDTO> buscarTodos(){
		
		return regraRepository.buscarTodos().stream()
				.map(this::mapToResponse)
				.collect(Collectors.toList());
	}
	
	public RegraResponseDTO buscarPorId(String id) {
		
		var regra = regraRepository.buscarPorId(id)
				.orElseThrow(() -> new RegraIdNaoInformadaException());
		
		return mapToResponse(regra);
				
	}	
	
	public List<RegraResponseDTO> buscarPorTipoSensorId(String tipoSensorId){
		
		return regraRepository.buscarPorTipoSensorId(tipoSensorId).stream()
				.map(this::mapToResponse)
				.collect(Collectors.toList());
	}
	
	public List<RegraResponseDTO> buscarPorSensorId(String sensorId){
		
		return regraRepository.buscarPorSensorId(sensorId).stream()
				.map(this::mapToResponse)
				.collect(Collectors.toList());
	}	
	
	public List<RegraResponseDTO> buscarPorPrioridade(String prioridade){
		
		return regraRepository.buscarPorPrioridade(prioridade).stream()
				.map(this::mapToResponse)
				.collect(Collectors.toList());
	}
	
	
	public List<RegraResponseDTO> buscarPorAreaId(String areaId){
		
		return regraRepository.buscarPorAreaId(areaId).stream()
				.map(this::mapToResponse)
				.collect(Collectors.toList());
	}
	
	private RegraResponseDTO mapToResponse(Regra regra) {
				
		return new RegraResponseDTO(
				regra.getId(),
				regra.getNome(),
				regra.getDescricao(),
				regra.getTipoSensorId(),
				regra.getLimiteMin(),
				regra.getLimiteMax(),				
				regra.getPrioridade().getDescricao(),
				regra.getAreaId(),
				regra.getSensorId(),
				regra.getStatus().getDescricao(),
				regra.getCriadoEm(),
				regra.getAtualizadoEm()
				);
		
	}	
	
	
}
