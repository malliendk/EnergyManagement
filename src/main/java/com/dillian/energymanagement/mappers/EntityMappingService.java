package com.dillian.energymanagement.mappers;

import com.dillian.energymanagement.dtos.AccountDto;
import com.dillian.energymanagement.dtos.DistributorDto;
import com.dillian.energymanagement.dtos.LocalityDto;
import com.dillian.energymanagement.dtos.SupervisorDto;
import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.entities.Distributor;
import com.dillian.energymanagement.entities.Locality;
import com.dillian.energymanagement.entities.Supervisor;
import com.dillian.energymanagement.services.account.AccountServiceImpl;
import com.dillian.energymanagement.services.distributor.DistributorServiceImpl;
import com.dillian.energymanagement.services.locality.LocalityServiceImpl;
import com.dillian.energymanagement.services.supervisor.SupervisorServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EntityMappingService {

    private final DtoMapper<Account, AccountDto> accountMapper;
    private final DtoMapper<Distributor, DistributorDto> distributorMapper;
    private final DtoMapper<Locality, LocalityDto> localityMapper;
    private final DtoMapper<Supervisor, SupervisorDto> supervisorMapper;

    private final AccountServiceImpl accountServiceImpl;
    private final DistributorServiceImpl distributorServiceImpl;
    private final LocalityServiceImpl localityServiceImpl;
    private final SupervisorServiceImpl supervisorServiceImpl;


    public Account mapAccount(AccountDto dto) {
        Account account = accountMapper.toEntity(dto);
        final Locality locality = localityServiceImpl.findByName(dto.getLocalityName());
        account.setLocality(locality);
        final Distributor distributor = distributorServiceImpl.findByName(dto.getDistributorName());
        account.setDistributor(distributor);
        return account;
    }

    public Distributor mapDistributor(DistributorDto dto) {
        Distributor distributor = distributorMapper.toEntity(dto);
        final List<Supervisor> supervisors = supervisorServiceImpl.findAllByLastName(dto.getSupervisorNames());
        distributor.setSupervisors(supervisors);
        final List<Account> accounts = accountServiceImpl.findAllByIdInternal(dto.getAccountIds());
        distributor.setAccounts(accounts);
        return distributor;
    }

    public Supervisor mapSupervisor(SupervisorDto dto) {
        Supervisor supervisor = supervisorMapper.toEntity(dto);
        final List<Locality> localities = localityServiceImpl.findAllByName(dto.getLocalityNames());
        supervisor.setLocalities(localities);
        final Distributor distributor = distributorServiceImpl.findByName(dto.getDistributorName());
        supervisor.setDistributor(distributor);
        return supervisor;
    }

    public Locality mapLocality(LocalityDto dto) {
        Locality locality = localityMapper.toEntity(dto);
        final List<Account> accounts = accountServiceImpl.findAllByIdInternal(dto.getAccountIds());
        locality.setAccounts(accounts);
        final List<Supervisor> supervisors = supervisorServiceImpl.findAllByLastName(dto.getSupervisorNames());
        locality.setSupervisors(supervisors);
        return locality;
    }
}
