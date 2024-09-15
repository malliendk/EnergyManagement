package com.dillian.energymanagement.services.account;

import com.dillian.energymanagement.dtos.AccountDto;
import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.mappers.EntityMappingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountManagerFacade {

    private final AccountServiceImpl accountService;
    private final EntityMappingService entityMappingService;

    public AccountDto mapAndCreate(AccountDto dto) {
        Account account = entityMappingService.mapAccount(dto);
        return accountService.create(account);
    }

    public AccountDto mapAndUpdate(Long id, AccountDto dto) {
        Account account = entityMappingService.mapAccount(dto);
        return accountService.update(id, account);
    }
}
