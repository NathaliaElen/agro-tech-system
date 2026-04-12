package com.agro.tech.system.agrotech.application.usecase.area;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.agro.tech.system.agrotech.api.dto.request.AreaRequestDTO;
import com.agro.tech.system.agrotech.domain.enums.Status;
import com.agro.tech.system.agrotech.domain.model.Area;
import com.agro.tech.system.agrotech.domain.repository.AreaRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ManterAreaUseCase {

	private final AreaRepository areaRepository;
	
	
	public Area salvarArea(AreaRequestDTO areaRequestDto) {

		String id = (areaRequestDto.id() == null || areaRequestDto.id().isBlank()) ? null : areaRequestDto.id();
		Area area = new Area(
				id,
				areaRequestDto.nome(),
				areaRequestDto.codigo(),
				areaRequestDto.latitude(),
				areaRequestDto.longitude(),
				Status.fromDescricao(areaRequestDto.status()),
				LocalDateTime.now(),
				LocalDateTime.now());
		
		
		return areaRepository.salvar(area);
		
	}
}
