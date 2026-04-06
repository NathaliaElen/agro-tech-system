package com.agro.tech.system.agrotech.domain.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TokenRefresh {
	private Long id;
	private Long usuarioId;
	private String jti;
	private LocalDateTime expiracaoEm;
	private LocalDateTime revogadoEm;
	
	public TokenRefresh(Long id, Long usuarioId, String jti, LocalDateTime expiracaoEm, LocalDateTime revogadoEm) {
		super();
		this.id = id;
		this.usuarioId = usuarioId;
		this.jti = jti;
		this.expiracaoEm = expiracaoEm;
		this.revogadoEm = revogadoEm;
	}
}
