package com.dillian.energymanagement.controllers;

import com.dillian.energymanagement.dtos.SupervisorDto;
import com.dillian.energymanagement.services.SupervisorService;
import com.dillian.energymanagement.utils.ImageCreationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/supervisor")
@Slf4j
public class SupervisorController {

    private final SupervisorService supervisorService;
    private final ImageCreationService imageCreationService;

    @PostMapping
    public ResponseEntity<SupervisorDto> create(@RequestBody SupervisorDto supervisorDto) {
        return ResponseEntity
                .ok(supervisorService.create(supervisorDto));
    }

    @GetMapping("all")
    public ResponseEntity<List<SupervisorDto>> findAll() {
        return ResponseEntity
                .ok(supervisorService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<SupervisorDto> findById(@PathVariable Long id) {
        return ResponseEntity
                .ok(supervisorService.findById(id));
    }

    @GetMapping("/name/{lastName}")
    public ResponseEntity<SupervisorDto> findByLastName(@PathVariable String lastName) {
        return ResponseEntity
                .ok(supervisorService.findByLastName(lastName));
    }


    @GetMapping(value = "image/{imageName}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) {
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(imageCreationService.getImage(imageName));
    }
}
