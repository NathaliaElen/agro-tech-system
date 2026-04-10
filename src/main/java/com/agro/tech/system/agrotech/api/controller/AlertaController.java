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

import com.agro.tech.system.agrotech.api.dto.request.AlertaRequestDTO;
import com.agro.tech.system.agrotech.api.dto.response.AlertaResponseDTO;
import com.agro.tech.system.agrotech.application.usecase.alerta.DeletarAlertaUseCase;
import com.agro.tech.system.agrotech.application.usecase.alerta.ListarAlertaUseCase;
import com.agro.tech.system.agrotech.application.usecase.alerta.ManterAlertaUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/alertas")
@RequiredArgsConstructor
public class AlertaController {
	
	private final ManterAlertaUseCase manterAlertaUseCase;
	private final DeletarAlertaUseCase deletarAlertaUseCase;
	private final ListarAlertaUseCase listarAlertaUseCase;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> salvar(@RequestBody @Valid AlertaRequestDTO alertaRequestDTO) {
    	manterAlertaUseCase.salvarAlerta(alertaRequestDTO);
        return ResponseEntity.status(201).build();                
    }		
    
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        deletarAlertaUseCase.deletar(id);
        return ResponseEntity.noContent().build();
    }	
    
    @GetMapping
    public ResponseEntity<List<AlertaResponseDTO>> buscartodos() {
        return ResponseEntity.ok(listarAlertaUseCase.buscarTodos());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<AlertaResponseDTO> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok(listarAlertaUseCase.buscarPorId(id));
    }

    @GetMapping("/buscarportiposensor/{id}")
    public ResponseEntity<List<AlertaResponseDTO>> buscarPorTipoSensorId(@PathVariable String id) {
        return ResponseEntity.ok(listarAlertaUseCase.buscarPorTipoSensorId(id));
    }  

    @GetMapping("/buscarporsensor/{id}")
    public ResponseEntity<List<AlertaResponseDTO>> buscarPorSensorId(@PathVariable String id) {
        return ResponseEntity.ok(listarAlertaUseCase.buscarPorSensorId(id));
    }  
    
    @GetMapping("/buscarporprioridade/{prioridade}")
    public ResponseEntity<List<AlertaResponseDTO>> buscarPorPrioridade(@PathVariable String prioridade) {
        return ResponseEntity.ok(listarAlertaUseCase.buscarPorPrioridade(prioridade));
    }  
      
    @GetMapping("/buscarporarea/{id}")
    public ResponseEntity<List<AlertaResponseDTO>> buscarPorAreaId(@PathVariable String id) {
        return ResponseEntity.ok(listarAlertaUseCase.buscarPorAreaId(id));
    }      
    
    
}
