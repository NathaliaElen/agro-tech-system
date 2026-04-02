package com.agro.tech.system.agrotech.domain.model;

import java.time.LocalDateTime;

import com.agro.tech.system.agrotech.domain.enums.Status;

import com.agro.tech.system.agrotech.domain.exception.usuario.EmailUsuarioInvalidoException;
import com.agro.tech.system.agrotech.domain.exception.usuario.EmailUsuarioNaoInformadoException;
import com.agro.tech.system.agrotech.domain.exception.usuario.NomeUsuarioNaoInformadoException;
import com.agro.tech.system.agrotech.domain.exception.usuario.SenhaUsuarioNaoInformadaException;
import com.agro.tech.system.agrotech.domain.extensions.validations.EmailValidator;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(exclude = "senhaHash")
public class Usuario {
	private String id;
	private String nome;
	private String email;
	private String senhaHash;
	private Status status;
	private LocalDateTime criadoEm;
	private LocalDateTime atualizadoEm;
	private String criadoPor;
	private String atualizadoPor;
	UsuarioPerfil usuarioPerfil;
	
	public Usuario(String id, String nome, String email, String senhaHash, Status status, LocalDateTime criadoEm,
			LocalDateTime atualizadoEm, UsuarioPerfil usuarioPerfil, String criadoPor, String atualizadoPor) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senhaHash = senhaHash;
		this.status = status;
		this.criadoEm = criadoEm;
		this.criadoPor = criadoPor;
		this.atualizadoEm = atualizadoEm;
		this.atualizadoPor = atualizadoPor;
		this.usuarioPerfil = usuarioPerfil;

		// Validar se o nome é nulo ou vazio
		if (this.nome == null || this.nome.isBlank()) {
			throw new NomeUsuarioNaoInformadoException();
		}

		// Validar se email é nulo ou vazio
		if (this.email == null || this.email.isBlank()) {
			throw new EmailUsuarioNaoInformadoException();
		}

		if (!EmailValidator.isValido(this.email)) {
			throw new EmailUsuarioInvalidoException();
		}

		// Validar se senha é nula ou vazia
		if (this.senhaHash == null || this.senhaHash.isBlank()) {
			throw new SenhaUsuarioNaoInformadaException();
		}
	}

	public boolean isAdmin() {
		return this.usuarioPerfil.getNome().equals("ADMIN");
	}
}
