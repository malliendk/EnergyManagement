package com.dillian.energymanagement.services;

import com.dillian.energymanagement.dtos.SupervisorDto;
import com.dillian.energymanagement.entities.Supervisor;
import com.dillian.energymanagement.mappers.SupervisorMapper;
import com.dillian.energymanagement.repositories.SupervisorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SupervisorService {

    private final SupervisorRepository supervisorRepository;
    private final SupervisorMapper supervisorMapper;

    public Supervisor findById(Long id) {
        return supervisorRepository.findById(id)
                .orElseThrow();
    }
    public SupervisorDto findByLastName(String name) {
        Supervisor supervisor = supervisorRepository.findByLastName(name).orElseThrow();
        return supervisorMapper.toDto(supervisor);
    }
}
