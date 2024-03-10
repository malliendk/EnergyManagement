package com.dillian.energymanagement.services;

import com.dillian.energymanagement.repositories.DistributorRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DistributorService {

    private final DistributorRespository distributorRespository;


}
