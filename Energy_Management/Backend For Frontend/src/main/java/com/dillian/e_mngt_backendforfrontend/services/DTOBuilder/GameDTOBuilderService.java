package com.dillian.e_mngt_backendforfrontend.services.DTOBuilder;

import com.dillian.e_mngt_backendforfrontend.Constants;
import com.dillian.e_mngt_backendforfrontend.dtos.GameDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameDTOBuilderService {

    private final DTOStatsCalculationService statsCalculationService;

    public GameDTO buildBasicDTO(GameDTO gameDTO) {
        if (gameDTO.getFunds() == 0) {
            gameDTO.setFunds(Constants.FUNDS_STARTING_AMOUNT);
        }
        if (gameDTO.getPopularity() == 0) {
            gameDTO.setPopularity(Constants.POPULARITY_STARTING_AMOUNT);
        }
        statsCalculationService.mapSolarProduction(gameDTO.getBuildings()
                .stream()
                .filter(buildingDTO -> !buildingDTO.getSolarPanelSets().isEmpty())
                .toList());
        return statsCalculationService.calculateBasicStats(gameDTO);
    }
}
