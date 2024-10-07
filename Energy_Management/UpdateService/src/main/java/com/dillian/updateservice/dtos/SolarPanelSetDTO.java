package com.dillian.updateservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SolarPanelSetDTO {

    private double energyProduction;
    private int researchYield;
    private Long buildingId;
}
