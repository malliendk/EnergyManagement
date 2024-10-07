package com.dillian.energymanagement.services;


import com.dillian.energymanagement.dtos.building.BuildingDTO;

import java.util.List;

public interface BuildingService {

    List<BuildingDTO> findAll();

    List<BuildingDTO> findAllById(List<Long> ids);

    BuildingDTO findById(Long id) throws Exception;
}
