package com.dillian.energymanagement.services;

import com.dillian.energymanagement.dtos.SupervisorDto;
import com.dillian.energymanagement.entities.Supervisor;

import java.util.List;

public interface SupervisorService {

    SupervisorDto create(SupervisorDto supervisorDto);

    List<SupervisorDto> findAll();

    SupervisorDto findById(Long id);

    SupervisorDto findByLastName(String name);
}
