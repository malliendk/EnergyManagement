package com.dillian.energymanagement.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DistributorDto {

    Long id;
    String name;
    String logoUri;
    List<String> supervisorNames;
    List<Long> accountIds;
}
