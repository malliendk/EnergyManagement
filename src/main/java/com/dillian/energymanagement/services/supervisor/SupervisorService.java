package com.dillian.energymanagement.services.supervisor;

import com.dillian.energymanagement.dtos.SupervisorDto;
import com.dillian.energymanagement.entities.Supervisor;

import java.util.List;

public interface SupervisorService {
    SupervisorDto create(Supervisor supervisor);

    List<SupervisorDto> findAll();

    List<SupervisorDto> findAllByDistributor(String distributorName);

    SupervisorDto findById(Long id);

    Supervisor findByLastName(String name);

    SupervisorDto update(Long id, Supervisor supervisor);

    void delete(Long id);


}
