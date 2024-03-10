package com.dillian.energymanagement;

import com.dillian.energymanagement.bootstrap.SupervisorGenerator;
import com.dillian.energymanagement.bootstrap.AccountGenerator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
@Slf4j
public class EnergyManagementApplication implements CommandLineRunner {

    private final SupervisorGenerator supervisorGenerator;
    private final AccountGenerator accountGenerator;

    public static void main(String[] args) {
        SpringApplication.run(EnergyManagementApplication.class, args);
    }

    @Override
    public void run(String... args) {
        supervisorGenerator.createWithSimpleProperties();
        accountGenerator.generateAccounts(50);
    }
}
