package com.dillian.energymanagement.controllers;

import com.dillian.energymanagement.dtos.SolarPanelSetDto;
import com.dillian.energymanagement.services.SolarPanelSetService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/solar-panel")
@Slf4j
public class SolarPanelSetController {

    private final SolarPanelSetService solarPanelSetService;


    @GetMapping("all")
    public ResponseEntity<List<SolarPanelSetDto>> findAll() {
        return ResponseEntity
                .ok(solarPanelSetService.getAll());
    }

    @PostMapping("{offset}/{limit}")
    public ResponseEntity<List<SolarPanelSetDto>> findMultiple(@PathVariable int offset, @PathVariable int limit) {
        return ResponseEntity
                .ok(solarPanelSetService.getForDto(offset, limit));
    }
}
