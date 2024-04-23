package com.dillian.energymanagement.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoadSourceDto {

    private Long id;
    private String name;
    private String description;
    private double load;
}

