package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.entities.Distributor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DistributorGenerator {

    public Distributor[] createWithBasicProperties() {
        final Distributor liander = new Distributor(1L, "Liander",
                "C:\\Java Projects\\EnergyManagement_api\\photos\\Liander.jpg", new ArrayList<>(), new ArrayList<>());
        final Distributor stedin = new Distributor(2L, "Qirion",
                "C:\\Java Projects\\EnergyManagement_api\\photos\\Stedin.jpg", new ArrayList<>(), new ArrayList<>());
        final Distributor enexis = new Distributor(3L, "Qterra",
                "C:\\Java Projects\\EnergyManagement_api\\photos\\Enexis.png", new ArrayList<>(), new ArrayList<>());
        final Distributor coteq = new Distributor(4L, "Dep",
                "C:\\Java Projects\\EnergyManagement_api\\photos\\coteq.jpeg", new ArrayList<>(), new ArrayList<>());
        final Distributor entrnce = new Distributor(5L, "Entrnce",
                "C\\Java projects\\EnergyManagement_api\\photos\\", null, null);
        return new Distributor[]{liander, stedin, enexis, coteq};
    }
}
