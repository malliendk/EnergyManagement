package com.dillian.energymanagement.services;

import com.dillian.energymanagement.dtos.EventDTO;
import com.dillian.energymanagement.entities.Event;
import com.dillian.energymanagement.mappers.EventMapper;
import com.dillian.energymanagement.repositories.EventRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
@Slf4j
public class EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    private final RestClient restClient;

    private List<Event> initialEvents;

    @EventListener(ApplicationReadyEvent.class)
    private void getInitialEvents() {
        this.initialEvents = eventRepository.findAll();
    }

    public void sendEventToFrontend() {
        EventDTO event = selectRandomEvent();
        log.info("event to send: {}", event);
        ResponseEntity<EventDTO> response = restClient
                .post()
                .uri("event")
                .body(event)
                .retrieve()
                .toEntity(EventDTO.class);
        log.info("eventDto successfully sent: {}", response.getBody());
    }

    public EventDTO selectRandomEvent() {
        if (this.initialEvents.isEmpty()) {
            throw new IllegalStateException("There are no remaining events");
        }
        int randomIndex = new Random().nextInt(this.initialEvents.size());
        Event selectedEvent = this.initialEvents.get(randomIndex);
        this.initialEvents.remove(selectedEvent);
        return eventMapper.toDTO(selectedEvent);
    }
}
