package com.dillian.energymanagement.services.account;


import com.dillian.energymanagement.dtos.AccountDto;
import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.exceptions.AccountException;
import com.dillian.energymanagement.mappers.DtoMapper;
import com.dillian.energymanagement.repositories.AccountRepository;
import com.dillian.energymanagement.utils.Constants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final DtoMapper<Account, AccountDto> mapper;

    private final Scheduler scheduler;


    @Override
    public AccountDto create(Account account) {
        account = accountRepository.save(account);
        return mapper.toDto(account);
    }

    public List<Account> findAllInternal() {
        return accountRepository.findAll()
                .stream()
                .toList();
    }

    @Override
    public List<AccountDto> findAll() {
        return accountRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public List<Account> findAllByIdInternal(List<Long> ids) {
        return accountRepository.findAllById(ids);
    }

    @Override
    public List<AccountDto> findAllByLocality(String localityName) {
        return accountRepository.findAllByLocalityName(localityName)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public AccountDto findById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow();
        return mapper.toDto(account);
    }

    @Override
    public AccountDto update(Long id, Account account) {
        if(!id.equals(account.getId())) {
            throw new AccountException(Constants.IDS_DONT_MATCH);
        }
        account = accountRepository.save(account);
        return mapper.toDto(account);
    }

    @Override
    public void delete(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public void startOptimizeSupply() {
        scheduler.startOptimizingSupply(findAllInternal());
    }

    @Override
    public void stopOptimizeSupply() {
        scheduler.stopOptimzingSupply();
    }

//    @Override
//    public List<AccountDto> resetAccounts() {
//        accountRepository.deleteAll();
//        return sampleRecordSaver.saveAccounts(Constants.numberOfAccounts)
//                .stream()
//                .map(mapper::toDto)
//                .toList();
//    }
}