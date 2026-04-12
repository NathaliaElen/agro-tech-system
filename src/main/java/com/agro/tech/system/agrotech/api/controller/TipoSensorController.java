package com.agro.tech.system.agrotech.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agro.tech.system.agrotech.api.dto.request.TipoSensorRequestDTO;
import com.agro.tech.system.agrotech.api.dto.response.TipoSensorResponseDTO;
import com.agro.tech.system.agrotech.application.usecase.tiposensor.DeletarTipoSensorUseCase;
import com.agro.tech.system.agrotech.application.usecase.tiposensor.ListarTipoSensorUseCase;
import com.agro.tech.system.agrotech.application.usecase.tiposensor.ManterTipoSensorUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tipos-sensores")
@RequiredArgsConstructor
public class TipoSensorController {

	private final ManterTipoSensorUseCase manterTipoSensorUseCase;
	private final DeletarTipoSensorUseCase deletarTipoSensorUseCase;
	private final ListarTipoSensorUseCase listarTipoSensorUseCase;

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Void> salvar(@RequestBody @Valid TipoSensorRequestDTO tipoSensorRequestDTO) {
		manterTipoSensorUseCase.salvarTipoSensor(tipoSensorRequestDTO);
		return ResponseEntity.status(201).build();
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Void> deletar(@PathVariable String id) {
		deletarTipoSensorUseCase.deletarTipoSensor(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/buscartodos")
	public ResponseEntity<List<TipoSensorResponseDTO>> buscarTodos() {
		return ResponseEntity.ok(listarTipoSensorUseCase.buscarTodos());
	}

	@GetMapping("/buscarporid/{id}")
	public ResponseEntity<TipoSensorResponseDTO> buscarPorId(@PathVariable String id) {
		return ResponseEntity.ok(listarTipoSensorUseCase.buscarPorId(id));
	}

	@GetMapping("/buscarpornome/{nome}")
	public ResponseEntity<TipoSensorResponseDTO> buscarPorNome(@PathVariable String nome) {
		return ResponseEntity.ok(listarTipoSensorUseCase.buscarPorNome(nome));
	}

	@GetMapping("/buscarporstatus/{status}")
	public ResponseEntity<List<TipoSensorResponseDTO>> buscarPorStatus(@PathVariable String status) {
		return ResponseEntity.ok(listarTipoSensorUseCase.buscarPorStatus(status));
	}

}
