package com.dillian.energymanagement.controllers;

import com.dillian.energymanagement.dtos.LoadSourceDto;
import com.dillian.energymanagement.services.LoadSourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/source")
public class LoadSourceController {

    private final LoadSourceService loadSourceService;

    public LoadSourceController(LoadSourceService loadSourceService) {
        this.loadSourceService = loadSourceService;
    }

    @GetMapping
    public ResponseEntity<List<LoadSourceDto>> findAll() {
        List<LoadSourceDto> loadSources = loadSourceService.findAll();
        return ResponseEntity.ok(loadSources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoadSourceDto> findById(@PathVariable Long id) {
        try {
            LoadSourceDto loadSource = loadSourceService.findById(id);
            return ResponseEntity.ok(loadSource);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<LoadSourceDto> findByName(@PathVariable String name) {
        try {
            LoadSourceDto loadSource = loadSourceService.findByName(name);
            return ResponseEntity.ok(loadSource);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

