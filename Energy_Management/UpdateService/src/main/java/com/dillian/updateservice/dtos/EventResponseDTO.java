package com.dillian.updateservice.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventResponseDTO {

    private int goldCost;
    private int popularityCost;
    private BuildingDTO building;
}
