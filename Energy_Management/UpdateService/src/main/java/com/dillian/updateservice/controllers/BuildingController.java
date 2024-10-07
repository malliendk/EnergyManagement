package com.dillian.updateservice.controllers;


import com.dillian.updateservice.dtos.GameDTO;
import com.dillian.updateservice.services.BuildingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/building")
@AllArgsConstructor
public class BuildingController {

    private final BuildingService buildingService;

    @PutMapping("{id}")
    public ResponseEntity<GameDTO> buyBuilding(@PathVariable long id, @RequestBody GameDTO gameDTO) throws Exception {
        return ResponseEntity
                .ok(buildingService.buyBuilding(id, gameDTO));
    }
}
