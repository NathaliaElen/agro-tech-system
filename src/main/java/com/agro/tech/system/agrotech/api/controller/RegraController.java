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

import com.agro.tech.system.agrotech.api.dto.request.RegraRequestDTO;
import com.agro.tech.system.agrotech.api.dto.response.RegraResponseDTO;
import com.agro.tech.system.agrotech.application.usecase.regra.DeletarRegraUseCase;
import com.agro.tech.system.agrotech.application.usecase.regra.ListarRegraUseCase;

import com.agro.tech.system.agrotech.application.usecase.regra.ManterRegraUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/regras")
@RequiredArgsConstructor
public class RegraController {

	private final ManterRegraUseCase manterRegraUseCase;
	private final DeletarRegraUseCase deletarRegraUseCase;
	private final ListarRegraUseCase listarRegraUseCase;

    @PostMapping
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> salvar(@RequestBody @Valid RegraRequestDTO regraRequestDTO) {
    	manterRegraUseCase.salvarRegra(regraRequestDTO);
        return ResponseEntity.status(201).build();                
    }	
        
    @DeleteMapping("/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
    	deletarRegraUseCase.deletar(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<RegraResponseDTO>> buscartodos() {
        return ResponseEntity.ok(listarRegraUseCase.buscarTodos());
    }
    
    @GetMapping("/{id}")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity<RegraResponseDTO> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok(listarRegraUseCase.buscarPorId(id));
    }
    
    @GetMapping("/buscarportiposensor/{id}")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<RegraResponseDTO>> buscarPorTipoSensorId(@PathVariable String id) {
        return ResponseEntity.ok(listarRegraUseCase.buscarPorTipoSensorId(id));
    } 
    
    @GetMapping("/buscarporsensor/{id}")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<RegraResponseDTO>> buscarPorSensorId(@PathVariable String id) {
        return ResponseEntity.ok(listarRegraUseCase.buscarPorSensorId(id));
    }  
    
    @GetMapping("/buscarporprioridade/{prioridade}")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<RegraResponseDTO>> buscarPorPrioridade(@PathVariable String prioridade) {
        return ResponseEntity.ok(listarRegraUseCase.buscarPorPrioridade(prioridade));
    }  
    
    @GetMapping("/buscarporarea/{id}")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<RegraResponseDTO>> buscarPorAreaId(@PathVariable String id) {
        return ResponseEntity.ok(listarRegraUseCase.buscarPorAreaId(id));
    }      
    
}
