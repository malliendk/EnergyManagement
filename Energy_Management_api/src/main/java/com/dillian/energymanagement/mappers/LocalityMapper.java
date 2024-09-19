package com.dillian.energymanagement.mappers;

import com.dillian.energymanagement.dtos.LocalityDto;
import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.entities.Locality;
import com.dillian.energymanagement.entities.Supervisor;
import org.springframework.stereotype.Component;

@Component
public class LocalityMapper implements DtoMapper<Locality, LocalityDto> {


    @Override
    public Locality toEntity(final LocalityDto dto) {
        final Locality locality = new Locality();
        locality.setId(dto.getId());
        locality.setName(dto.getName());
        return locality;
    }

    @Override
    public LocalityDto toDto(final Locality locality) {
        final LocalityDto dto = new LocalityDto();
        dto.setId(locality.getId());
        dto.setName(locality.getName());
        dto.setStartingSourcesAmount(locality.getStartingSourcesAmount());
        dto.setSupervisorNames(locality.getSupervisors()
                .stream()
                .map(Supervisor::getLastName)
                .toList());
        dto.setAccountIds(locality.getAccounts()
                .stream()
                .map(Account::getId)
                .toList());
        return dto;
    }
}