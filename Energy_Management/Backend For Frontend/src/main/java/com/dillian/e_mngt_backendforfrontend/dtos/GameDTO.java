package com.dillian.e_mngt_backendforfrontend.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class GameDTO {

    private Long id;
    private double totalGridLoad;
    private int environmentalScore;
    private int funds;
    private int popularity;
    private int gridCapacity;
    private double distributionEfficiency;
    private int households;
    private int publicBuildingSolarPanelCapacity;
    private double energyConsumption;
    private double energyProduction;
    private int research;
    private double goldIncome;
    private int researchIncome;
    private int popularityIncome;
    private List<BuildingDTO> buildings;
    private SupervisorDTO supervisor;
}
