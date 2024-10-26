package com.dillian.updateservice.services;

import com.dillian.updateservice.dtos.EventResponseDTO;
import com.dillian.updateservice.dtos.GameDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@AllArgsConstructor
@Slf4j
public class EventProcessingService {

    private final RestClient restClient;

    public void passUpdatedGameDtoToBff(GameDTO gameDTO) {
        ResponseEntity<Void> response = restClient
                .put()
                .uri("event")
                .body(gameDTO)
                .retrieve()
                .toBodilessEntity();
        if (response.getStatusCode().is2xxSuccessful()) {
            log.info("Successfully passed event to BFF");
        }
    }

    public GameDTO processEventValues(EventResponseDTO eventResponseDTO) {
        return new GameDTO();
    }
}
