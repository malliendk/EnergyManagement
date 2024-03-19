package com.dillian.energymanagement.controllers;

import com.dillian.energymanagement.dtos.SupervisorDto;
import com.dillian.energymanagement.services.supervisor.SupervisorManagerFacade;
import com.dillian.energymanagement.services.supervisor.SupervisorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/supervisors")
@Slf4j
public class SupervisorController {

    private final SupervisorService supervisorService;
    private final SupervisorManagerFacade supervisorManagerFacade;

    @PostMapping()
    public SupervisorDto create(@RequestBody SupervisorDto dto) {
        return supervisorManagerFacade.mapAndCreate(dto);
    }

    @GetMapping()
    public List<SupervisorDto> findAll() {
        return supervisorService.findAll();
    }

    @GetMapping("{id}")
    public SupervisorDto getById(Long id) {
        return supervisorService.findById(id);
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
