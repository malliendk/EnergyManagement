package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.repositories.AccountRepository;
import com.dillian.energymanagement.services.account.supply.SupplyCategorizer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AccountGenerator {

    private final SupplyCategorizer supplyCategorizer;
    private final AccountRepository accountRepository;

    public List<Account> createWithBasicProperties(int numberOfAccounts) {
        List<Account> accounts = new ArrayList<>();
        for (long i = 0; i < numberOfAccounts; i++) {
            Account account = new Account();
            account.setSupplyAmount(getRandomSupplyAmount());
            supplyCategorizer.categorize(account);
            accountRepository.save(account);
            accounts.add(account);
        }
        return accounts;
    }

    private double getRandomSupplyAmount() {
        return 0.3 + (Math.random() * 1.7);
    }
}
