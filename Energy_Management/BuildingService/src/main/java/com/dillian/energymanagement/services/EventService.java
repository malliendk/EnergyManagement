package com.dillian.energymanagement.services;

import com.dillian.energymanagement.entities.Event;
import com.dillian.energymanagement.repositories.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    private List<Event> initialEvents;

    @EventListener(ApplicationReadyEvent.class)
    private void getInitialEvents() {
        this.initialEvents = eventRepository.findAll();
    }

    public Event selectRandomEvent() {
        Random randomIndex = new Random();
        return this.initialEvents.get(randomIndex.nextInt(this.initialEvents.size()));
    }
}
