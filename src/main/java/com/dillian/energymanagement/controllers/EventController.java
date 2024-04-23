package com.dillian.energymanagement.controllers;

import com.dillian.energymanagement.dtos.EventDto;
import com.dillian.energymanagement.services.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/event")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<EventDto>> findAll() {
        List<EventDto> events = eventService.findAll();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDto> findById(@PathVariable Long id) {
        try {
            EventDto event = eventService.findById(id);
            return ResponseEntity.ok(event);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<EventDto> findByName(@PathVariable String name) {
        try {
            EventDto event = eventService.findByName(name);
            return ResponseEntity.ok(event);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
