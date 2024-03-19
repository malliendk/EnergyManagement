package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.repositories.AccountRepository;
import com.dillian.energymanagement.services.account.supply.SupplyCategorizer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AccountGenerator {

    private final SupplyCategorizer supplyCategorizer;
    private final AccountRepository repository;

    public List<Account> createWithBasicProperties(int numberOfAccounts) {
        List<Account> accounts = new ArrayList<>();
        for (long i = 0; i < numberOfAccounts; i++) {
            Account account = new Account();
            account.setSupplyAmount(getRandomSupplyAmount());
            supplyCategorizer.categorize(account);
            repository.save(account);
            accounts.add(account);
        }
        return accounts;
    }

    private double getRandomSupplyAmount() {
        return 0.3 + (Math.random() * 1.7);
    }
}
