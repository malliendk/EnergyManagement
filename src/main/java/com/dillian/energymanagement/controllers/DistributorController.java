package com.dillian.energymanagement.controllers;

import com.dillian.energymanagement.dtos.DistributorDto;
import com.dillian.energymanagement.services.distributor.DistributorManagerFacade;
import com.dillian.energymanagement.services.distributor.DistributorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/distributors")
public class DistributorController {

    private final DistributorService distributorService;
    private final DistributorManagerFacade distributorManagerFacade;

    @PostMapping()
    public DistributorDto create(@RequestBody DistributorDto dto) {
        return distributorManagerFacade.mapAndCreate(dto);
    }

    @GetMapping("{id}")
    public DistributorDto getById(@PathVariable Long id) {
        return distributorService.findById(id);
    }

    @GetMapping()
    public List<DistributorDto> findAll() {
        return distributorService.findAll();
    }

    @PutMapping("{id}")
    public DistributorDto update(@PathVariable Long id, @RequestBody DistributorDto dto) {
        return distributorManagerFacade.mapAndUpdate(id, dto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        distributorService.delete(id);
    }
}

