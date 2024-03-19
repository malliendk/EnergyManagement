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
                "D:\\Java projects\\Energy Management\\photos\\Amelia Lupina.png", null, null );
        Supervisor supervisor2 = new Supervisor("Tessa", "Savours",
                "D:\\Java projects\\Energy Management\\photos\\Tessa Savours.png", null, null);
        Supervisor supervisor3 = new Supervisor("Quillick", "Windsworth",
                "D:\\Java projects\\Energy Management\\photos\\Quillick Windsworth.png", null, null);
        Supervisor supervisor4 = new Supervisor("Henrick", "Righthood",
                "D:\\Java projects\\Energy Management\\photos\\Henrick Righthood.png", null, null);
        final List<Supervisor> supervisors = List.of(supervisor1, supervisor2, supervisor3, supervisor4);
        return repository.saveAll(supervisors);
    }
}
