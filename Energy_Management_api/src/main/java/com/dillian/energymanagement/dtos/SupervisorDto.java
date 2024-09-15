package com.dillian.energymanagement.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SupervisorDto {

    Long id;
    String firstName;
    String lastName;
    private double incomeRate;
    private double popRate;
    double distributionEfficiency;
}
