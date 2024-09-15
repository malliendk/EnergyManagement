package com.dillian.energymanagement.services.locality;

import com.dillian.energymanagement.dtos.LocalityDto;
import com.dillian.energymanagement.entities.Locality;

import java.util.List;

public interface LocalityService {
    LocalityDto create(Locality locality);

    List<LocalityDto> findAll();
    List<LocalityDto> findAllBySupervisor(String lastName);

    LocalityDto findById(Long id);

    LocalityDto update(Long id, Locality locality);

    void delete(Long id);

    List<LocalityDto> findAllByName(String localityName);

    Locality findByName(String localityName);
}
