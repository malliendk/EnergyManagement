package com.dillian.energymanagement;

import com.dillian.energymanagement.entities.Event;
import com.dillian.energymanagement.enums.TimeOfDay;
import com.dillian.energymanagement.enums.WeatherType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@Slf4j
public class WebSocketHandler extends TextWebSocketHandler {

    // Thread-safe list to store active sessions
    private final List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessions.add(session);
    }

    // Method to broadcast events to all active sessions
    public void broadcastEvent(Event event) {
        try {
            String jsonString = objectMapper.writeValueAsString(event);
            TextMessage message = new TextMessage(jsonString);
            for (WebSocketSession session : sessions) {
                session.sendMessage(message);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public void broadCastTimeOfDay(Map<TimeOfDay, WeatherType> dayWeatherMap) {
        try {
            String jsonString = objectMapper.writeValueAsString(dayWeatherMap);
            TextMessage message = new TextMessage(jsonString);
            for (WebSocketSession session : sessions) {
                session.sendMessage(message);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}

