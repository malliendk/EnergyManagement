package com.dillian.updateservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuildingDTO {

    private Long id;
    private String name;
    private String description;
    private int price;
    private String imageUri;
    private double gridCapacityIncrease;
    private double energyProduction;
    private int houseHolds;
    private double energyConsumption;
    private int solarPanelCapacity;
    private double popularityYield;
    private int researchYield;
    private int incomeYield;
    private SolarPanelSetDTO solarPanelSet;
}

