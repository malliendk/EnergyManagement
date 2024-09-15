package com.dillian.energymanagement.controllers;

import com.dillian.energymanagement.dtos.BuildingDto;
import com.dillian.energymanagement.services.BuildingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/source")
public class BuildingController {

    private final BuildingService buildingService;

    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @GetMapping
    public ResponseEntity<List<BuildingDto>> findAll() {
        List<BuildingDto> loadSources = buildingService.findAll();
        return ResponseEntity.ok(loadSources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuildingDto> findById(@PathVariable Long id) {
        try {
            BuildingDto loadSource = buildingService.findById(id);
            return ResponseEntity.ok(loadSource);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<BuildingDto> findByName(@PathVariable String name) {
        try {
            BuildingDto loadSource = buildingService.findByName(name);
            return ResponseEntity.ok(loadSource);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

