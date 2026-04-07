package com.agro.tech.system.agrotech.domain.model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;

import com.agro.tech.system.agrotech.domain.enums.Status;
import com.agro.tech.system.agrotech.domain.exception.area.CodigoAreaNaoInformadoException;
import com.agro.tech.system.agrotech.domain.exception.area.NomeAreaNaoInformadoException;

@DisplayName("Area — testes do modelo de domínio")
public class AreaTest {
    @Test
    @DisplayName("deve criar um objeto área com todos os campos válidos")
	void AreaCreateTest() {
    	Area area = new Area("123456", "Pomar Norte", "PN-01", -23.55, -46.63, Status.ATIVO,LocalDateTime.now(),LocalDateTime.now());
    	
		Assertions.assertEquals("123456",area.getId());
		Assertions.assertEquals("Pomar Norte",area.getNome());
		Assertions.assertEquals( "PN-01", area.getCodigo());
		Assertions.assertEquals( -23.55, area.getLatitude());
		Assertions.assertEquals( -46.63, area.getLongitude());
		Assertions.assertEquals( Status.ATIVO, area.getStatus());
				
	}
    
    @Test
    @DisplayName("lançar exceção quando nome for nulo")
    void lancarExcecaoQuandoNomeForNulo() {
    	NomeAreaNaoInformadoException exception =  Assertions.assertThrows(NomeAreaNaoInformadoException.class,() ->  new Area(null, null, "PN-01", -23.55, -46.63, Status.ATIVO,null,null));
    	Assertions.assertEquals( "Nome da área é obrigatório!", exception.getMessage());
    }    
    
    @Test
    @DisplayName("lançar exceção quando código for nulo")
    void lancarExcecaoQuandoCodigoForNulo() {
    	CodigoAreaNaoInformadoException exception = Assertions.assertThrows(CodigoAreaNaoInformadoException.class,() -> new Area(null, "Pomar Norte",null, -23.55, -46.63, Status.ATIVO,null,null));
    	Assertions.assertEquals( "Código da área é obrigatório!", exception.getMessage());

    }    
    
}
