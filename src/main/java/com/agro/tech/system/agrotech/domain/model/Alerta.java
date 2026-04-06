package com.agro.tech.system.agrotech.domain.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Alerta {
	private String id;
	private String regraId;
	private String leituraSensorId;
	private String areaId;
	private String sensorId;

	public Alerta(String id, String regraId, String leituraSensorId, String areaId, String sensorId) {
		this.id = id;
		this.regraId = regraId;
		this.leituraSensorId = leituraSensorId;
		this.areaId = areaId;
		this.sensorId = sensorId;
	}
}


