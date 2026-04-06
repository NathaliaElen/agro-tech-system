package com.agro.tech.system.agrotech.domain.model;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.agro.tech.system.agrotech.domain.enums.Status;
import com.agro.tech.system.agrotech.domain.exception.area.AreaIdNaoInformadaException;
import com.agro.tech.system.agrotech.domain.exception.sensor.CodigoSensorNaoInformadoException;
import com.agro.tech.system.agrotech.domain.exception.sensor.IntervaloSegundosSensorNaoInformadoException;
import com.agro.tech.system.agrotech.domain.exception.sensor.TipoSensorIdNaoInformadoException;

@DisplayName("Sensor - Testes do modelo de domínio")
public class SensorTest {
	@Test
    @DisplayName("Deve criar um Sensor com todos os campos válidos")
    void criarSensorComSucesso() {
		LocalDateTime agora = LocalDateTime.now();
		
        Sensor sensor = new Sensor(
            "123",
            "area-1",
            "tipo-sensor-1",
            "SENSOR-001",
            60,
            Status.ATIVO,
            agora,
            agora,
            agora
        );
        
        Assertions.assertEquals("123", sensor.getId());
        Assertions.assertEquals("area-1", sensor.getAreaId());
        Assertions.assertEquals("tipo-sensor-1", sensor.getTipoSensorId());
        Assertions.assertEquals("SENSOR-001", sensor.getCodigo());
        Assertions.assertEquals(60, sensor.getIntervaloSegundos());
        Assertions.assertEquals(Status.ATIVO, sensor.getStatus());
        Assertions.assertTrue(sensor.isAtivo());
    }
	
	@Test
    @DisplayName("Deve lançar exceção quando areaId não for informado")
    void lancarExcecaoQuandoAreaIdNaoInformada() {
		AreaIdNaoInformadaException exception = Assertions.assertThrows(
				AreaIdNaoInformadaException.class, () -> {
					new Sensor(
							"123",
				            null,
				            "tipo-sensor-1",
				            "SENSOR-001",
				            60,
				            Status.ATIVO,
				            null,
				            null,
				            null
					);
				}
		);
		Assertions.assertEquals("Área Id do Sensor é obrigatória!", exception.getMessage());
    }
	
	@Test
    @DisplayName("Deve lançar exceção quando tipoSensorId não for informado")
    void lancarExcecaoQuandoTipoSensorIdNaoInformada() {
		TipoSensorIdNaoInformadoException exception = Assertions.assertThrows(
				TipoSensorIdNaoInformadoException.class, () -> {
					new Sensor(
							"123",
				            "area-1",
				            null,
				            "SENSOR-001",
				            60,
				            Status.ATIVO,
				            null,
				            null,
				            null
					);
				}
		);
		Assertions.assertEquals("Tipo Sensor Id é obrigatório!", exception.getMessage());
    }
	
	@Test
    @DisplayName("Deve lançar exceção quando código não for informado")
    void lancarExcecaoQuandoCodigoNaoInformada() {
		CodigoSensorNaoInformadoException exception = Assertions.assertThrows(
				CodigoSensorNaoInformadoException.class, () -> {
					new Sensor(
							"123",
				            "area-1",
				            "tipo-sensor-1",
				            null,
				            60,
				            Status.ATIVO,
				            null,
				            null,
				            null
					);
				}
		);
		Assertions.assertEquals("Código do Sensor é obrigatório!", exception.getMessage());
    }
	
	@Test
    @DisplayName("Deve lançar exceção quando intervalo segundos não for informado")
    void lancarExcecaoQuandoIntervaloSegundosNaoInformada() {
		IntervaloSegundosSensorNaoInformadoException exception = Assertions.assertThrows(
				IntervaloSegundosSensorNaoInformadoException.class, () -> {
					new Sensor(
							"123",
				            "area-1",
				            "tipo-sensor-1",
				            "SENSOR-001",
				            null,
				            Status.ATIVO,
				            null,
				            null,
				            null
					);
				}
		);
		Assertions.assertEquals("Intervalo Segundos do Sensor é obrigatório!", exception.getMessage());
    }
}
