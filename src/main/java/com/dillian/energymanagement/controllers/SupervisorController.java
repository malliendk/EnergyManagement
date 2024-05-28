package com.dillian.energymanagement.controllers;

import com.dillian.energymanagement.dtos.SupervisorDto;
import com.dillian.energymanagement.entities.Supervisor;
import com.dillian.energymanagement.mappers.SupervisorMapper;
import com.dillian.energymanagement.services.supervisor.SupervisorManagerFacade;
import com.dillian.energymanagement.services.supervisor.SupervisorService;
import com.dillian.energymanagement.utils.ImageCreator;
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
    private final SupervisorManagerFacade supervisorManagerFacade;
    private final SupervisorMapper supervisorMapper;
    private final ImageCreator imageCreator;

    @PostMapping()
    public SupervisorDto create(@RequestBody SupervisorDto dto) {
        return supervisorManagerFacade.mapAndCreate(dto);
    }

    @GetMapping()
    public List<SupervisorDto> findAll() {
        return supervisorService.findAll();
    }

    @GetMapping("/distributor/{name}")
    public List<SupervisorDto> findAllBySupervisor(@PathVariable String name) {
        return supervisorService.findAllByDistributor(name);
    }

    @GetMapping("{id}")
    public SupervisorDto findById(@PathVariable Long id) {
        return supervisorService.findById(id);
    }

    @GetMapping("/name/{name}")
    public SupervisorDto findByName(@PathVariable String name) {
        Supervisor supervisor = supervisorService.findByLastName(name);
        return supervisorMapper.toDto(supervisor);
    }

    @GetMapping("locality/{localityName}")
    public SupervisorDto findByLocality(@PathVariable String localityName) {
        return supervisorService.findByLocalityName(localityName);
    }

    @GetMapping(value = "image/{imageName}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) {
        return imageCreator.getImage(imageName);
    }

    @PutMapping("{id}")
    public SupervisorDto update(@PathVariable Long id, @RequestBody SupervisorDto dto) {
        return supervisorManagerFacade.mapAndUpdate(id, dto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        supervisorService.delete(id);
    }
}
