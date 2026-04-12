package com.agro.tech.system.agrotech.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;

import com.agro.tech.system.agrotech.api.dto.request.AreaRequestDTO;
import com.agro.tech.system.agrotech.api.dto.response.AreaResponseDTO;
import com.agro.tech.system.agrotech.application.usecase.area.DeletarAreaUseCase;
import com.agro.tech.system.agrotech.application.usecase.area.ListarAreaUseCase;
import com.agro.tech.system.agrotech.application.usecase.area.ManterAreaUseCase;


@RestController
@RequestMapping("/areas")
@RequiredArgsConstructor
public class AreaController {

	private final ManterAreaUseCase manterAreaUseCase;
	private final DeletarAreaUseCase deletarAreaUseCase;
	private final ListarAreaUseCase listarAreaUseCase;
	
    @PostMapping
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> salvar(@RequestBody @Valid AreaRequestDTO dto) {
    	manterAreaUseCase.salvarArea(dto);
        return ResponseEntity.status(201).build();
                
    }	
    
    @DeleteMapping("/{id}")
   //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        deletarAreaUseCase.deletar(id);
        return ResponseEntity.noContent().build();
    }	
        
    @GetMapping
    public ResponseEntity<List<AreaResponseDTO>> buscartodos() {
        return ResponseEntity.ok(listarAreaUseCase.buscarTodos());
    }	 
    
    @GetMapping("/{id}")
    public ResponseEntity<AreaResponseDTO> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok(listarAreaUseCase.buscarPorId(id));
    }
    
}
