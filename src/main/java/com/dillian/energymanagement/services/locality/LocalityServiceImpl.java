package com.dillian.energymanagement.services.locality;

import com.dillian.energymanagement.dtos.LocalityDto;
import com.dillian.energymanagement.entities.Locality;
import com.dillian.energymanagement.exceptions.LocalityException;
import com.dillian.energymanagement.mappers.DtoMapper;
import com.dillian.energymanagement.repositories.LocalityRepository;
import com.dillian.energymanagement.utils.Constants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LocalityServiceImpl implements LocalityService {

    private final LocalityRepository localityRepository;
    private final DtoMapper<Locality, LocalityDto> localityMapper;



    @Override
    public LocalityDto create(Locality locality) {
        locality = localityRepository.save(locality);
        return localityMapper.toDto(locality);
    }

    @Override
    public List<LocalityDto> findAll() {
        return localityRepository.findAll()
                .stream()
                .map(localityMapper::toDto)
                .toList();
    }

    public List<Locality> findAllByName(List<String> names) {
        return localityRepository.findAllByNameIn(names);
    }

    public List<LocalityDto> findAllBySupervisor(String lastName) {
        return localityRepository.findAllBySupervisorLastName(lastName)
                .stream()
                .map(localityMapper::toDto)
                .toList();
    }

    @Override
    public LocalityDto findById(Long id) {
        final Locality locality = localityRepository.findById(id).orElseThrow();
        return localityMapper.toDto(locality);
    }

    public Locality findByName(String name) {
        return localityRepository.findByName(name).orElseThrow();
    }

    @Override
    public LocalityDto update(Long id, Locality locality) {
        if (!id.equals(locality.getId())){
            throw new LocalityException(Constants.IDS_DONT_MATCH);
        }
        locality = localityRepository.save(locality);
        return localityMapper.toDto(locality);
    }

    @Override
    public void delete(Long id) {
        localityRepository.deleteById(id);
    }
}
