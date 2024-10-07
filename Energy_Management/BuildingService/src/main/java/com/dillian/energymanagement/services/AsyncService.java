package com.dillian.energymanagement.services;

import com.dillian.energymanagement.WebSocketHandler;
import com.dillian.energymanagement.entities.Event;
import com.dillian.energymanagement.enums.TimeOfDay;
import com.dillian.energymanagement.enums.WeatherType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
@Slf4j
public class AsyncService {

    private final WebSocketHandler webSocketHandler;

    @Async
    public void sendToFrontend(Event eventToSend) {
        log.info("sending event to frontend: {}", eventToSend);
        webSocketHandler.broadcastEvent(eventToSend);

    }

    @Async
    public void sendToFrontend(Map<TimeOfDay, WeatherType> dayWeatherMap) {
        log.info("sending dayTime and weather to frontend: {}", dayWeatherMap);
        webSocketHandler.broadCastTimeOfDay(dayWeatherMap);
    }


}

