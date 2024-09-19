package com.dillian.energymanagement.services;


import com.dillian.energymanagement.dtos.BuildingDto;
import com.dillian.energymanagement.entities.Building;
import com.dillian.energymanagement.mappers.DtoMapper;
import com.dillian.energymanagement.repositories.BuildlingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BuildingServiceImpl implements BuildingService {

    private final DtoMapper<Building, BuildingDto> mapper;

    private final BuildlingRepository buildlingRepository;

    @Override
    public List<BuildingDto> findAll() {
        return buildlingRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public BuildingDto findById(Long id){
        return buildlingRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow();
    }

    public Building findByNameInternal(String name) {
        return buildlingRepository.findByName(name).orElseThrow();
    }

    @Override
    public BuildingDto findByName(String name){
        return buildlingRepository.findByName(name)
                .map(mapper::toDto)
                .orElseThrow();
    }

    public List<Building> saveAllInternal(List<Building> sources) {
        return buildlingRepository.saveAll(sources);
    }

}
