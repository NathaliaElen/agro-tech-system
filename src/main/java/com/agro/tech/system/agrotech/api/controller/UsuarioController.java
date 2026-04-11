package com.agro.tech.system.agrotech.api.controller;

import com.agro.tech.system.agrotech.api.dto.request.UsuarioRequestDTO;
import com.agro.tech.system.agrotech.api.dto.response.UsuarioResponseDTO;
import com.agro.tech.system.agrotech.application.usecase.usuario.BuscarUsuarioPorEmailUseCase;
import com.agro.tech.system.agrotech.application.usecase.usuario.BuscarUsuarioPorIdUseCase;
import com.agro.tech.system.agrotech.application.usecase.usuario.BuscarUsuarioPorNomeUseCase;
import com.agro.tech.system.agrotech.application.usecase.usuario.CadastrarUsuarioUseCase;
import com.agro.tech.system.agrotech.application.usecase.usuario.DeletarUsuarioUseCase;
import com.agro.tech.system.agrotech.application.usecase.usuario.ListarTodosUsuariosUseCase;
import com.agro.tech.system.agrotech.domain.exception.usuario.NomeUsuarioNaoInformadoException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private final BuscarUsuarioPorNomeUseCase buscarUsuarioPorNomeUseCase;
    private final BuscarUsuarioPorEmailUseCase buscarUsuarioPorEmailUseCase;
    private final DeletarUsuarioUseCase deletarUsuarioUseCase;

    @PostMapping
    // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid UsuarioRequestDTO usuarioDto) {

        cadatrarUsuarioUseCase.executar(usuarioDto);

        // Retorna HTTP 201 (Created)
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarTodos() {
        var usuarioResponse =  listarTodosUsuariosUseCase.executar();

        if (usuarioResponse == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuarioResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarPorId(@PathVariable String id) {
        if (id.isBlank()){
            return ResponseEntity.notFound().build();
        }

        var usuarioResponse =  buscarUsuarioPorIdUsecase.executar(id);

        if (usuarioResponse == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuarioResponse);
    }

    @GetMapping("/{nome}")
    public ResponseEntity<UsuarioResponseDTO> buscarPorNome(@PathVariable String nome) {
        if (nome.isBlank()){
            throw new NomeUsuarioNaoInformadoException();
        }

        var usuarioResponse =  buscarUsuarioPorNomeUseCase.executar(nome);

        if (usuarioResponse == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuarioResponse);

    }

    @GetMapping("/{email}")
    public ResponseEntity<UsuarioResponseDTO> buscarPorEmail(@PathVariable String email) {
        var usuarioResponse =  buscarUsuarioPorEmailUseCase.executar(email);

        if (usuarioResponse == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuarioResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuarioPorId(@PathVariable String id) {

        var usuario =  buscarUsuarioPorIdUsecase.executar(id);

        if (usuario == null) ResponseEntity.notFound().build();

        deletarUsuarioUseCase.executar(id);

        return ResponseEntity.ok().build();
    }
}
