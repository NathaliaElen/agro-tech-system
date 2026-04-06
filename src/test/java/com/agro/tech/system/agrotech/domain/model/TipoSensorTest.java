package com.agro.tech.system.agrotech.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.agro.tech.system.agrotech.domain.enums.Status;
import com.agro.tech.system.agrotech.domain.exception.tiposensor.NomeTipoSensorNaoInformadoException;
import com.agro.tech.system.agrotech.domain.exception.tiposensor.UnidadeMedidaTipoSensorNaoInformadoException;

@DisplayName("TipoSensor - Testes do modelo de domínio")
public class TipoSensorTest {
	@Test
    @DisplayName("Deve criar um TipoSensor com todos os campos válidos")
    void criarTipoSensorComSucesso() {
        TipoSensor tipoSensor = new TipoSensor(
            "123",
            "Temperatura",
            "Celsius",
            "Sensor de temperatura",
            Status.ATIVO
        );

        Assertions.assertEquals("123", tipoSensor.getId());
        Assertions.assertEquals("Temperatura", tipoSensor.getNome());
        Assertions.assertEquals("Celsius", tipoSensor.getUnidadeMedida());
        Assertions.assertEquals("Sensor de temperatura", tipoSensor.getDescricao());
        Assertions.assertEquals(Status.ATIVO, tipoSensor.getStatus());
        Assertions.assertTrue(tipoSensor.isAtivo());
    }
	

	@Test
    @DisplayName("Deve lançar exceção quando nome não for informado")
    void lancarExcecaoQuandoNomeNaoInformado() {
		NomeTipoSensorNaoInformadoException exception = Assertions.assertThrows(
					NomeTipoSensorNaoInformadoException.class, () -> {
						new TipoSensor(
									"123",
									null,
									"Celsius",
									"Sensor de temperatura",
									Status.ATIVO
						);
					}
		);
		Assertions.assertEquals("Nome do Tipo de Sensor é obrigatório!", exception.getMessage());
	}
	

	@Test
    @DisplayName("Deve lançar exceção quando unidade de medida não for informada")
    void lancarExcecaoQuandoUnidadeMedidaNaoInformada() {
		UnidadeMedidaTipoSensorNaoInformadoException exception = Assertions.assertThrows(
				UnidadeMedidaTipoSensorNaoInformadoException.class, () -> {
					new TipoSensor(
							"123",
							"Temnperatura",
							null,
							"Sensor de temperatura",
							Status.ATIVO
					);
				}
		);
		Assertions.assertEquals("Unidade de medida do Tipo de Sensor é obrigatório!", exception.getMessage());
    }
}
