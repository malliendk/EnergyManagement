package com.dillian.energymanagement.services.supervisor;

import com.dillian.energymanagement.dtos.SupervisorDto;
import com.dillian.energymanagement.entities.Supervisor;
import com.dillian.energymanagement.mappers.EntityMappingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SupervisorManagerFacade {

    private final SupervisorService supervisorService;
    private final EntityMappingService entityMappingService;

    public SupervisorDto mapAndCreate(SupervisorDto dto) {
        final Supervisor supervisor = entityMappingService.mapSupervisor(dto);
        return supervisorService.create(supervisor);
    }

    public SupervisorDto mapAndUpdate(Long id, SupervisorDto dto) {
        final Supervisor supervisor = entityMappingService.mapSupervisor(dto);
        return supervisorService.update(id, supervisor);
    }
}
