package com.dillian.energymanagement.schedulers;

import com.dillian.energymanagement.entities.Event;
import com.dillian.energymanagement.services.EventService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
@AllArgsConstructor
@Slf4j
public class EventScheduler {

    private final EventService eventService;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void schedule() {

        Runnable task = () -> {
            log.info("Executing task at: {}", + System.currentTimeMillis());
            eventService.sendEventToFrontend();
        };
        scheduler.scheduleAtFixedRate(task, 0, 120, TimeUnit.SECONDS);
    }
}
