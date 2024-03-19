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
                "C:\\Java Projects\\EnergyManagement_api\\photos\\Liander.jpg", null, null);
        final Distributor stedin = new Distributor("Steding",
                "C:\\Java Projects\\EnergyManagement_api\\photos\\Stedin.jpg", null, null);
        final Distributor enexis = new Distributor("Qterra",
                "C:\\Java Projects\\EnergyManagement_api\\photos\\Qterra.png", null, null);
        final Distributor coteq = new Distributor("Dep",
                "C:\\Java Projects\\EnergyManagement_api\\photos\\Dep.jpeg", null, null);
        final Distributor entrnce = new Distributor("Entrnce",
                "C\\Java projects\\EnergyManagement_api\\photos\\Entrnce", null, null);
        final List<Distributor> distributors = List.of(liander, stedin, enexis, coteq, entrnce);
        return repository.saveAll(distributors);
    }
}
