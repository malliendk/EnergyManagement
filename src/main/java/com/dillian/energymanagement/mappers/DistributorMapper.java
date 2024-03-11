package com.dillian.energymanagement.mappers;


import com.dillian.energymanagement.dtos.AccountDto;
import com.dillian.energymanagement.dtos.DistributorDto;
import com.dillian.energymanagement.dtos.SupervisorDto;
import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.entities.Distributor;
import com.dillian.energymanagement.entities.Supervisor;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DistributorMapper implements DtoMapper<Distributor, DistributorDto> {

    private final DtoMapper<Account, AccountDto> accountMapper;
    private final DtoMapper<Supervisor, SupervisorDto> supervisorMapper;
    @Override
    public Distributor toEntity(final DistributorDto dto) {
        Distributor distributor = new Distributor();
        distributor.setId(dto.getId());
        distributor.setName(dto.getName());
        distributor.setLogoUri(dto.getLogoUri());
        distributor.setAccounts(dto.getAccounts()
                .stream()
                .map(accountMapper::toEntity)
                .toList());
        distributor.setSupervisors(dto.getSupervisors()
                .stream()
                .map(supervisorMapper::toEntity)
                .toList());
        return distributor;
    }

    @Override
    public DistributorDto toDto(final Distributor distributor) {
        final DistributorDto dto = new DistributorDto();
        dto.setId(distributor.getId());
        dto.setName(distributor.getName());
        dto.setLogoUri(distributor.getLogoUri());
        dto.setAccounts(distributor.getAccounts()
                .stream()
                .map(accountMapper::toDto)
                .toList());
        dto.setSupervisors(distributor.getSupervisors()
                .stream()
                .map(supervisorMapper::toDto)
                .toList());
        return dto;
    }
}
