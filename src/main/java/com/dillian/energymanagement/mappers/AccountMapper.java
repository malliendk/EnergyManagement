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
public class AccountMapper implements DtoMapper<Account, AccountDto> {

    private final DtoMapper<Distributor, DistributorDto> distributorMapper;
    private final DtoMapper<Supervisor, SupervisorDto> supervisorMapper;

    @Override
    public Account toEntity(final AccountDto dto) {
        final Account account = new Account();
        account.setId(dto.getId());
        account.setName(dto.getName());
        account.setLocation(dto.getLocation());
        account.setSupplyType(dto.getSupplyType());
        account.setSupplyAmount(dto.getSupplyAmount());
        account.setDistributor(distributorMapper.toEntity(dto.getDistributor()));
        account.setSupervisor(supervisorMapper.toEntity(dto.getSupervisor()));
        return account;
    }

    @Override
    public AccountDto toDto(final Account account) {
        final AccountDto dto = new AccountDto();
        dto.setId(account.getId());
        dto.setName(account.getName());
        dto.setLocation(account.getLocation());
        dto.setSupplyType(account.getSupplyType());
        dto.setSupplyAmount(account.getSupplyAmount());
        dto.setDistributor(distributorMapper.toDto(account.getDistributor()));
        dto.setSupervisor(supervisorMapper.toDto(account.getSupervisor()));
        return dto;
    }
}
