package com.dillian.energymanagement.services;

import com.dillian.energymanagement.dtos.DistributorDto;
import com.dillian.energymanagement.entities.Distributor;
import com.dillian.energymanagement.mappers.DtoMapper;
import com.dillian.energymanagement.repositories.DistributorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DistributorService {

    private final DistributorRepository distributorRepository;
    private final DtoMapper<Distributor, DistributorDto> mapper;

    public Distributor findByName(String name) {
        return distributorRepository.findByName(name).orElseThrow();
    }

    public List<DistributorDto> findAll() {
        return distributorRepository.findAll().stream().map(mapper::toDto).toList();
    }
}
