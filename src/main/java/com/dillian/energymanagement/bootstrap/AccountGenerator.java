package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.utils.Localities;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AccountGenerator {

    private static final Random random = new Random();


    public List<Account> createWithBasicProperties(int numberOfAccounts) {
        List<Account> accounts = new ArrayList<>();
        for (long i = 0; i < numberOfAccounts; i++) {
            Account account = new Account();
            account.setId(i);
            account.setLocation(getRandomLocation());
            account.setSupplyAmount(getRandomSupplyAmount());
            accounts.add(account);
        }
        return accounts;
    }

    private String getRandomLocation() {
        int randomElement = random.nextInt(Localities.localities.length);
        return Localities.localities[randomElement];
    }

    private double getRandomSupplyAmount() {
        return 0.3 + (Math.random() * 1.7);
    }
}
