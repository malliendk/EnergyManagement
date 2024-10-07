package com.dillian.updateservice.controllers;

import com.dillian.updateservice.dtos.GameDTO;
import com.dillian.updateservice.services.SolarPanelService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("solar-panel")
@AllArgsConstructor
public class SolarPanelSetController {

    private final SolarPanelService solarPanelService;

    @PutMapping("{offset}")
    public ResponseEntity<GameDTO> buySolarPanelSets(@PathVariable int offset, @RequestBody GameDTO gameDTO) {
        return ResponseEntity.ok(solarPanelService.buySolarPanels(offset, gameDTO));
    }
}
