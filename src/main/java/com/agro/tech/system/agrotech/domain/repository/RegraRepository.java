package com.agro.tech.system.agrotech.domain.repository;

import java.util.List;
import java.util.Optional;

import com.agro.tech.system.agrotech.domain.model.Regra;

public interface RegraRepository {
	
	Regra salvar(Regra regra);
    Optional<Regra> buscarPorId(String id);
    List<Regra> buscarTodos();
    void deletar(String id);	

}
