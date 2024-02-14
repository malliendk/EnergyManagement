package com.dillian.energymanagementapi;

import com.dillian.energymanagementapi.entities.Account;
import com.dillian.energymanagementapi.services.AccountGenerator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@AllArgsConstructor
@Slf4j
public class EnergyManagementApplication implements CommandLineRunner {

    private final AccountGenerator accountGenerator;

    public static void main(String[] args) {
        SpringApplication.run(EnergyManagementApplication.class, args);
    }

    @Override
    public void run(String... args) {
        accountGenerator.saveOneOfEachSupplyType();
        List<Account> generatedAccounts = accountGenerator.generateAccounts(20);
        if (generatedAccounts.isEmpty()) {
            log.info("No generated accounts found");
        }
    }
}
