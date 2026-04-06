package com.agro.tech.system.agrotech.domain.model;

import java.time.LocalDateTime;

import com.agro.tech.system.agrotech.domain.enums.Prioridade;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Alerta {
	private String id;
	private String regraId;
	private String leituraId;
	private Prioridade prioridade;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataHoraCriacao;
	private LocalDateTime dataHoraResolucao;
	private String usuarioId;
	
	
	public Alerta(String id,String regraId, String leituraId, Prioridade prioridade,String titulo, String mensagem, LocalDateTime dataHoraResolucao, String usuarioId) {
		super();
		
		
	}
	

}
