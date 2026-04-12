package com.agro.tech.system.agrotech.api.controller;

import com.agro.tech.system.agrotech.api.dto.request.UsuarioPerfilRequestDTO;
import com.agro.tech.system.agrotech.api.dto.response.UsuarioPerfilResponseDTO;
import com.agro.tech.system.agrotech.application.usecase.usuarioperfil.BuscarUsuarioPerfilPorPerfilIdUseCase;
import com.agro.tech.system.agrotech.application.usecase.usuarioperfil.BuscarUsuarioPerfilPorUsuarioIdUseCase;
import com.agro.tech.system.agrotech.application.usecase.usuarioperfil.CadastrarUsuarioPerfilUseCase;
import com.agro.tech.system.agrotech.application.usecase.usuarioperfil.DeletarUsuarioPerfilPorUsuarioId;
import com.agro.tech.system.agrotech.application.usecase.usuarioperfil.ListarTodosUsuariosPerfilUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios-perfil")
@RequiredArgsConstructor
public class UsuarioPerfilController {
    private final CadastrarUsuarioPerfilUseCase cadastrarUsuarioPerfilUseCase;
    private final ListarTodosUsuariosPerfilUseCase listarTodosUsuariosPerfilUseCase;
    private final BuscarUsuarioPerfilPorPerfilIdUseCase buscarUsuarioPerfilPorPerfilIdUseCase;
    private final BuscarUsuarioPerfilPorUsuarioIdUseCase buscarUsuarioPerfilPorUsuarioIdUseCase;
    private final DeletarUsuarioPerfilPorUsuarioId deletarUsuarioPerfilPorUsuarioId;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid UsuarioPerfilRequestDTO requestDTO) {
        cadastrarUsuarioPerfilUseCase.executar(requestDTO);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<UsuarioPerfilResponseDTO>> listarTodos() {

        var usuarioPerfilResponse =  listarTodosUsuariosPerfilUseCase.executar();

        if (usuarioPerfilResponse == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuarioPerfilResponse);
    }

    @GetMapping("/buscarporusuarioid/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<UsuarioPerfilResponseDTO> buscarPorUsuarioId(@PathVariable String id) {
        if (id.isBlank()){
            return ResponseEntity.notFound().build();
        }

        var usuarioPerfilResponse =  buscarUsuarioPerfilPorPerfilIdUseCase.executar(id);

        if (usuarioPerfilResponse == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuarioPerfilResponse);
    }

    @GetMapping("/buscarporperfilid/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<UsuarioPerfilResponseDTO> buscarPorPerfilId(@PathVariable String id) {
        if (id.isBlank()){
            return ResponseEntity.notFound().build();
        }

        var usuarioPerfilResponse =  buscarUsuarioPerfilPorPerfilIdUseCase.executar(id);

        if (usuarioPerfilResponse == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuarioPerfilResponse);
    }

    @DeleteMapping("/deletarporusuarioid/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UsuarioPerfilResponseDTO> deletarPorUsuarioId(@PathVariable String id) {
        if (id.isBlank()){
            return ResponseEntity.notFound().build();
        }

        var usuarioPerfilResponse =  buscarUsuarioPerfilPorUsuarioIdUseCase.executar(id);

        if (usuarioPerfilResponse == null) {
            return ResponseEntity.notFound().build();
        }

        deletarUsuarioPerfilPorUsuarioId.executar(id);

        return ResponseEntity.ok(usuarioPerfilResponse);
    }

    @DeleteMapping("/deletarporperfilid/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UsuarioPerfilResponseDTO> deletarPorPerfilId(@PathVariable String id) {
        if (id.isBlank()){
            return ResponseEntity.notFound().build();
        }

        var usuarioPerfilResponse =  buscarUsuarioPerfilPorUsuarioIdUseCase.executar(id);

        if (usuarioPerfilResponse == null) {
            return ResponseEntity.notFound().build();
        }

        deletarUsuarioPerfilPorUsuarioId.executar(id);

        return ResponseEntity.ok(usuarioPerfilResponse);
    }
}
