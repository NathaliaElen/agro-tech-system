package com.agro.tech.system.agrotech.application.usecase.area;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.agro.tech.system.agrotech.api.dto.response.AreaResponseDTO;
import com.agro.tech.system.agrotech.domain.exception.area.AreaIdNaoInformadaException;
import com.agro.tech.system.agrotech.domain.mapper.AreaMapper;
import com.agro.tech.system.agrotech.domain.repository.AreaRepository;

@Service
@RequiredArgsConstructor
public class ListarAreaUseCase {

	private final AreaRepository areaRepository;
	
    public List<AreaResponseDTO> buscarTodos() {
        return areaRepository.buscarTodos().stream()
            .map(AreaMapper::mapToResponse)
            .collect(Collectors.toList());
    }

    public AreaResponseDTO buscarPorId(String id) {
    	
    	var area = areaRepository.buscarPorId(id)
    			.orElseThrow(() -> new AreaIdNaoInformadaException());
    	
    	return AreaMapper.mapToResponse(area);
    }
        

}
