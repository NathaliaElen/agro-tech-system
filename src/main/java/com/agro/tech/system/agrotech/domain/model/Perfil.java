package com.agro.tech.system.agrotech.domain.model;

import com.agro.tech.system.agrotech.domain.enums.Status;
import com.agro.tech.system.agrotech.domain.exception.perfil.NomeDoPerfilNaoInformadoException;
import com.agro.tech.system.agrotech.domain.exception.perfil.PerfilIdNaoInformadoException;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter 
@ToString
public class Perfil {
	private String id;
	private String nome;
	private Status status;
	private LocalDateTime criadoEm;
	private String criadoPor;
	private String atualizadoPor;
	private LocalDateTime atualizadoEm;

	public Perfil(String id, String nome, Status status, LocalDateTime criadoEm, String criadoPor,  LocalDateTime atualizadoEm, String atualizadoPor) {
		super();
		this.id = id;
		this.nome = nome;
		this.status = status;
		this.criadoEm = criadoEm;
		this.criadoPor = criadoPor;
		this.atualizadoPor = atualizadoPor;
		this.atualizadoEm = atualizadoEm;
		
		// Validar se o nome é nulo ou vaio
		if (this.nome == null || this.nome.isBlank()) {
			throw new NomeDoPerfilNaoInformadoException();
		}

		// Note: allow `id` to be null for creation—only reject blank strings
		if (this.id != null && this.id.isBlank()) {
			throw new PerfilIdNaoInformadoException();
		}
	}
}
