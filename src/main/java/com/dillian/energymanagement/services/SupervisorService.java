package com.dillian.energymanagement.services;

import com.dillian.energymanagement.dtos.DistributorDto;
import com.dillian.energymanagement.dtos.SupervisorDto;
import com.dillian.energymanagement.entities.Distributor;
import com.dillian.energymanagement.entities.Supervisor;
import com.dillian.energymanagement.mappers.DistributorMapper;
import com.dillian.energymanagement.mappers.DtoMapper;
import com.dillian.energymanagement.mappers.SupervisorMapper;
import com.dillian.energymanagement.repositories.SupervisorRepository;
import com.dillian.energymanagement.services.account.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SupervisorService {

    private final SupervisorRepository supervisorRepository;
    private final SupervisorMapper supervisorMapper;
    private final DistributorMapper distributorMapper;
    private final AccountService accountService;


    public SupervisorDto findById(Long id) {
        final Supervisor supervisor = supervisorRepository.findById(id).orElseThrow();
        return mapToDto(supervisor);
    }

    public SupervisorDto findByLastName(String name) {
        final Supervisor supervisor = supervisorRepository.findByLastName(name).orElseThrow();
        return mapToDto(supervisor);
    }

    private SupervisorDto mapToDto(Supervisor supervisor) {
        SupervisorDto supervisorDto = supervisorMapper.toDto(supervisor);
        supervisorDto.setAccounts(accountService.getAll()
                .stream()
                .filter(account -> account.getSupervisor().getLastName().equals(supervisor.getLastName()))
                .toList());
        supervisorDto.setDistributors(supervisor.getDistributors()
                .stream()
                .map(distributorMapper::toDto)
                .toList());
        return supervisorDto;
    }
}
