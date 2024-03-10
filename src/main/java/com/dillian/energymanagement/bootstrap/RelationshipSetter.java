package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.entities.Distributor;
import com.dillian.energymanagement.entities.Supervisor;
import com.dillian.energymanagement.services.DistributorService;
import com.dillian.energymanagement.services.SupervisorService;
import com.dillian.energymanagement.services.account.AccountService;
import com.dillian.energymanagement.utils.Constants;
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
    private final AccountService accountService;
    private final DistributorService distributorService;
    private final SupervisorService supervisorService;
    private final List<Distributor> distributors = Arrays.asList(distributorGenerator.createWithBasicProperties());
    private final List<Supervisor> supervisors = Arrays.asList(supervisorGenerator.createWithBasicProperties());

    private static final Random random = new Random();


    public List<Account> setForAccounts() {
        final List<Account> accounts = accountGenerator.createWithBasicProperties(Constants.numberOfAccounts);
        accounts.forEach(account -> account.setDistributor(pickRandomDistributor()));
        accounts.forEach(account -> account.setSupervisor(pickRandomSupervisor()));
        return accounts;
    }

    public List<Supervisor> setForSupervisors() {
        supervisors.forEach(supervisor ->
                supervisor.setAccounts(accountService.findBySupervisorLastName(supervisor.getLastName())));
        supervisors.forEach(supervisor ->
                supervisor.setDistributors(
                        List.of(distributorService.findByName("Stedin"), distributorService.findByName("Liander"))));
        return supervisors;
    }

    public List<Distributor> setForDistributors() {
        distributors.forEach(distributor ->
                distributor.setAccounts(accountService.findByDistributorName(distributor.getName())));
        distributors.forEach(distributor ->
                distributor.setSupervisors(
                        List.of(supervisorService.findById(1L), supervisorService.findById(3L))));
        return distributors;
    }

    private Distributor pickRandomDistributor() {
        Distributor[] selectedDistributors = new Distributor[]{distributors.get(0), distributors.get(1)};
        int randomIndex = random.nextInt();
        return selectedDistributors[randomIndex];
    }

    private Supervisor pickRandomSupervisor() {
        Supervisor[] selectedSupervisors = new Supervisor[]{supervisors.get(0), supervisors.get(2)};
        int randomIndex = random.nextInt();
        return selectedSupervisors[randomIndex];
    }
}
