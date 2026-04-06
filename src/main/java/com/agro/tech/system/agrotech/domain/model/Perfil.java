package com.agro.tech.system.agrotech.domain.model;

import lombok.Getter;
import lombok.ToString;

@Getter 
@ToString
public class Perfil {
	private Long id;
	private String nome;
	private String descricao;
	
	public Perfil(Long id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		
		// Validar se o nome é nulo ou vaio
		if (this.nome == null || this.nome.isBlank()) {
			//throw new 
		}
	}
}
