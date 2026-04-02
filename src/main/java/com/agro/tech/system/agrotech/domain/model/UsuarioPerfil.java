package com.agro.tech.system.agrotech.domain.model;

import com.agro.tech.system.agrotech.domain.enums.Status;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class UsuarioPerfil {
    private String Id;
    private String nome;
    private Status status;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    private String criadoPor;
    private String atualizadoPor;
}
