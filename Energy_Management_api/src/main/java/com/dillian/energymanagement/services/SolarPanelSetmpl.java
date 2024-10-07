package com.dillian.energymanagement.services;


import com.dillian.energymanagement.dtos.SolarPanelSetDto;
import com.dillian.energymanagement.entities.SolarPanelSet;
import com.dillian.energymanagement.mappers.SolarPanelSetMapper;
import com.dillian.energymanagement.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class SolarPanelSetmpl implements SolarPanelSetService {

    private final AccountRepository accountRepository;

    private final SolarPanelSetMapper solarPanelSetMapper;


    @Override
    public List<SolarPanelSetDto> getAll() {
        return accountRepository.findAll()
                .stream()
                .map(solarPanelSetMapper::toDto)
                .toList();
    }

    @Override
    public List<SolarPanelSetDto> getForDto(int offset, int limit) {
        List<SolarPanelSet> solarPanelSets = accountRepository.getWithOffsetAndLimit(offset, limit);
        return solarPanelSets
                .stream()
                .map(solarPanelSetMapper::toDto)
                .toList();
    }
}
