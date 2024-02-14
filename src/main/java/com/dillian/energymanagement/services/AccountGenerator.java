package com.dillian.energymanagement.services;

import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.repositories.AccountRepository;
import com.dillian.energymanagement.utils.Locations;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountGenerator {

    private final AccountRepository accountRepository;
    private final SupplyCategorizer supplyCategorizer;
    private static final Random random = new Random();


    public List<Account> generateAccounts(int numberOfAccounts) {
        List<Account> accounts = new ArrayList<>();
        for (int i = 0; i < numberOfAccounts; i++) {
            Account account = createAccountWithRandomData();
            accountRepository.save(account);
            accounts.add(account);
        }
        return accounts;
    }

    public void saveOneOfEachSupplyType() {
        accountRepository.save(new Account(1L, "John", Locations.localities[0],
                "shortage", 0.2));
        accountRepository.save(new Account(2L, "Henk", Locations.localities[1],
                "optimal", 1.0));
        accountRepository.save(new Account(3L, "Paul", Locations.localities[2],
                "surplus", 1.8));
    }

    private Account createAccountWithRandomData() {
        Account account = new Account();
        account.setLocation(getRandomLocation());
        double energySupply = getRandomSupplyAmount();
        account.setSupplyAmount(energySupply);
        supplyCategorizer.categorizeSupply(account);
        return account;
    }

    private String getRandomLocation() {
        int randomElement = random.nextInt(Locations.localities.length);
        return Locations.localities[randomElement];
    }

    private double getRandomSupplyAmount() {
        return 0.3 + (Math.random() * 1.7);
    }
}
