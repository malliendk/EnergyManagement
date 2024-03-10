package com.dillian.energymanagement.mappers;

import com.dillian.energymanagement.dtos.SupervisorDto;
import com.dillian.energymanagement.entities.Supervisor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class SupervisorMapper implements DtoMapper<Supervisor, SupervisorDto> {

    public Supervisor toEntity(SupervisorDto supervisorDto) {
        final Supervisor supervisor = new Supervisor();
        supervisor.setId(supervisorDto.getId());
        supervisor.setFirstName(supervisorDto.getFirstName());
        supervisor.setLastName(supervisorDto.getLastName());
        supervisor.setProfilePicUri(supervisorDto.getProfilePicUri());
        return supervisor;
    }

    public SupervisorDto toDto(Supervisor supervisor) {
        final SupervisorDto dto = new SupervisorDto();
        dto.setId(supervisor.getId());
        dto.setFirstName(supervisor.getFirstName());
        dto.setLastName(supervisor.getLastName());
        dto.setProfilePicUri(supervisor.getProfilePicUri());
        return dto;
    }
}
