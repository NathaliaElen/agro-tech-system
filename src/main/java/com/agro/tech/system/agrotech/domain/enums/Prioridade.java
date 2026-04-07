package com.agro.tech.system.agrotech.domain.enums;

public enum Prioridade {
	BAIXA("B"),	
	MEDIA("M"),	
	ALTA("A"),	
	CRITICA("C");

	private final String descricao;

	Prioridade(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
