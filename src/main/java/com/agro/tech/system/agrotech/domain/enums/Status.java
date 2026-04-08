package com.agro.tech.system.agrotech.domain.enums;

public enum Status {
		ATIVO("A"),
		INATIVO("I");

	private final String descricao;

	Status(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
    public static Status fromDescricao(String descricao) {
        for (Status p : Status.values()) {
            if (p.getDescricao().equals(descricao)) {
                return p;
            }
        }
        throw new IllegalArgumentException("Descrição inválida: " + descricao);
    }		
}
