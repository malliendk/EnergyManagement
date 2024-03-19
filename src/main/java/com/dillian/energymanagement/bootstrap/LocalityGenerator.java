package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.entities.Locality;
import com.dillian.energymanagement.repositories.LocalityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LocalityGenerator {

    private final LocalityRepository repository;

    public List<Locality> createWithBasicProperties() {
        Locality apeldoorn = new Locality("Apeldoorn", null, null);
        Locality zutphen = new Locality("Zutphen", null, null);
        Locality putten = new Locality("Putten", null, null);
        Locality rotterdam = new Locality("Rotterdam", null, null);
        Locality utrecht = new Locality("Utrecht", null, null);
        final List<Locality> localities = (List.of(apeldoorn, zutphen, putten, rotterdam, utrecht));
        return repository.saveAll(localities);
    }
}
