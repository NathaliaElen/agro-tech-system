package com.agro.tech.system.agrotech.application.usecase.Area;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.agro.tech.system.agrotech.api.dto.response.AreaResponseDTO;
import com.agro.tech.system.agrotech.domain.exception.area.AreaIdNaoInformadaException;
import com.agro.tech.system.agrotech.domain.model.Area;
import com.agro.tech.system.agrotech.domain.repository.AreaRepository;

@Service
@RequiredArgsConstructor
public class ListarAreaUseCase {

	private final AreaRepository areaRepository;
	
    public List<AreaResponseDTO> buscarTodos() {
        return areaRepository.buscarTodos().stream()
            .map(this::mapToResponse)
            .collect(Collectors.toList());
    }

    public AreaResponseDTO buscarPorId(String id) {
    	
    	var area = areaRepository.buscarPorId(id)
    			.orElseThrow(() -> new AreaIdNaoInformadaException());
    	
    	return mapToResponse(area);
    }
        
    private AreaResponseDTO mapToResponse(Area area) {
    	
    	return new AreaResponseDTO( 
    			area.getId(),
    			area.getNome(),
    			area.getCodigo(),
    			area.getLatitude(),
    			area.getLongitude(),
    			area.getStatus().getDescricao(),
    			area.getCriadoEm(),
    			area.getAtualizadoEm()
    			);
    }
}
