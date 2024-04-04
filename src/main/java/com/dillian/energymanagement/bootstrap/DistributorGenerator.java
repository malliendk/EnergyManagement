package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.entities.Distributor;
import com.dillian.energymanagement.repositories.DistributorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DistributorGenerator {

    private final DistributorRepository repository;

    public List<Distributor> createWithBasicProperties() {
        final Distributor liander = new Distributor("Liander",
                "photos/Liander.png", null, null);
        final Distributor stedin = new Distributor("Stedin",
                "photos/Stedin.png", null, null);
        final Distributor enexis = new Distributor("Coteq",
                "photos/Coteq.png", null, null);
        final Distributor coteq = new Distributor("Enexis",
                "photos/Enexis.png", null, null);
        final List<Distributor> distributors = List.of(liander, stedin, enexis, coteq);
        return repository.saveAll(distributors);
    }
}
