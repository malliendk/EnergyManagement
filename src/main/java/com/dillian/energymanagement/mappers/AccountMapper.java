package com.dillian.energymanagement.mappers;

import com.dillian.energymanagement.dtos.AccountDto;
import com.dillian.energymanagement.entities.Account;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AccountMapper implements DtoMapper<Account, AccountDto> {

    @Override
    public Account toEntity(final AccountDto dto) {
        final Account account = new Account();
        account.setId(dto.getId());
        account.setName(dto.getName());
        account.setSupplyType(dto.getSupplyType());
        account.setSupplyAmount(dto.getSupplyAmount());
        return account;
    }

    @Override
    public AccountDto toDto(final Account account) {
        final AccountDto dto = new AccountDto();
        dto.setId(account.getId());
        dto.setName(account.getName());
        dto.setSupplyType(account.getSupplyType());
        dto.setSupplyAmount(account.getSupplyAmount());
        dto.setDistributorName(account.getDistributor().getName());
        dto.setLocation(account.getLocality().getName());
        return dto;
    }
}
