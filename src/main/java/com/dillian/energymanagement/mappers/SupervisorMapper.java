package com.dillian.energymanagement.mappers;

import com.dillian.energymanagement.dtos.SupervisorDto;
import com.dillian.energymanagement.entities.Locality;
import com.dillian.energymanagement.entities.Supervisor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SupervisorMapper implements DtoMapper<Supervisor, SupervisorDto> {


    @Override
    public Supervisor toEntity(SupervisorDto dto) {
        final Supervisor supervisor = new Supervisor();
        supervisor.setId(dto.getId());
        supervisor.setFirstName(dto.getFirstName());
        supervisor.setLastName(dto.getLastName());
        supervisor.setProfilePicUri(dto.getProfilePicUri());
        return supervisor;
    }

    @Override
    public SupervisorDto toDto(Supervisor supervisor) {
        final SupervisorDto dto = new SupervisorDto();
        dto.setId(supervisor.getId());
        dto.setFirstName(supervisor.getFirstName());
        dto.setLastName(supervisor.getLastName());
        dto.setProfilePicUri(supervisor.getProfilePicUri());
        dto.setDistributorName(supervisor.getDistributor().getName());
        dto.setLocalityNames(supervisor.getLocalities()
                .stream()
                .map(Locality::getName)
                .toList());
        return dto;
    }
}
