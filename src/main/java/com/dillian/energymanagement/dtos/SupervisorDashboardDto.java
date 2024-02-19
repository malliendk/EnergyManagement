package com.dillian.energymanagement.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SupervisorDashboardDto {
    String supervisorName;
    String distributorName;
    double supplyMean;
    List<LocationNumberDto> locationsAndAccountNumber;
}
