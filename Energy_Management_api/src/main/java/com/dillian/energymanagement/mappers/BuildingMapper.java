package com.dillian.energymanagement.mappers;

import com.dillian.energymanagement.dtos.BuildingDto;
import com.dillian.energymanagement.entities.Building;
import org.springframework.stereotype.Component;

@Component
public class BuildingMapper implements DtoMapper<Building, BuildingDto>{

    @Override
    public BuildingDto toDto(Building building) {
        BuildingDto dto = new BuildingDto();
        dto.setId(building.getId());
        dto.setName(building.getName());
        dto.setDescription(building.getDescription());
        dto.setGridLoad(building.getGridLoad());
        dto.setPrice(building.getPrice());
        return dto;
    }

    @Override
    public Building toEntity(BuildingDto dto) {
        Building building = new Building();
        building.setName(dto.getName());
        building.setDescription(dto.getDescription());
        building.setGridLoad(dto.getGridLoad());
        building.setPrice(dto.getPrice());
        return building;
    }
}
