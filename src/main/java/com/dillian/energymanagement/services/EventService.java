package com.dillian.energymanagement.services;

import com.dillian.energymanagement.dtos.EventDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService {
    List<EventDto> findAll();

    EventDto findById(Long id);

    EventDto findByName(String name);
}
