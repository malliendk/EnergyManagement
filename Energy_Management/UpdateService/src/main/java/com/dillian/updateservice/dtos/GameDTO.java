package com.dillian.updateservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GameDTO {

    private int id;
    private String name;
    private double funds;
    private double energyYield;
    private double solarPanelSetCapacity;
    private List<SolarPanelSetDTO> solarPanelSets;
    private List<BuildingDTO> buildings;
}
