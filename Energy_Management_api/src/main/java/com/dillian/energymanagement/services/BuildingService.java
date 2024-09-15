package com.dillian.energymanagement.services;


import com.dillian.energymanagement.dtos.BuildingDto;

import java.util.List;

public interface BuildingService {
    BuildingDto findById(Long id);

    BuildingDto findByName(String name);

    List<BuildingDto> findAll();
}
