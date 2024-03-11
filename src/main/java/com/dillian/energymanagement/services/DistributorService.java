package com.dillian.energymanagement.services;

import com.dillian.energymanagement.dtos.DistributorDto;
import com.dillian.energymanagement.entities.Distributor;
import com.dillian.energymanagement.mappers.DtoMapper;
import com.dillian.energymanagement.repositories.DistributorRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DistributorService {

    private final DistributorRespository distributorRespository;
    private final DtoMapper<Distributor, DistributorDto> mapper;

    public Distributor findByName(String name) {
        return distributorRespository.findByName(name).orElseThrow();
    }

    public List<DistributorDto> findAll() {
        return distributorRespository.findAll().stream().map(mapper::toDto).toList();
    }
}
