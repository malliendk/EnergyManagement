package com.dillian.updateservice.services;

import com.dillian.updateservice.DayWeatherCalculationService;
import com.dillian.updateservice.dtos.BuildingDTO;
import com.dillian.updateservice.dtos.GameDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class BuildingService {

    private final WebClient webClient;
    private final GameDtoService gameDtoService;


    public GameDTO buyBuilding(Long buildingId, GameDTO gameDTO) throws Exception {
        BuildingDTO boughtBuilding = webClient
                .get()
                .uri("api/v1/building", buildingId)
                .retrieve()
                .bodyToMono(BuildingDTO.class)
                .block();
        if (boughtBuilding == null) {
            throw new Exception("Building with this id can't be found in the database");
        }
        gameDTO.getBuildings().add(boughtBuilding);
        gameDtoService.updateGameDto(gameDTO);
        return gameDTO;
    }


}
