package com.dillian.energymanagement.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SupervisorDashboardService {

    private final SupplyMeanCalculator meanCalculator;


}
