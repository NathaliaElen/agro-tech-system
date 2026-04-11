package com.agro.tech.system.agrotech.api.controller;

import com.agro.tech.system.agrotech.api.dto.request.LoginRequestDto;
import com.agro.tech.system.agrotech.api.dto.request.LoginResponseDTO;
import com.agro.tech.system.agrotech.application.usecase.login.AuthUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class AuthController {
    private final AuthUseCase authUseCase;
    @PostMapping
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDto loginRequestDTO) {
        var loginResponseDTO = authUseCase.executar(loginRequestDTO);

        return ResponseEntity.ok(loginResponseDTO);
    }
}
