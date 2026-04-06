package com.agro.tech.system.agrotech.infra.persistence.mapper;


import com.agro.tech.system.agrotech.domain.model.Area;
import com.agro.tech.system.agrotech.infra.persistence.entity.AreaEntity;


public class AreaMapper {

    public static AreaEntity toEntity(Area area) {
        AreaEntity entity = new AreaEntity();
        entity.setId(area.getId());
        entity.setNome(area.getNome());
        entity.setCodigo(area.getCodigo());
        entity.setLatitude(area.getLatitude());
        entity.setLongitude(area.getLongitude());
        entity.setStatus(area.getStatus());
        // criadoEm e atualizadoEm são gerenciados via @PrePersist/@PreUpdate na entity
        return entity;
    }

    
    public static Area toDomain(AreaEntity entity) {
    	Area area = new Area(       
                entity.getId(),
                entity.getNome(),
                entity.getCodigo(),
                entity.getLatitude(),
                entity.getLongitude(),
                entity.getStatus(),
                entity.getCriadoEm(),
                entity.getAtualizadoEm()
        );
    	return area;
    }
}
