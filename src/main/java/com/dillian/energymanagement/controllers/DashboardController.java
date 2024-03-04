package com.dillian.energymanagement.controllers;

import com.dillian.energymanagement.dtos.SupervisorDashboardDto;
import com.dillian.energymanagement.services.SupervisorDashboardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/dashboard")
public class DashboardController {

    private final SupervisorDashboardService supervisorDashboardService;

    @GetMapping("supervisor")
    public SupervisorDashboardDto getSupervisorDashboard(String supervisorName) {
        return supervisorDashboardService.createSupervisorDashboardDto(supervisorName);
    }
}
