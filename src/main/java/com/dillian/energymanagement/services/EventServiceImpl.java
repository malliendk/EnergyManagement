package com.dillian.energymanagement.services;


import com.dillian.energymanagement.dtos.EventDto;
import com.dillian.energymanagement.entities.Event;
import com.dillian.energymanagement.mappers.DtoMapper;
import com.dillian.energymanagement.repositories.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final DtoMapper<Event, EventDto> mapper;

    @Override
    public List<EventDto> findAll() {
        return eventRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public EventDto findById(Long id) {
        return eventRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow();
    }

    public Event findByNameInternal(String name) {
        return eventRepository.findByName(name).orElseThrow();
    }

    @Override
    public EventDto findByName(String name) {
        return eventRepository.findByName(name)
                .map(mapper::toDto)
                .orElseThrow();
    }

    public List<Event> saveAllInternal(List<Event> events) {
        return eventRepository.saveAll(events);
    }
}
