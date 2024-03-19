package com.dillian.energymanagement.services.locality;

import com.dillian.energymanagement.dtos.LocalityDto;
import com.dillian.energymanagement.entities.Locality;
import com.dillian.energymanagement.mappers.EntityMappingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LocalityManagerFacade {

    private final LocalityService localityService;
    private final EntityMappingService entityMappingService;

    public LocalityDto mapAndCreate(LocalityDto dto) {
        Locality locality = entityMappingService.mapLocality(dto);
        return localityService.create(locality);
    }

    public LocalityDto mapAndUpdate(Long id, LocalityDto dto) {
        Locality locality = entityMappingService.mapLocality(dto);
        return localityService.update(id, locality);
    }
}
