package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.entities.Distributor;
import com.dillian.energymanagement.entities.Supervisor;
import com.dillian.energymanagement.repositories.AccountRepository;
import com.dillian.energymanagement.repositories.DistributorRepository;
import com.dillian.energymanagement.repositories.SupervisorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class RelationshipSetter {

    private final AccountGenerator accountGenerator;
    private final DistributorGenerator distributorGenerator;
    private final SupervisorGenerator supervisorGenerator;
    private final AccountRepository accountRepository;
    private final DistributorRepository distributorRepository;
    private final SupervisorRepository supervisorRepository;
    private final List<Distributor> distributors = Arrays.asList(distributorGenerator.createWithBasicProperties());
    private final List<Supervisor> supervisors = Arrays.asList(supervisorGenerator.createWithBasicProperties());

    private static final Random random = new Random();


    public List<Account> setForAccounts(int numberOfAccounts) {
        final List<Account> accounts = accountGenerator.createWithBasicProperties(numberOfAccounts);
        accounts.forEach(account -> account.setDistributor(pickRandomDistributor()));
        accounts.forEach(account -> account.setSupervisor(pickRandomSupervisor()));
        return accounts;
    }

    public List<Supervisor> setForSupervisors() {
        supervisors.forEach(supervisor ->
                supervisor.setAccounts(accountRepository.findAll()
                        .stream()
                        .filter(account -> account.getSupervisor().getLastName().equals(supervisor.getLastName()))
                        .toList()));
        supervisors.get(0).setDistributors(List.of(
                distributorRepository.findByName("Stedin").orElseThrow(),
                distributorRepository.findByName("Liander").orElseThrow()));
        supervisors.get(1).setDistributors(List.of(
                distributorRepository.findByName("Stedin").orElseThrow(),
                distributorRepository.findByName("Liander").orElseThrow()));
        return supervisors;
    }

    public List<Distributor> setForDistributors() {
        distributors.forEach(distributor ->
                distributor.setAccounts(accountRepository.findAll()
                        .stream()
                        .filter(account ->
                                account.getDistributor().getName().equals("Stedin") ||
                                        account.getDistributor().getName().equals("Liander"))
                        .toList()));
        distributors.get(0).setSupervisors(List.of(
                supervisorRepository.findByLastName("Lupina").orElseThrow(),
                supervisorRepository.findByLastName("Savours").orElseThrow()));
        distributors.get(1).setSupervisors(List.of(
                supervisorRepository.findByLastName("Lupina").orElseThrow(),
                supervisorRepository.findByLastName("Savours").orElseThrow()));
        return distributors;
    }

    private Supervisor pickRandomSupervisor() {
        Supervisor[] selectedSupervisors = new Supervisor[]{supervisors.get(0), supervisors.get(2)};
        int randomIndex = random.nextInt();
        return selectedSupervisors[randomIndex];
    }

    private Distributor pickRandomDistributor() {
        Distributor[] selectedDistributors = new Distributor[]{distributors.get(0), distributors.get(1)};
        int randomIndex = random.nextInt();
        return selectedDistributors[randomIndex];
    }
}
