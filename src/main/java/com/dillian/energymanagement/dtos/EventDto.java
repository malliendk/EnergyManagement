package com.dillian.energymanagement.dtos;

import com.dillian.energymanagement.entities.LoadSource;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EventDto {

    Long id;
    String name;
    String description;
    LoadSource source;
    double loadSource;
    boolean isSpecialEvent;
}
