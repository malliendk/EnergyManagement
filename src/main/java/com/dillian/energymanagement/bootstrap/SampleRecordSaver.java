package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.entities.Distributor;
import com.dillian.energymanagement.entities.Locality;
import com.dillian.energymanagement.entities.Supervisor;
import com.dillian.energymanagement.repositories.AccountRepository;
import com.dillian.energymanagement.repositories.DistributorRepository;
import com.dillian.energymanagement.repositories.LocalityRepository;
import com.dillian.energymanagement.repositories.SupervisorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SampleRecordSaver {

    private final AccountRepository accountRepository;
    private final SupervisorRepository supervisorRepository;
    private final DistributorRepository distributorRepository;
    private final LocalityRepository localityRepository;

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    public Supervisor saveSupervisor(Supervisor supervisor) {
        return supervisorRepository.save(supervisor);
    }

    public Distributor saveDistributor(Distributor distributor) {
        return distributorRepository.save(distributor);
    }

    public Locality saveLocality(Locality locality) {
        return localityRepository.save(locality);
    }


    public List<Account> saveAccounts(List<Account> accounts) {
        return accountRepository.saveAll(accounts);
    }
    public List<Supervisor> saveSupervisors(List<Supervisor> supervisors) {
        return supervisorRepository.saveAll(supervisors);
    }
    public List<Distributor> saveDistributors(List<Distributor> distributors) {
        return distributorRepository.saveAll(distributors);
    }
    public List<Locality> saveLocalities(List<Locality> localities) {
        return localityRepository.saveAll(localities);
    }
}
