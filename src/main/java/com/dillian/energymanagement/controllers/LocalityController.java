package com.dillian.energymanagement.controllers;

import com.dillian.energymanagement.dtos.LocalityDto;
import com.dillian.energymanagement.services.locality.LocalityManagerFacade;
import com.dillian.energymanagement.services.locality.LocalityService;
import com.dillian.energymanagement.utils.ImageCreator;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/locality")
public class LocalityController {

    private final LocalityService localityService;
    private final LocalityManagerFacade localityManagerFacade;
    private final ImageCreator imageCreator;

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

    @GetMapping("supervisor/{lastName}")
    public List<LocalityDto> findAllBySupervisor(@PathVariable String lastName) {
        return localityService.findAllBySupervisor(lastName);
    }

    @GetMapping(value = "image/{imageName}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) {
        return imageCreator.getImage(imageName);
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
