package com.dillian.energymanagement.mappers;

import com.dillian.energymanagement.dtos.building.BuildingDTO;
import com.dillian.energymanagement.entities.building.*;
import org.springframework.stereotype.Component;

@Component
public class BuildingMapper {

    public BuildingDTO toBuildingDto(EnergySource energySource) {
        BuildingDTO buildingDTO = createWithGenericProperties(energySource);
        buildingDTO.setGridLoad(energySource.getGridLoad());
        buildingDTO.setEnergyProduction(energySource.getEnergyProduction());
        return buildingDTO;
    }

    public BuildingDTO toBuildingDto(GridAsset gridAsset) {
        BuildingDTO buildingDTO = createWithGenericProperties(gridAsset);
        buildingDTO.setGridLoad(gridAsset.getGridCapacityIncrease());
        return buildingDTO;
    }

    public BuildingDTO toBuildingDto(Housing housing) {
        BuildingDTO buildingDTO = createWithGenericProperties(housing);
        buildingDTO.setEnergyConsumption(housing.getEnergyConsumption());
        buildingDTO.setHouseHolds(housing.getHouseHolds());
        buildingDTO.setSolarPanelCapacity(housing.getSolarPanelCapacity());
        return buildingDTO;
    }

    public BuildingDTO toBuildingDto(PublicBuilding publicBuilding) {
        BuildingDTO buildingDTO = createWithGenericProperties(publicBuilding);
        buildingDTO.setGridLoad(publicBuilding.getGridLoad());
        buildingDTO.setEnergyConsumption(publicBuilding.getEnergyConsumption());
        buildingDTO.setSolarPanelCapacity(publicBuilding.getSolarPanelCapacity());
        buildingDTO.setResearchYield(buildingDTO.getResearchYield());
        buildingDTO.setPopularityYield(buildingDTO.getPopularityYield());
        return buildingDTO;
    }

    private BuildingDTO createWithGenericProperties(Building building) {
        BuildingDTO buildingDTO = new BuildingDTO();
        buildingDTO.setId(building.getId());
        buildingDTO.setName(building.getName());
        buildingDTO.setDescription(building.getDescription());
        buildingDTO.setPrice(building.getPrice());
        buildingDTO.setImageUri(buildingDTO.getImageUri());
        return buildingDTO;
    }
}
