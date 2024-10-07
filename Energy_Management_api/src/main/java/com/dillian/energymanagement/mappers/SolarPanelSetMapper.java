package com.dillian.energymanagement.mappers;

import com.dillian.energymanagement.dtos.SolarPanelSetDto;
import com.dillian.energymanagement.entities.SolarPanelSet;
import org.springframework.stereotype.Component;

@Component
public class SolarPanelSetMapper {

    public SolarPanelSetDto toDto(SolarPanelSet solarPanelSet) {
        SolarPanelSetDto dto = new SolarPanelSetDto();
        dto.setId(solarPanelSet.getId());
        dto.setSupplyType(solarPanelSet.getSupplyType().toString());
        dto.setSupplyAmount(solarPanelSet.getSupplyAmount());
        dto.setProduction(solarPanelSet.getProduction());
        return dto;
    }
}
