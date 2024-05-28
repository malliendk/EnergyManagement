package com.dillian.energymanagement.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class SupervisorDto {

    Long id;
    String firstName;
    String lastName;
    double distributionEfficiency;
    String distributorName;
    List<String> localityNames;
}
