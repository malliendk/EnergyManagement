package com.dillian.energymanagement.services;

import com.dillian.energymanagement.entities.Supervisor;
import com.dillian.energymanagement.repositories.SupervisorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SupervisorService {

    private final SupervisorRepository supervisorRepository;

    public Supervisor findById(Long id) {
        return supervisorRepository.findById(id)
                .orElseThrow();
    }
    public Supervisor findByName(String name) {
        return supervisorRepository.findByName(name)
                .orElseThrow();
    }
}
