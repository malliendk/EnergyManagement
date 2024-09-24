package com.dillian.energymanagement.services;


import com.dillian.energymanagement.dtos.AccountDto;
import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.mappers.AccountMapper;
import com.dillian.energymanagement.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;


    @Override
    public List<AccountDto> getAll() {
        return accountRepository.findAll()
                .stream()
                .map(accountMapper::toDto)
                .toList();
    }

    @Override
    public List<AccountDto> getForDto(int offset, int limit) {
        List<Account> accounts = accountRepository.getWithOffsetAndLimit(offset, limit);
        return accounts
                .stream()
                .map(accountMapper::toDto)
                .toList();
    }
}
