package com.agro.tech.system.agrotech.domain.enums;

public enum Status {
	INATIVO("I"),
	ATIVO("A");

	private final String descricao;

	Status(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
