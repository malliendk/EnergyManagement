package com.dillian.energymanagement.controllers;

import com.dillian.energymanagement.dtos.DistributorDto;
import com.dillian.energymanagement.services.distributor.DistributorManagerFacade;
import com.dillian.energymanagement.services.distributor.DistributorService;
import com.dillian.energymanagement.utils.ImageCreator;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/distributor")
public class DistributorController {

    private final DistributorService distributorService;
    private final DistributorManagerFacade distributorManagerFacade;
    private final ImageCreator imageCreator;

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

    @GetMapping(value = "image/{imageName}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) {
        return imageCreator.getImage(imageName);
    }

    @PutMapping(value = "{id}")
    public DistributorDto update(@PathVariable Long id, @RequestBody DistributorDto dto) {
        return distributorManagerFacade.mapAndUpdate(id, dto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        distributorService.delete(id);
    }
}

