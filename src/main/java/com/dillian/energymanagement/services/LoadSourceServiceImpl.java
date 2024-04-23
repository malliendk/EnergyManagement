package com.dillian.energymanagement.services;


import com.dillian.energymanagement.dtos.LoadSourceDto;
import com.dillian.energymanagement.entities.LoadSource;
import com.dillian.energymanagement.mappers.DtoMapper;
import com.dillian.energymanagement.repositories.LoadSourceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LoadSourceServiceImpl implements LoadSourceService {

    private final DtoMapper<LoadSource, LoadSourceDto> mapper;

    private final LoadSourceRepository loadSourceRepository;

    @Override
    public List<LoadSourceDto> findAll() {
        return loadSourceRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public LoadSourceDto findById(Long id){
        return loadSourceRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow();
    }

    public LoadSource findByNameInternal(String name) {
        return loadSourceRepository.findByName(name).orElseThrow();
    }

    @Override
    public LoadSourceDto findByName(String name){
        return loadSourceRepository.findByName(name)
                .map(mapper::toDto)
                .orElseThrow();
    }

    public List<LoadSource> saveAllInternal(List<LoadSource> sources) {
        return loadSourceRepository.saveAll(sources);
    }

}
