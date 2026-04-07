package com.agro.tech.system.agrotech.domain.model;

import java.time.LocalDateTime;

import com.agro.tech.system.agrotech.domain.enums.Prioridade;
import com.agro.tech.system.agrotech.domain.exception.alerta.*;
import com.agro.tech.system.agrotech.domain.exception.leitura.LeituraNaoInformadaException;
import com.agro.tech.system.agrotech.domain.exception.regra.RegraNaoInformadaException;

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
		
		if ( regraId == null || regraId.isBlank() ) {
			throw new RegraNaoInformadaException();
		}
		if ( leituraId == null || leituraId.isBlank() ) {
			throw new LeituraNaoInformadaException();
		}
		
		if ( mensagem == null || mensagem.isBlank() ) {
			throw new MensagemNaoInformadaException();
		}		
		this.id = id;
		this.regraId = regraId;
		this.leituraId = leituraId;
		this.prioridade = prioridade;
		this.titulo = titulo;
		this.mensagem = mensagem;
		//this.dataHoraCriacao = dataHoraCriacao;
		//this.dataHoraResolucao = dataHoraResolucao;
		//this.usuarioId;		
	}
}


