package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.entities.Distributor;
import com.dillian.energymanagement.entities.Supervisor;
import com.dillian.energymanagement.repositories.AccountRepository;
import com.dillian.energymanagement.repositories.DistributorRepository;
import com.dillian.energymanagement.repositories.SupervisorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SampleRecordSaver {

    private final RelationshipSetter relationshipSetter;
    private final AccountRepository accountRepository;
    private final SupervisorRepository supervisorRepository;
    private final DistributorRepository distributorRepository;

    public List<Account> saveAccounts(int numberOfAccounts) {
        return accountRepository.saveAll(relationshipSetter.setForAccounts(numberOfAccounts));
    }

    public List<Supervisor> saveSupervisors() {
        return supervisorRepository.saveAll(relationshipSetter.setForSupervisors());
    }

    public List<Distributor> saveDistributors() {
        return distributorRepository.saveAll(relationshipSetter.setForDistributors());
    }
}
