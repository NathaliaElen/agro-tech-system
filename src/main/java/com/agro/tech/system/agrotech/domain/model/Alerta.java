package com.agro.tech.system.agrotech.domain.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Alerta {
	private Long id;
	private Long regraId;
	private Long leituraSensorId;
	private Long areaId;
	private Long sensorId;
}
