package com.dillian.energymanagement.services;

import com.dillian.energymanagement.dtos.SupervisorDto;
import com.dillian.energymanagement.entities.Supervisor;
import com.dillian.energymanagement.mappers.SupervisorMapper;
import com.dillian.energymanagement.repositories.SupervisorRepository;
import com.dillian.energymanagement.services.account.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SupervisorService {

    private final SupervisorRepository supervisorRepository;
    private final SupervisorMapper supervisorMapper;
    private final AccountService accountService;

    public SupervisorDto findById(Long id) {
        final Supervisor supervisor = supervisorRepository.findById(id).orElseThrow();
        SupervisorDto supervisorDto = supervisorMapper.toDto(supervisor);
        supervisorDto.setAccounts(accountService.getAll()
                .stream()
                .filter(account -> account.getSupervisor().getLastName().equals(supervisor.getLastName()))
                .map(account -> ));
    }
    public SupervisorDto findByLastName(String name) {
        Supervisor supervisor = supervisorRepository.findByLastName(name).orElseThrow();
        return supervisorMapper.toDto(supervisor);
    }
}
