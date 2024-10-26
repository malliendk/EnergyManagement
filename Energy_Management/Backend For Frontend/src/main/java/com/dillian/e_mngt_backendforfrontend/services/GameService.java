package com.dillian.e_mngt_backendforfrontend.services;

import com.dillian.e_mngt_backendforfrontend.dtos.GameDTO;
import com.dillian.e_mngt_backendforfrontend.services.DTOBuilder.GameDTOBuilderService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@Getter
public class GameService {

    private GameDTO currentGameDto;

    private final GameDTOPostService gameDtoPostService;
    private final GameDTOBuilderService gameDTOBuilderService;

    public GameService(GameDTOPostService gameDtoPostService, GameDTOBuilderService gameDTOBuilderService) {
        this.gameDtoPostService = gameDtoPostService;
        this.gameDTOBuilderService = gameDTOBuilderService;
    }

    public GameDTO updateDTO(GameDTO gameDTO) {
        return gameDTOBuilderService.b
    }

    public void startGame(GameDTO gameDTO) {

        this.currentGameDto = gameDTOBuilderService.;

        gameDtoPostService.post(gameDTO);
    }



}

