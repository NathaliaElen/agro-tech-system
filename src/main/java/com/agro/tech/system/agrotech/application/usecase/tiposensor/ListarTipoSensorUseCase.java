package com.agro.tech.system.agrotech.application.usecase.tiposensor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.agro.tech.system.agrotech.api.dto.response.TipoSensorResponseDTO;
import com.agro.tech.system.agrotech.domain.enums.Status;
import com.agro.tech.system.agrotech.domain.exception.tiposensor.TipoSensorIdNaoEcontradoException;
import com.agro.tech.system.agrotech.domain.exception.tiposensor.NomeTipoSensorNaoEncontradoException;
import com.agro.tech.system.agrotech.domain.mapper.TipoSensorMapper;
import com.agro.tech.system.agrotech.domain.repository.TipoSensorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListarTipoSensorUseCase {
	private final TipoSensorRepository tipoSensorRepository;

	public List<TipoSensorResponseDTO> buscarTodos() {
		return tipoSensorRepository.buscarTodos().stream()
				.map(TipoSensorMapper::toResponseDto)
				.collect(Collectors.toList());
	}

	public TipoSensorResponseDTO buscarPorId(String id) {
		var tipoSensor = tipoSensorRepository.buscarPorId(id)
				.orElseThrow(() -> new TipoSensorIdNaoEcontradoException());

		return TipoSensorMapper.toResponseDto(tipoSensor);
	}

	public TipoSensorResponseDTO buscarPorNome(String nome) {
		var tipoSensor = tipoSensorRepository.buscarPorNome(nome)
				.orElseThrow(() -> new NomeTipoSensorNaoEncontradoException());

		return TipoSensorMapper.toResponseDto(tipoSensor);
	}

	public List<TipoSensorResponseDTO> buscarPorStatus(String status) {
		return tipoSensorRepository.buscarPorStatus(Status.fromDescricao(status)).stream()
				.map(TipoSensorMapper::toResponseDto)
				.collect(Collectors.toList());
	}
}
