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
        Locality apeldoorn = new Locality("Amersfoort", "photos/locality/Amersfoort.png", null, null);
        Locality zutphen = new Locality("Zutphen", "photos/locality/Zutphen.png", null, null);
        Locality putten = new Locality("Leiden", "photos/locality/Leiden.png", null, null);
        Locality rotterdam = new Locality("Rotterdam", "photos/Rotterdam.png", null, null);
        Locality utrecht = new Locality("Utrecht", "photos/locality/Utrecht.png", null, null);
        final List<Locality> localities = (List.of(apeldoorn, zutphen, putten, rotterdam, utrecht));
        return repository.saveAll(localities);
    }
}
