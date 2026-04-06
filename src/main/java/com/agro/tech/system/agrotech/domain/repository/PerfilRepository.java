package com.agro.tech.system.agrotech.domain.repository;

import com.agro.tech.system.agrotech.domain.model.Perfil;
import com.agro.tech.system.agrotech.infra.persistence.entity.PerfilEntity;

import java.util.List;
import java.util.Optional;

public interface PerfilRepository {
    Optional<Perfil> buscarPorId(String id);
    Optional<Perfil> buscarPorNome(String nome);
    List<Perfil> ListarTodos();
    void salvar(Perfil perfil);
    void deletar(String id);
}
