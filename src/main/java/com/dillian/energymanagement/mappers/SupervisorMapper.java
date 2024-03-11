package com.dillian.energymanagement.mappers;

import com.dillian.energymanagement.dtos.AccountDto;
import com.dillian.energymanagement.dtos.DistributorDto;
import com.dillian.energymanagement.dtos.SupervisorDto;
import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.entities.Distributor;
import com.dillian.energymanagement.entities.Supervisor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
public class SupervisorMapper implements DtoMapper<Supervisor, SupervisorDto> {

    private final DtoMapper<Distributor, DistributorDto> distributorMapper;
    private final DtoMapper<Account, AccountDto> accountMapper;

    @Override
    public Supervisor toEntity(SupervisorDto dto) {
        final Supervisor supervisor = new Supervisor();
        supervisor.setId(dto.getId());
        supervisor.setFirstName(dto.getFirstName());
        supervisor.setLastName(dto.getLastName());
        supervisor.setProfilePicUri(dto.getProfilePicUri());
        supervisor.setAccounts(dto.getAccounts()
                .stream()
                .map(accountMapper::toEntity)
                .toList());
        supervisor.setDistributors(dto.getDistributors()
                .stream()
                .map(distributorMapper::toEntity)
                .toList());
        return supervisor;
    }

    @Override
    public SupervisorDto toDto(Supervisor supervisor) {
        final SupervisorDto dto = new SupervisorDto();
        dto.setId(supervisor.getId());
        dto.setFirstName(supervisor.getFirstName());
        dto.setLastName(supervisor.getLastName());
        dto.setProfilePicUri(supervisor.getProfilePicUri());
        dto.setAccounts(supervisor.getAccounts()
                .stream()
                .map(accountMapper::toDto)
                .toList());
        dto.setDistributors(supervisor.getDistributors()
                .stream()
                .map(distributorMapper::toDto)
                .toList());
        return dto;
    }
}
