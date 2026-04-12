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

import com.agro.tech.system.agrotech.api.dto.request.LeituraSensorRequestDTO;
import com.agro.tech.system.agrotech.api.dto.response.LeituraSensorResponseDTO;
import com.agro.tech.system.agrotech.application.usecase.leiturasensor.DeletarLeituraSensorUseCase;
import com.agro.tech.system.agrotech.application.usecase.leiturasensor.ListarLeituraSensorUseCase;
import com.agro.tech.system.agrotech.application.usecase.leiturasensor.ManterLeituraSensorUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/leituras-sensores")
@RequiredArgsConstructor
public class LeituraSensorController {

  private final ManterLeituraSensorUseCase manterLeituraSensorUseCase;
  private final DeletarLeituraSensorUseCase deletarLeituraSensorUseCase;
  private final ListarLeituraSensorUseCase listarLeituraSensorUseCase;

  @PostMapping
  //@PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<Void> salvar(@RequestBody @Valid LeituraSensorRequestDTO leituraSensorRequestDTO) {
    manterLeituraSensorUseCase.salvarLeituraSensor(leituraSensorRequestDTO);
    return ResponseEntity.status(201).build();
  }

  @DeleteMapping("/{id}")
  //@PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<Void> deletar(@PathVariable String id) {
    deletarLeituraSensorUseCase.deletarLeituraSensor(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity<List<LeituraSensorResponseDTO>> buscarTodos() {
    return ResponseEntity.ok(listarLeituraSensorUseCase.buscarTodos());
  }

  @GetMapping("/{id}")
  public ResponseEntity<LeituraSensorResponseDTO> buscarPorId(@PathVariable String id) {
    return ResponseEntity.ok(listarLeituraSensorUseCase.buscarPorId(id));
  }

  @GetMapping("/buscarporsensorid/{sensorId}")
  public ResponseEntity<List<LeituraSensorResponseDTO>> buscarPorSensorId(@PathVariable String sensorId) {
    return ResponseEntity.ok(listarLeituraSensorUseCase.buscarPorSensorId(sensorId));
  }

  @GetMapping("/buscarporareaid/{areaId}")
  public ResponseEntity<List<LeituraSensorResponseDTO>> buscarPorAreaId(@PathVariable String areaId) {
    return ResponseEntity.ok(listarLeituraSensorUseCase.buscarPorAreaId(areaId));
  }

}
