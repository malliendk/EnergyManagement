package com.dillian.energymanagement.services;

import com.dillian.energymanagement.dtos.SolarPanelSetDto;

import java.util.List;

public interface SolarPanelSetService {

    List<SolarPanelSetDto> getAll();

    List<SolarPanelSetDto> getForDto(int offset, int limit);
}
