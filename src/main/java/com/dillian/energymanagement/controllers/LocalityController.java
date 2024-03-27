package com.dillian.energymanagement.controllers;

import com.dillian.energymanagement.dtos.LocalityDto;
import com.dillian.energymanagement.services.locality.LocalityManagerFacade;
import com.dillian.energymanagement.services.locality.LocalityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/locality")
public class LocalityController {

    private final LocalityService localityService;
    private final LocalityManagerFacade localityManagerFacade;

    @PostMapping()
    public LocalityDto create(@RequestBody LocalityDto dto) {
        return localityManagerFacade.mapAndCreate(dto);
    }

    @GetMapping("{id}")
    public LocalityDto getById(@PathVariable Long id) {
        return localityService.findById(id);
    }


    @GetMapping()
    public List<LocalityDto> findAll() {
        return localityService.findAll();
    }

    @PutMapping("{id}")
    public LocalityDto update(@PathVariable Long id, @RequestBody LocalityDto dto) {
        return localityManagerFacade.mapAndUpdate(id, dto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        localityService.delete(id);
    }
}
