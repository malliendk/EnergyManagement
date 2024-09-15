package com.dillian.energymanagement.services.supervisor;

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
    public SupervisorDto create(Supervisor supervisor) {
        supervisor = supervisorRepository.save(supervisor);
        return supervisorMapper.toDto(supervisor);
    }


    @Override
    public SupervisorDto findById(Long id) {
        final Supervisor supervisor = supervisorRepository.findById(id).orElseThrow();
        return supervisorMapper.toDto(supervisor);
    }

    public Supervisor findByLastName(String name) {
        return supervisorRepository.findByLastName(name).orElseThrow();
    }

    @Override
    public SupervisorDto findByLocalityName(String localityName) {
        Supervisor supervisor = supervisorRepository.findByLocalityName(localityName).orElseThrow();
        return supervisorMapper.toDto(supervisor);
    }

    @Override
    public List<SupervisorDto> findAll() {
        return supervisorRepository.findAll()
                .stream()
                .map(supervisorMapper::toDto)
                .toList();
    }

    public List<Supervisor> findAllByLastName(List<String> lastNames) {
        return supervisorRepository.findAllByLastNameIn(lastNames);
    }

    public List<SupervisorDto> findAllByDistributor(String distributorName) {
        return supervisorRepository.findAllByDistributorName(distributorName)
                .stream()
                .map(supervisorMapper::toDto)
                .toList();
    }

    @Override
    public SupervisorDto update(Long id, Supervisor supervisor) {
        if (!id.equals(supervisor.getId())){
            throw new SupervisorException(Constants.IDS_DONT_MATCH);
        }
        supervisor = supervisorRepository.save(supervisor);
        return supervisorMapper.toDto(supervisor);
    }

    @Override
    public void delete(Long id) {
        supervisorRepository.deleteById(id);
    }
}
