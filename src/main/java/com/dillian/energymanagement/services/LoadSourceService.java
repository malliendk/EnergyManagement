package com.dillian.energymanagement.services;


import com.dillian.energymanagement.dtos.LoadSourceDto;

import java.util.List;

public interface LoadSourceService {
    LoadSourceDto findById(Long id);

    LoadSourceDto findByName(String name);

    List<LoadSourceDto> findAll();
}
