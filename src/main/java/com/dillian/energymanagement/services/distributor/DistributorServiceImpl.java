package com.dillian.energymanagement.services.distributor;

import com.dillian.energymanagement.dtos.DistributorDto;
import com.dillian.energymanagement.entities.Distributor;
import com.dillian.energymanagement.exceptions.DistributorException;
import com.dillian.energymanagement.mappers.DtoMapper;
import com.dillian.energymanagement.repositories.DistributorRepository;
import com.dillian.energymanagement.utils.Constants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DistributorServiceImpl implements DistributorService {

    private final DistributorRepository distributorRepository;
    private final DtoMapper<Distributor, DistributorDto> distributorMapper;


    @Override
    public DistributorDto create(Distributor distributor) {
        distributor = distributorRepository.save(distributor);
        return distributorMapper.toDto(distributor);
    }

    @Override
    public List<DistributorDto> findAll() {
        return distributorRepository.findAll().stream().map(distributorMapper::toDto).toList();
    }

    public List<Distributor> findAllByNameInternal(List<String> names) {
        return distributorRepository.findAllByNameIn(names);
    }

    @Override
    public DistributorDto findById(Long id) {
        Distributor distributor = distributorRepository.findById(id).orElseThrow();
        return distributorMapper.toDto(distributor);
    }

    public Distributor findByName(String name) {
        return distributorRepository.findByName(name).orElseThrow();
    }

    @Override
    public DistributorDto update(Long id, Distributor distributor) {
        if (!id.equals(distributor.getId())) {
            throw new DistributorException(Constants.IDS_DONT_MATCH);
        }
        distributor = distributorRepository.save(distributor);
        return distributorMapper.toDto(distributor);
    }

    @Override
    public void delete(Long id) {
        distributorRepository.deleteById(id);
    }
}
