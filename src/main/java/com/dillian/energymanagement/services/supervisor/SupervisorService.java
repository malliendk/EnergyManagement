package com.dillian.energymanagement.services.supervisor;

import com.dillian.energymanagement.dtos.SupervisorDto;
import com.dillian.energymanagement.entities.Supervisor;

import java.util.List;

public interface SupervisorService {
    SupervisorDto create(Supervisor supervisor);

    List<SupervisorDto> findAll();

    SupervisorDto findById(Long id);

    SupervisorDto update(Long id, Supervisor supervisor);

    void delete(Long id);
}
