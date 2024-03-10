package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.entities.Distributor;
import com.dillian.energymanagement.entities.Supervisor;
import com.dillian.energymanagement.repositories.AccountRepository;
import com.dillian.energymanagement.repositories.DistributorRespository;
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
    private final DistributorRespository distributorRespository;

    public List<Account> saveAccounts() {
        return accountRepository.saveAll(relationshipSetter.setForAccounts());
    }

    public List<Supervisor> saveSupervisors() {
        return supervisorRepository.saveAll(relationshipSetter.setForSupervisors());
    }

    public List<Distributor> saveDistributors() {
        return distributorRespository.saveAll(relationshipSetter.setForDistributors());
    }
}
