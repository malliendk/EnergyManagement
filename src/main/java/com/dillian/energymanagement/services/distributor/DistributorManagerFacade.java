package com.dillian.energymanagement.services.distributor;

import com.dillian.energymanagement.dtos.DistributorDto;
import com.dillian.energymanagement.entities.Distributor;
import com.dillian.energymanagement.mappers.EntityMappingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DistributorManagerFacade {

    private final DistributorService distributorService;
    private final EntityMappingService entityMappingService;

    public DistributorDto mapAndCreate(DistributorDto dto) {
        final Distributor distributor = entityMappingService.mapDistributor(dto);
        return distributorService.create(distributor);
    }

    public DistributorDto mapAndUpdate(Long id, DistributorDto dto) {
        final Distributor distributor = entityMappingService.mapDistributor(dto);
        return distributorService.update(id, distributor);
    }
}
