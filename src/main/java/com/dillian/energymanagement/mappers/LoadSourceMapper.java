package com.dillian.energymanagement.mappers;

import com.dillian.energymanagement.dtos.LoadSourceDto;
import com.dillian.energymanagement.entities.LoadSource;
import org.springframework.stereotype.Component;

@Component
public class LoadSourceMapper implements DtoMapper<LoadSource, LoadSourceDto>{

    @Override
    public LoadSourceDto toDto(LoadSource loadSource) {
        LoadSourceDto dto = new LoadSourceDto();
        dto.setId(loadSource.getId());
        dto.setName(loadSource.getName());
        dto.setDescription(loadSource.getDescription());
        dto.setLoad(loadSource.getLoad());
        return dto;
    }

    @Override
    public LoadSource toEntity(LoadSourceDto dto) {
        LoadSource loadSource = new LoadSource();
        loadSource.setName(dto.getName());
        loadSource.setDescription(dto.getDescription());
        loadSource.setLoad(dto.getLoad());
        return loadSource;
    }
}
