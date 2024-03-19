package com.dillian.energymanagement.services.distributor;

import com.dillian.energymanagement.dtos.DistributorDto;
import com.dillian.energymanagement.entities.Distributor;

import java.util.List;

public interface DistributorService {
    DistributorDto create(Distributor distributor);

    List<DistributorDto> findAll();

    DistributorDto findById(Long id);

    DistributorDto update(Long id, Distributor distributor);

    void delete(Long id);
}
