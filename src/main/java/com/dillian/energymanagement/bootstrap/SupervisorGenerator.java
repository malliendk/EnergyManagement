package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.entities.Supervisor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class SupervisorGenerator {

    public Supervisor[] createWithBasicProperties() {

        Supervisor supervisor1 = new Supervisor(1L, "Tessa", "Savours", new ArrayList<>(),
                new ArrayList<>(), "D:\\Java projects\\Energy Management\\photos\\Tessa Savours.png");
        Supervisor supervisor2 = new Supervisor(2L, "Quillick", "Windsworth", new ArrayList<>(),
                new ArrayList<>(), "D:\\Java projects\\Energy Management\\photos\\Quillick Windsworth.png");
        Supervisor supervisor3 = new Supervisor(2L, "Amelia", "Lupina", new ArrayList<>(),
                new ArrayList<>(), "D:\\Java projects\\Energy Management\\photos\\Amelia Lupina.png");
        Supervisor supervisor4 = new Supervisor(2L, "Henrick", "Righthood", new ArrayList<>(),
                new ArrayList<>(), "D:\\Java projects\\Energy Management\\photos\\Henrick Righthood.png");
        return new Supervisor[]{supervisor1, supervisor2, supervisor3, supervisor4};
    }
}
