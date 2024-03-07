package com.dillian.energymanagement.mappers;

import com.dillian.energymanagement.dtos.SupervisorDto;
import com.dillian.energymanagement.entities.Supervisor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SupervisorMapper {

    public SupervisorDto toDto(Supervisor supervisor) {
        final SupervisorDto dto = new SupervisorDto();
        dto.setId(supervisor.getId());
        dto.setFirstName(supervisor.getFirstName());
        dto.setLastName(supervisor.getLastName());
        return dto;
    }
}
