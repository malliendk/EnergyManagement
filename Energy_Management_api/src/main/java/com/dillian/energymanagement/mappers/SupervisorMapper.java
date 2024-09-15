package com.dillian.energymanagement.mappers;

import com.dillian.energymanagement.dtos.SupervisorDto;
import com.dillian.energymanagement.entities.Supervisor;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class SupervisorMapper implements DtoMapper<Supervisor, SupervisorDto> {


    @Override
    public Supervisor toEntity(SupervisorDto dto) {
        final Supervisor supervisor = new Supervisor();
        supervisor.setId(dto.getId());
        supervisor.setFirstName(dto.getFirstName());
        supervisor.setLastName(dto.getLastName());
        return supervisor;
    }

    @Override
    public SupervisorDto toDto(Supervisor supervisor) {
        final SupervisorDto dto = new SupervisorDto();
        dto.setId(supervisor.getId());
        dto.setFirstName(supervisor.getFirstName());
        dto.setLastName(supervisor.getLastName());
        dto.setDistributionEfficiency(supervisor.getDistributionEfficiency());
        return dto;
    }
}
