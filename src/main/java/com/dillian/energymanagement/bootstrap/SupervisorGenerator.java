package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.entities.Supervisor;
import com.dillian.energymanagement.repositories.SupervisorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@AllArgsConstructor
public class SupervisorGenerator {

    private final SupervisorRepository supervisorRepository;

    public Supervisor[] createSupervisors() {

        Supervisor supervisor1 = supervisorRepository.save(new Supervisor(1L, "Tessa", "Savours", new ArrayList<>(),
                new ArrayList<>(), "D:\\Java projects\\Energy Management\\photos\\Tessa Savours.png"));
        Supervisor supervisor2 = supervisorRepository.save(new Supervisor(2L, "Quillick", "Windsworth", new ArrayList<>(),
                new ArrayList<>(), "D:\\Java projects\\Energy Management\\photos\\Quillick Windsworth.png"));
        Supervisor supervisor3 = supervisorRepository.save(new Supervisor(2L, "Amelia", "Lupina", new ArrayList<>(),
                new ArrayList<>(), "D:\\Java projects\\Energy Management\\photos\\Amelia Lupina.png"));
        Supervisor supervisor4 = supervisorRepository.save(new Supervisor(2L, "Henrick", "Righthood", new ArrayList<>(),
                new ArrayList<>(), "D:\\Java projects\\Energy Management\\photos\\Henrick Righthood.png"));
        return new Supervisor[]{supervisor1, supervisor3, supervisor4};
    }
}
