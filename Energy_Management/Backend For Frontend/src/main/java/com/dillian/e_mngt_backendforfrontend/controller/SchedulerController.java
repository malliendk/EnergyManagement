package com.dillian.e_mngt_backendforfrontend.controller;

import com.dillian.e_mngt_backendforfrontend.services.DayTimeSchedulerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("scheduler")
@AllArgsConstructor
public class SchedulerController {

    private final DayTimeSchedulerService scheduler;

    @PostMapping("start")
    public void start() {
        scheduler.scheduleDayTimeAndWeather();
    }
}
