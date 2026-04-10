package com.agro.tech.system.agrotech.domain.mapper;

import com.agro.tech.system.agrotech.api.dto.response.AreaResponseDTO;
import com.agro.tech.system.agrotech.domain.model.Area;

public class AreaMapper {
    
	public static AreaResponseDTO mapToResponse(Area area) {
    	
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
