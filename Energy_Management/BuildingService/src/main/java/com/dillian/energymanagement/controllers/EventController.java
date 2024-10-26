package com.dillian.energymanagement.controllers;

import com.dillian.energymanagement.schedulers.EventScheduler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("event")
@AllArgsConstructor
@Slf4j
public class EventController {

    private final EventScheduler eventScheduler;

    @PostMapping("schedule")
    public void startEventScheduler() {
        log.info("Controller started event scheduler");
        eventScheduler.schedule();
    }
}
