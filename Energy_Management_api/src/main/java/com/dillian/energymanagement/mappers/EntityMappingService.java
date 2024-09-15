package com.dillian.energymanagement.mappers;

import com.dillian.energymanagement.dtos.AccountDto;
import com.dillian.energymanagement.dtos.LocalityDto;
import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.entities.Locality;
import com.dillian.energymanagement.entities.Supervisor;
import com.dillian.energymanagement.services.account.AccountServiceImpl;
import com.dillian.energymanagement.services.locality.LocalityServiceImpl;
import com.dillian.energymanagement.services.supervisor.SupervisorServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EntityMappingService {

    private final DtoMapper<Account, AccountDto> accountMapper;
    private final DtoMapper<Locality, LocalityDto> localityMapper;

    private final AccountServiceImpl accountServiceImpl;
    private final LocalityServiceImpl localityServiceImpl;
    private final SupervisorServiceImpl supervisorServiceImpl;


    public Account mapAccount(AccountDto dto) {
        Account account = accountMapper.toEntity(dto);
        final Locality locality = localityServiceImpl.findByName(dto.getLocalityName());
        account.setLocality(locality);
        return account;
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
