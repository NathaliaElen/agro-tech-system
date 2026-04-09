package com.agro.tech.system.agrotech.api.controller;

import com.agro.tech.system.agrotech.api.dto.request.UsuarioRequestDTO;
import com.agro.tech.system.agrotech.api.dto.response.UsuarioResponseDTO;
import com.agro.tech.system.agrotech.application.usecase.usuario.BuscarUsuarioPorIdUseCase;
import com.agro.tech.system.agrotech.application.usecase.usuario.CadastrarUsuarioUseCase;
import com.agro.tech.system.agrotech.application.usecase.usuario.ListarTodosUsuariosUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Controller de usuários
@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final CadastrarUsuarioUseCase cadatrarUsuarioUseCase;
    private final ListarTodosUsuariosUseCase listarTodosUsuariosUseCase;
    private final BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUsecase;

    @PostMapping
    // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid UsuarioRequestDTO usuarioDto) {

        cadatrarUsuarioUseCase.executar(usuarioDto);

        // Retorna HTTP 201 (Created)
        return ResponseEntity.status(201).build();
    }

    public ResponseEntity<List<UsuarioResponseDTO>> listarTodos() {
        var usuarioResponse =  listarTodosUsuariosUseCase.listarTodos();

        if (usuarioResponse == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuarioResponse);
    }

    public ResponseEntity<UsuarioResponseDTO> buscarPorId(@Valid String id) {
        if (id.isBlank()){
            return ResponseEntity.notFound().build();
        }

        var usuarioResponse =  buscarUsuarioPorIdUsecase.buscarPorId(id);

        if (usuarioResponse == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuarioResponse);
    }

}
