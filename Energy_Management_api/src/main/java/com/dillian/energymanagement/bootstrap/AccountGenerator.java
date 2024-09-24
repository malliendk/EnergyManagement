package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.SupplyType;
import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AccountGenerator {

    private final AccountRepository accountRepository;

    public void fillDataBase() {
        createInitialAccounts();
        createMultiple();
    }

    private void createInitialAccounts() {
        List<Account> initialAccounts = new ArrayList<>();
        for (long i = 0; i < 100; i++) {
            Account account = new Account();
            account.setSupplyType(SupplyType.OPTIMAL);
            account.setSupplyAmount(1.0);
            initialAccounts.add(account);
        }
        accountRepository.saveAll(initialAccounts);
    }

    private void createMultiple() {
        List<Account> accounts = new ArrayList<>();
        for (long i = 0; i < 10000; i++) {
            Account account = new Account();
            account.setSupplyAmount(getRandomSupplyAmount());
            categorize(account);
            accounts.add(account);
        }
        accountRepository.saveAll(accounts);
    }

    private void categorize(Account account){
        double supplyAmount = account.getSupplyAmount();
        if (supplyAmount >= 0.0 && supplyAmount < 0.9) {
            account.setSupplyType(SupplyType.SHORTAGE);
        } else if (supplyAmount > 0.9 && supplyAmount <= 1.1) {
            account.setSupplyType(SupplyType.OPTIMAL);
        } else if (supplyAmount > 1.1) {
            account.setSupplyType(SupplyType.SURPLUS);
        }
    }

    private double getRandomSupplyAmount() {
        return 0.3 + (Math.random() * 1.7);
    }
}
