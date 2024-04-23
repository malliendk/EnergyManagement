package com.dillian.energymanagement.services.account;

import com.dillian.energymanagement.dtos.AccountDto;
import com.dillian.energymanagement.entities.Account;

import java.util.List;

public interface AccountService {
    AccountDto create(Account account);

    List<AccountDto> findAll();

    List<AccountDto> findAllByLocality(String name);

    AccountDto findById(Long id);

    AccountDto update(Long id, Account account);

    void delete(Long id);

    void startOptimizeSupply();

    void stopOptimizeSupply();

//    List<AccountDto> resetAccounts();
}
