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

import com.agro.tech.system.agrotech.api.dto.request.SensorRequestDTO;
import com.agro.tech.system.agrotech.api.dto.response.SensorResponseDTO;
import com.agro.tech.system.agrotech.application.usecase.sensor.DeletarSensorUseCase;
import com.agro.tech.system.agrotech.application.usecase.sensor.ListarSensorUseCase;
import com.agro.tech.system.agrotech.application.usecase.sensor.ManterSensorUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/sensores")
@RequiredArgsConstructor
public class SensorController {

  private final ManterSensorUseCase manterSensorUseCase;
  private final DeletarSensorUseCase deletarSensorUseCase;
  private final ListarSensorUseCase listarSensorUseCase;

  @PostMapping
  //@PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<Void> salvar(@RequestBody @Valid SensorRequestDTO sensorRequestDTO) {
    manterSensorUseCase.salvarSensor(sensorRequestDTO);
    return ResponseEntity.status(201).build();
  }

  @DeleteMapping("/{id}")
  //@PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<Void> deletar(@PathVariable String id) {
    deletarSensorUseCase.deletarSensor(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  //@PreAuthorize("hasRole('USER')")
  public ResponseEntity<List<SensorResponseDTO>> buscarTodos() {
    return ResponseEntity.ok(listarSensorUseCase.buscarTodos());
  }

  @GetMapping("/buscarporid/{id}")
  //@PreAuthorize("hasRole('USER')")
  public ResponseEntity<SensorResponseDTO> buscarPorId(@PathVariable String id) {
    return ResponseEntity.ok(listarSensorUseCase.buscarPorId(id));
  }

  @GetMapping("/buscarporcodigo/{codigo}")
  //@PreAuthorize("hasRole('USER')")
  public ResponseEntity<SensorResponseDTO> buscarPorCodigo(@PathVariable String codigo) {
    return ResponseEntity.ok(listarSensorUseCase.buscarPorCodigo(codigo));
  }

  @GetMapping("/buscarporareaid/{areaId}")
  //@PreAuthorize("hasRole('USER')")
  public ResponseEntity<List<SensorResponseDTO>> buscarPorAreaId(@PathVariable String areaId) {
    return ResponseEntity.ok(listarSensorUseCase.buscarPorAreaId(areaId));
  }

  @GetMapping("/buscarporstatus/{status}")
  //@PreAuthorize("hasRole('USER')")
  public ResponseEntity<List<SensorResponseDTO>> buscarPorStatus(@PathVariable String status) {
    return ResponseEntity.ok(listarSensorUseCase.buscarPorStatus(status));
  }

}
