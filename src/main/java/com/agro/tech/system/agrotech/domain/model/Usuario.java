package com.agro.tech.system.agrotech.domain.model;

import java.time.LocalDateTime;

import com.agro.tech.system.agrotech.domain.enums.Status;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(exclude = "senhaHash")
public class Usuario {
	private Long id;
	private String nome;
	private String email;
	private String senhaHash;
	private Status status;
	private LocalDateTime criadoEm;
	private LocalDateTime atualizadoEm;
	
	public Usuario(Long id, String nome, String email, String senhaHash, Status status, LocalDateTime criadoEm,
			LocalDateTime atualizadoEm) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senhaHash = senhaHash;
		this.status = status;
		this.criadoEm = criadoEm;
		this.atualizadoEm = atualizadoEm;
		
		// Validar se o nome é nulo ou vazio
		if (this.nome == null || this.nome.isBlank()) {
			//throw new 
		}
		
		// Validar se email é nulo ou vazio
		if (this.email == null || this.email.isBlank()) {
			//throw new
		}
		
		// Validar se senha é nula ou vazia
		if (this.senhaHash == null || this.senhaHash.isBlank()) {
			//throw new
		}
	}
	
	
}
