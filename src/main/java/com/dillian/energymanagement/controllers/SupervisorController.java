package com.dillian.energymanagement.controllers;

import com.dillian.energymanagement.dtos.SupervisorDashboardDto;
import com.dillian.energymanagement.dtos.SupervisorDto;
import com.dillian.energymanagement.services.SupervisorDashboardService;
import com.dillian.energymanagement.services.SupervisorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/supervisor")
public class SupervisorController {

    private final SupervisorService supervisorService;
    private final SupervisorDashboardService supervisorDashboardService;

    @GetMapping("{lastName}")
    public SupervisorDto findByLastName(@PathVariable String lastName) {
        return supervisorService.findByLastName(lastName);
    }

    @GetMapping("dashboard/{lastName}")
    public SupervisorDashboardDto getSupervisorDashboard(@PathVariable String lastName) {
        return supervisorDashboardService.createSupervisorDashboardDto(lastName);
    }
}
