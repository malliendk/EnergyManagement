package com.dillian.energymanagement.mappers;


import com.dillian.energymanagement.dtos.AccountDto;
import com.dillian.energymanagement.dtos.DistributorDto;
import com.dillian.energymanagement.dtos.SupervisorDto;
import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.entities.Distributor;
import com.dillian.energymanagement.entities.Supervisor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class DistributorMapper implements DtoMapper<Distributor, DistributorDto> {

    @Override
    public Distributor toEntity(final DistributorDto dto) {
        Distributor distributor = new Distributor();
        distributor.setId(dto.getId());
        distributor.setName(dto.getName());
        return distributor;
    }

    @Override
    public DistributorDto toDto(final Distributor distributor) {
        final DistributorDto dto = new DistributorDto();
        dto.setId(distributor.getId());
        dto.setName(distributor.getName());
        dto.setSupervisorNames(distributor.getSupervisors()
                .stream()
                .map(Supervisor::getLastName)
                .toList());
        dto.setAccountIds(distributor.getAccounts()
                .stream()
                .map(Account::getId)
                .toList());
        return dto;
    }
}
