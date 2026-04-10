package com.agro.tech.system.agrotech.infra.persistence.repository;

import com.agro.tech.system.agrotech.infra.persistence.entity.UsuarioPerfilEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaUsuarioPerfilRepository extends JpaRepository<UsuarioPerfilEntity, Long> {
    Optional<UsuarioPerfilEntity> findByPerfilId(String perfilId);
    Optional<UsuarioPerfilEntity> findByUsuarioId(String usuarioId);
    void deleteByPerfilId(String perfilId);
    void deleteByUsuarioId(String usuarioId);
}
