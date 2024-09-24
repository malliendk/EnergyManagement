package com.dillian.energymanagement;

import com.dillian.energymanagement.bootstrap.SupervisorGenerator;
import com.dillian.energymanagement.repositories.AccountRepository;
import com.dillian.energymanagement.repositories.SupervisorRepository;
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

    private final AccountRepository accountRepository;
    private final AccountGenerator accountGenerator;
    private final SupervisorGenerator supervisorGenerator;
    private final SupervisorRepository supervisorRepository;

    public static void main(String[] args) {
        SpringApplication.run(EnergyManagementApplication.class, args);
    }

    @Override
    public void run(String... args) {
        if (accountRepository.findAll().isEmpty()) {
            log.info("account repository empty, generating initial accounts");
            accountGenerator.fillDataBase();
        } else {
            log.info("Accounts found in database");
        }
        if (supervisorRepository.findAll().isEmpty()) {
            supervisorGenerator.createInitialSupervisors();
        } else {
            log.info("Supervisors found in database");
        }
    }
}
