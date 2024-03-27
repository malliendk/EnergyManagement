package com.dillian.energymanagement.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LocalityDto {

    Long id;
    String name;
    String imageUrl;
    List<String> supervisorNames;
    List<Long> accountIds;
}
