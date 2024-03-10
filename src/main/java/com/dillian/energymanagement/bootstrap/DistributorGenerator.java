package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.entities.Distributor;
import com.dillian.energymanagement.repositories.DistributorRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DistributorGenerator {

    public Distributor[] createWithSimpleProperties() {
        final Distributor liander = new Distributor(1L, "Liander", new ArrayList<>(), new ArrayList<>());
        final Distributor stedin = new Distributor(2L, "Stedin", new ArrayList<>(), new ArrayList<>());
        final Distributor enexis = new Distributor(3L, "Enexis", new ArrayList<>(), new ArrayList<>());
        final Distributor coteq = new Distributor(4L, "Coteq", new ArrayList<>(), new ArrayList<>());
        return new Distributor[]{liander, stedin};
    }
}
