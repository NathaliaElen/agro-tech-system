package com.agro.tech.system.agrotech.api.controller;

import com.agro.tech.system.agrotech.api.dto.request.PerfilRequestDTO;
import com.agro.tech.system.agrotech.api.dto.response.PerfilResponseDTO;
import com.agro.tech.system.agrotech.application.usecase.perfil.BuscarPerfilPorIdUseCase;
import com.agro.tech.system.agrotech.application.usecase.perfil.BuscarPerfilPorNomeUserCase;
import com.agro.tech.system.agrotech.application.usecase.perfil.CadastrarPerfilUseCase;
import com.agro.tech.system.agrotech.application.usecase.perfil.DeletarPerfilUseCase;
import com.agro.tech.system.agrotech.application.usecase.perfil.ListarTodosPerfilUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/perfis")
@RequiredArgsConstructor
public class PerfilController {

    private final CadastrarPerfilUseCase cadatrarPerfilUseCase;
    private final BuscarPerfilPorIdUseCase buscarPerfilPorIdUseCase;
    private final BuscarPerfilPorNomeUserCase buscarPerfilPorNomeUserCase;
    private final DeletarPerfilUseCase deletarPerfilUseCase;
    private final ListarTodosPerfilUseCase listarTodosPerfilUseCase;

    @PostMapping
    // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid PerfilRequestDTO perfilDto) {
        cadatrarPerfilUseCase.executar(perfilDto);

        // Retorna HTTP 201 (Created)
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<List<PerfilResponseDTO>> listarTodos() {
        var perfilResponseDto = listarTodosPerfilUseCase.listarTodos();

        if (perfilResponseDto == null) ResponseEntity.noContent().build();

        return ResponseEntity.ok(perfilResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilResponseDTO> buscarPorId(@PathVariable String id) {

        var perfilResponseDTO = buscarPerfilPorIdUseCase.buscarPorId(id);

        if (perfilResponseDTO == null) ResponseEntity.noContent().build();

        return ResponseEntity.ok(perfilResponseDTO);
    }

    @GetMapping("/{nome}")
    public ResponseEntity<PerfilResponseDTO> buscarPorNome(@PathVariable String nome) {
        var perfilResponseDTO = buscarPerfilPorNomeUserCase.buscarPorNome(nome);

        if (perfilResponseDTO == null) ResponseEntity.noContent().build();

        return ResponseEntity.ok(perfilResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        var perfilResponseDTO = buscarPerfilPorNomeUserCase.buscarPorNome(id);

        if (perfilResponseDTO == null) ResponseEntity.noContent().build();

        deletarPerfilUseCase.deletarPerfil(id);

        return ResponseEntity.ok().build();
    }
}
