package com.dillian.energymanagement.services;

import com.dillian.energymanagement.repositories.LocalityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LocalityService {

    private final LocalityRepository localityRepository;
}
