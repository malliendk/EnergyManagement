package com.dillian.energymanagement.services;

import com.dillian.energymanagement.dtos.SupervisorDto;
import com.dillian.energymanagement.entities.Supervisor;
import com.dillian.energymanagement.mappers.SupervisorMapper;
import com.dillian.energymanagement.repositories.SupervisorRepository;
import com.dillian.energymanagement.utils.Constants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SupervisorServiceImpl implements SupervisorService {

    private final SupervisorRepository supervisorRepository;
    private final SupervisorMapper supervisorMapper;

    @Override
    public SupervisorDto create(SupervisorDto supervisorDto) {
        Supervisor supervisor = supervisorMapper.toEntity(supervisorDto);
        supervisor = supervisorRepository.save(supervisor);
        return supervisorMapper.toDto(supervisor);
    }

    @Override
    public SupervisorDto findById(Long id) {
        final Supervisor supervisor = supervisorRepository.findById(id).orElseThrow();
        return supervisorMapper.toDto(supervisor);
    }

    @Override
    public SupervisorDto findByLastName(String name) {
        final Supervisor supervisor = supervisorRepository.findByLastName(name).orElseThrow();
        return supervisorMapper.toDto(supervisor);
    }


    @Override
    public List<SupervisorDto> findAll() {
        return supervisorRepository.findAll()
                .stream()
                .map(supervisorMapper::toDto)
                .toList();
    }
}
