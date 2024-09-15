package com.dillian.energymanagement.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuildingDto {

    private Long id;
    private String name;
    private String description;
    private double gridLoad;
    private int price;
}

