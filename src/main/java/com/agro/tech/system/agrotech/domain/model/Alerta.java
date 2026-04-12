package com.agro.tech.system.agrotech.domain.model;

import java.time.LocalDateTime;

import com.agro.tech.system.agrotech.domain.enums.Prioridade;
import com.agro.tech.system.agrotech.domain.exception.alerta.MensagemAlertaNaoInformadaException;
import com.agro.tech.system.agrotech.domain.exception.leiturasensor.LeituraSensorIdNaoInformadaException;
import com.agro.tech.system.agrotech.domain.exception.regra.RegraIdNaoInformadaException;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Alerta {
	private String id;
	private String regraId;
	private String leituraSensorId;
	private Prioridade prioridade;
	private String titulo;
	private String mensagem;
	private LocalDateTime criadoEm;
	private LocalDateTime resolvidoEm;
	private String resolvidoUsuarioId;

	
	public Alerta(String id, String regraId, String leituraSensorId, Prioridade prioridade, String titulo, String mensagem, 
			LocalDateTime criadoEm,LocalDateTime resolvidoEm, String resolvidoUsuarioId) {
		
		if ((regraId == null) || regraId.isBlank()) {
			
			throw new RegraIdNaoInformadaException();
		}

		if ((leituraSensorId == null) || leituraSensorId.isBlank()) {
			
			throw new LeituraSensorIdNaoInformadaException();
		}		
		
		if ((mensagem == null) || mensagem.isBlank()) {
			
			throw new MensagemAlertaNaoInformadaException();
		}		

		this.id = id;
		this.regraId = regraId;
		this.leituraSensorId = leituraSensorId;
		this.prioridade = prioridade;
		this.titulo = titulo;
		this.mensagem = mensagem;
		this.criadoEm = criadoEm;
		this.resolvidoEm = resolvidoEm;
		this.resolvidoUsuarioId = resolvidoUsuarioId;
	}
}


