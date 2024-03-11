package com.dillian.energymanagement.services.account;

import com.dillian.energymanagement.bootstrap.SampleRecordSaver;
import com.dillian.energymanagement.dtos.AccountDto;
import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.mappers.DtoMapper;
import com.dillian.energymanagement.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final DtoMapper<Account, AccountDto> mapper;
    private final SampleRecordSaver sampleRecordSaver;
    private final Scheduler scheduler;



    public List<Account> getAllInternal() {
        return accountRepository.findAll()
                .stream()
                .toList();
    }

    public List<AccountDto> getAll() {
        return accountRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }


    public List<AccountDto> findAllByDistributorName(String name) {
        return getAll()
                .stream()
                .filter(account -> account.getDistributor().getName().equals(name))
                .toList();
    }

    public List<AccountDto> findAllBySupervisorLastName(String lastName) {
        return getAll()
                .stream()
                .filter(account -> account.getSupervisor().getLastName().equals(lastName))
                .toList();
    }


    public void startOptimizeSupply() {
        scheduler.startOptimzingSupply(getAll());
    }

    public void stopOptimizeSupply() {
        scheduler.stopOptimzingSupply();
    }

    public List<Account> resetAccounts() {
        accountRepository.deleteAll();
        return sampleRecordSaver.saveAccounts();
    }
}
