package com.agro.tech.system.agrotech.api.controller;

import com.agro.tech.system.agrotech.api.dto.request.PerfilRequestDTO;
import com.agro.tech.system.agrotech.application.usecase.perfil.CadastrarPerfilUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perfis")
@RequiredArgsConstructor
public class PerfilController {

    private final CadastrarPerfilUseCase cadatrarPerfilUseCase;

    @PostMapping
    // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid PerfilRequestDTO perfilDto) {

        cadatrarPerfilUseCase.executar(perfilDto);

        // Retorna HTTP 201 (Created)
        return ResponseEntity.status(201).build();
    }
}
