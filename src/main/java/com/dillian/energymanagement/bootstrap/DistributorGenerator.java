package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.entities.Distributor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DistributorGenerator {

    public Distributor[] createWithBasicProperties() {
        final Distributor liander = new Distributor(1L, "Liander",
                "C:\\Java Projects\\EnergyManagement_api\\photos\\Liander.jpg", new ArrayList<>(), new ArrayList<>());
        final Distributor stedin = new Distributor(2L, "Stedin",
                "C:\\Java Projects\\EnergyManagement_api\\photos\\Stedin.jpg", new ArrayList<>(), new ArrayList<>());
        final Distributor enexis = new Distributor(3L, "Enexis",
                "C:\\Java Projects\\EnergyManagement_api\\photos\\Enexis.png", new ArrayList<>(), new ArrayList<>());
        final Distributor coteq = new Distributor(4L, "Coteq",
                "C:\\Java Projects\\EnergyManagement_api\\photos\\coteq.jpeg", new ArrayList<>(), new ArrayList<>());
        return new Distributor[]{liander, stedin, enexis, coteq};
    }
}
