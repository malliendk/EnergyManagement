package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.entities.Supervisor;
import com.dillian.energymanagement.repositories.AccountRepository;
import com.dillian.energymanagement.services.SupervisorService;
import com.dillian.energymanagement.services.SupplyCategorizer;
import com.dillian.energymanagement.utils.Localities;
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
    private final SupervisorService supervisorService;
    private static final Random random = new Random();


    public List<Account> generateAccounts(int numberOfAccounts) {
        List<Account> accounts = new ArrayList<>();
        for (int i = 0; i < numberOfAccounts; i++) {
            Account account = createAccountWithRandomData((long) i);
            accountRepository.save(account);
            accounts.add(account);
        }
        return accounts;
    }


    private Account createAccountWithRandomData(Long id) {
        Account account = new Account();
        account.setId(id);
        account.setLocation(getRandomLocation());
        double energySupply = getRandomSupplyAmount();
        account.setSupplyAmount(energySupply);
        supplyCategorizer.categorizeSupply(account);
        Supervisor supervisor = supervisorService.findById(1L);
        account.setSupervisor(supervisor);
        return account;
    }

    private String getRandomLocation() {
        int randomElement = random.nextInt(Localities.localities.length);
        return Localities.localities[randomElement];
    }

    private double getRandomSupplyAmount() {
        return 0.3 + (Math.random() * 1.7);
    }
}
