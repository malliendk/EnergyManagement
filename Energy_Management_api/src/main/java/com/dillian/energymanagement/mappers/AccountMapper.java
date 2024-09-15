package com.dillian.energymanagement.mappers;

import com.dillian.energymanagement.dtos.AccountDto;
import com.dillian.energymanagement.entities.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper implements DtoMapper<Account, AccountDto> {

    @Override
    public Account toEntity(final AccountDto dto) {
        final Account account = new Account();
        account.setId(dto.getId());
        account.setSupplyType(dto.getSupplyType());
        account.setSupplyAmount(dto.getSupplyAmount());
        return account;
    }

    @Override
    public AccountDto toDto(final Account account) {
        final AccountDto dto = new AccountDto();
        dto.setId(account.getId());
        dto.setSupplyType(account.getSupplyType());
        dto.setSupplyAmount(account.getSupplyAmount());
        dto.setLocalityName(account.getLocality().getName());
        return dto;
    }
}
