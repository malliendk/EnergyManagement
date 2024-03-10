package com.dillian.energymanagement.services;

import com.dillian.energymanagement.entities.Distributor;
import com.dillian.energymanagement.repositories.DistributorRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DistributorService {

    private final DistributorRespository distributorRespository;

    public Distributor findByName(String name) {
        return distributorRespository.findByName(name).orElseThrow();
    }
}
