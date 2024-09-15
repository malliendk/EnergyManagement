package com.dillian.energymanagement.services;


import com.dillian.energymanagement.dtos.BuildingDto;
import com.dillian.energymanagement.entities.Building;
import com.dillian.energymanagement.mappers.DtoMapper;
import com.dillian.energymanagement.repositories.LoadSourceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BuildingServiceImpl implements BuildingService {

    private final DtoMapper<Building, BuildingDto> mapper;

    private final LoadSourceRepository loadSourceRepository;

    @Override
    public List<BuildingDto> findAll() {
        return loadSourceRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public BuildingDto findById(Long id){
        return loadSourceRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow();
    }

    public Building findByNameInternal(String name) {
        return loadSourceRepository.findByName(name).orElseThrow();
    }

    @Override
    public BuildingDto findByName(String name){
        return loadSourceRepository.findByName(name)
                .map(mapper::toDto)
                .orElseThrow();
    }

    public List<Building> saveAllInternal(List<Building> sources) {
        return loadSourceRepository.saveAll(sources);
    }

}
