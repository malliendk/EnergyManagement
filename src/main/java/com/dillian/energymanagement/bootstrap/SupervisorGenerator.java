package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.entities.Supervisor;
import com.dillian.energymanagement.repositories.SupervisorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SupervisorGenerator {

    private final SupervisorRepository repository;

    public List<Supervisor> createWithBasicProperties() {

        Supervisor supervisor1 = new Supervisor("Amelia", "Lupina",
                "photos/AmeliaLupina.png", 0.8, null, null );
        Supervisor supervisor2 = new Supervisor("Tessa", "Savours",
                "photos/TessaSavours.png", 0.8, null, null);
        Supervisor supervisor3 = new Supervisor("Kaito", "Tanaka",
                "photos/KaitoTanaka.png", 0.8,null, null);
        Supervisor supervisor4 = new Supervisor("Mateo", "Caldwell",
                "photos/MateoCaldwell.png", 0.8,null, null);

        final List<Supervisor> supervisors = List.of(supervisor1, supervisor2, supervisor3, supervisor4);
        return repository.saveAll(supervisors);
    }
}
