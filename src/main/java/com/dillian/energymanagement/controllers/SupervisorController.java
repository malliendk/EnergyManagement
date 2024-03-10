package com.dillian.energymanagement.controllers;

import com.dillian.energymanagement.dtos.SupervisorDashboardDto;
import com.dillian.energymanagement.dtos.SupervisorDto;
import com.dillian.energymanagement.services.SupervisorDashboardService;
import com.dillian.energymanagement.services.SupervisorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/supervisor")
@Slf4j
public class SupervisorController {

    private final SupervisorService supervisorService;
    private final SupervisorDashboardService supervisorDashboardService;

    @GetMapping("{lastName}")
    public SupervisorDto findByLastName(@PathVariable String lastName) {
        return supervisorService.findByLastName(lastName);
    }

    @GetMapping("dashboard/{lastName}")
    public SupervisorDashboardDto getSupervisorDashboard(@PathVariable String lastName) {
        log.info("dashboards");
        return supervisorDashboardService.createSupervisorDashboardDto(lastName);
    }
}
