package com.dillian.energymanagement.services;

import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountGenerator accountGenerator;
    private final Scheduler scheduler;


    public List<Account> generateAccounts(int numberOfAccounts) {
        List<Account> accountsToGenerate = accountGenerator.generateAccounts(numberOfAccounts);
        return accountRepository.saveAll(accountsToGenerate);
    }

    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    public List<Account> getShortageAccounts() {
        return getAll().stream()
                .filter(account -> account.getSupplyType().equals("shortage"))
                .toList();
    }

    public List<Account> getOptimalAccounts() {
        return getAll().stream()
                .filter(account -> account.getSupplyType().equals("optimal"))
                .toList();
    }

    public List<Account> getSurplusAccounts() {
        return getAll().stream()
                .filter(account -> account.getSupplyType().equals("surplus"))
                .toList();
    }

    public void startOptimizeSupply() {
        log.info("service level");
        scheduler.startOptimzingSupply(getAll());
    }

    public void stopOptimizeSupply() {
        scheduler.stopOptimzingSupply();
    }

    public List<Account> resetAccounts() {
        accountRepository.deleteAll();
        return accountGenerator.generateAccounts(25);
    }
}
