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
	
    public static Prioridade fromDescricao(String descricao) {
        for (Prioridade p : Prioridade.values()) {
            if (p.getDescricao().equals(descricao)) {
                return p;
            }
        }
        throw new IllegalArgumentException("Descrição inválida: " + descricao);
    }	
}
