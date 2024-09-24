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

    public void createInitialSupervisors() {

        Supervisor ameliaLupina = new Supervisor(
                "Amelia",
                "Lupina",
                "photos/AmeliaLupina.png",
                0.1,
                1.1,
                0.6);
        Supervisor tessaSavours = new Supervisor(
                "Tessa",
                "Savours",
                "photos/TessaSavours.png",
                0.0,
                1.2,
                0.5);
        Supervisor kaitoTanaka = new Supervisor(
                "Kaito",
                "Tanaka",
                "photos/KaitoTanaka.png",
                0.0,
                1.0,
                0.7);
        Supervisor mateoCaldwell = new Supervisor(
            "Mateo",
            "Caldwell",
            "photos/MateoCaldwall.png",
            0.2,
            1,
            0.5);
        repository.saveAll(List.of(ameliaLupina, tessaSavours, kaitoTanaka, mateoCaldwell));
    }
}
