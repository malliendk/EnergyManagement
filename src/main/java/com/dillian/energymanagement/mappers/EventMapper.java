package com.dillian.energymanagement.mappers;

import com.dillian.energymanagement.dtos.EventDto;
import com.dillian.energymanagement.entities.Event;
import org.springframework.stereotype.Component;

@Component
public class EventMapper implements DtoMapper<Event, EventDto> {

    @Override
    public EventDto toDto(Event event) {
        EventDto dto = new EventDto();
        dto.setId(event.getId());
        dto.setName(event.getName());
        dto.setDescription(event.getDescription());
        dto.setSource(event.getLoadSource());
        return dto;
    }

    @Override
    public Event toEntity(EventDto dto) {
        Event event = new Event();
        event.setName(dto.getName());
        event.setDescription(dto.getDescription());
        event.setLoadSource(dto.getSource());
        return event;
    }
}
