package com.dillian.updateservice.controllers;

import com.dillian.updateservice.dtos.GameDTO;
import com.dillian.updateservice.services.BuildingService;
import com.dillian.updateservice.services.SolarPanelPurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/purchase")
@AllArgsConstructor
public class PurchaseController {

    private final BuildingService buildingService;

    private final SolarPanelPurchaseService solarPanelPurchaseService;

    @PutMapping("building/{id}")
    public ResponseEntity<GameDTO> buyBuilding(@PathVariable long id, @RequestBody GameDTO gameDTO) throws Exception {
        return ResponseEntity
                .ok(buildingService.buyBuilding(id, gameDTO));
    }

    @PutMapping("solar-panel/{offset}")
    public ResponseEntity<GameDTO> buySolarPanelSets(@PathVariable int offset, @RequestBody GameDTO gameDTO) {
        return ResponseEntity.ok(solarPanelPurchaseService.buySolarPanelSets(offset, gameDTO));
    }
}
