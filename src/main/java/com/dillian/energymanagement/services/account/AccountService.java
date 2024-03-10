package com.dillian.energymanagement.services.account;

import com.dillian.energymanagement.bootstrap.SampleRecordSaver;
import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final SampleRecordSaver sampleRecordSaver;
    private final Scheduler scheduler;



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

    public List<Account> findByDistributorName(String name) {
        return getAll()
                .stream()
                .filter(account -> account.getDistributor().getName().equals(name))
                .toList();
    }

    public List<Account> findBySupervisorLastName(String lastName) {
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
